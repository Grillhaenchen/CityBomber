package thd.game.managers;

import thd.game.utilities.GameView;
import thd.game.utilities.UiElementNames;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingWithUserCar;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.RoadUser;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class GameWorldManager extends GamePlayManager {

    private final List<GameObject> activatableGameObjects;
    private GameObject referenceObject;

    /**
     * Create a instance of GamePlayManager.
     *
     * @param gameView Instance of GameView.
     */
    protected GameWorldManager(GameView gameView) {
        super(gameView);
        userCar = new UserCar(gameView, this);
        shot = new UserShot(gameView, this);

        street = new Street(gameView, this);
        helicopter = new Helicopter(gameView, this);
        score = new Score(gameView, this);
        lives1 = new Lives(gameView, this);
        countdown = new Countdown(gameView, this);
        overlay = new Overlay(gameView, this, "droidsansmono.ttf");
        activatableGameObjects = new LinkedList<>();
        lives1.setLives(lives);
        referenceObject = null;
    }

    private void initGame() {
        userCar = new UserCar(gameView, this);
        shot = new UserShot(gameView, this);

        street = new Street(gameView, this);
        helicopter = new Helicopter(gameView, this);
        score = new Score(gameView, this);
        lives1 = new Lives(gameView, this);
        countdown = new Countdown(gameView, this);
        overlay = new Overlay(gameView, this, "droidsansmono.ttf");
        activatableGameObjects.clear();
        lives1.setLives(lives);
        referenceObject = null;
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        activateGameObjects();
    }

    private void spawnGameObjects() {
        spawnGameObject(score);
        spawnGameObject(lives1);
        addActivatableGameObject(helicopter);
        spawnGameObject(overlay);
    }

    protected void initializeLevel() {
        initGame();
        userCar.setFinished(false);
        activatableGameObjects.clear();
        destroyAllGameObjects();
        clearListsForPathDecisionsInGameObjects();
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
    }

    private void clearListsForPathDecisionsInGameObjects() {
    }

    private void spawnGameObjectsFromWorldString() {
        String[] lines = level.world.split("\\R");
        final int WORLD_FACTOR = 200;
        for (int row = 0; row < lines[0].length(); row++) {
            for (int column = 0; column < lines.length; column++) {
                double y = (column - level.worldOffsetColumns) * WORLD_FACTOR;
                double x = (row - level.worldOffsetLines) * WORLD_FACTOR;
                if (lines[column].charAt(row) == UiElementNames.POLICE_ROADBLOCK.uiType) {

                    int roadBlockWidth = new Random().nextInt() % 5; // spawn 3-4 cars
                    final double STREET_WIDTH = 800.0; // width of the street in pixels

                    double spacing = STREET_WIDTH / roadBlockWidth;
                    double startX = x - (STREET_WIDTH / 2.0) + (spacing / 2.0);
                    for (int i = 0; i < roadBlockWidth; i++) {
                        PoliceCar policecar = new PoliceCar(gameView, this);
                        double carX = startX + (i * spacing);
                        policecar.getPosition().updateCoordinates(carX, y - 130);
                        spawnGameObject(policecar);
                    }
                } else {
                    GameObject spawnObject = createGameObject(row, lines[column]);
                    if (spawnObject instanceof CollidingGameObject collidingGameObject) {
                        addGameObjectForCollision(collidingGameObject);
                    }
                    if (spawnObject instanceof RoadUser roadUser) {
                        userCar.addRoadUsers((GameObject) roadUser);
                    }

                    if (spawnObject != null) {
                        spawnObject.getPosition().updateCoordinates(x, y);
                        switch (spawnObject) {
                            case Helicopter helicopter1 -> addActivatableGameObject(spawnObject);
                            case Street street1 -> {
                                spawnObject.getPosition().updateCoordinates(x - 130, y);
                                spawnGameObject(spawnObject);
                            }
                            case HouseRight right -> {

                                spawnObject.getPosition().updateCoordinates(x + 68, y);
                                spawnGameObject(spawnObject);
                            }
                            case UserCar car -> {
                                userCar.getPosition().up(50);
                                spawnGameObject(spawnObject);
                            }
                            default -> spawnGameObject(spawnObject);
                        }
                    }
                }
            }
        }
        writeReferenceObject();
    }

    private void writeReferenceObject() {
        RandomCar.referenceObject = this.referenceObject;
        RandomCar.referenceUserCar = this.userCar;
    }

    private void addGameObjectForCollision(CollidingGameObject collidingGameObject) {
        if (collidingGameObject instanceof CollidingWithUserCar) {
            userCar.addGameObjectsForCollision(collidingGameObject);
        }
    }

    private GameObject createGameObject(int row, String lines) {
        char character = lines.charAt(row);
        UiElementNames names = UiElementNames.fromChar(character);

        return switch (names) {
            case UiElementNames.LEFT_HOUSE -> {
                if (referenceObject == null) {
                    referenceObject = spawnLeftHouse();
                    yield referenceObject;
                } else {
                    yield spawnLeftHouse();
                }
            }
            case UiElementNames.RIGHT_HOUSE -> spawnRightHouse();

            case UiElementNames.STREET -> new Street(gameView, this);
            case UiElementNames.DIRT_ROAD -> new DirtRoad(gameView, this);
            case UiElementNames.DIRT -> new Dirt(gameView, this);
            case UiElementNames.STREET_BORDER_LEFT -> new StreetBorderLeft(gameView, this);
            case UiElementNames.STREET_BORDER_LEFT_MIRROR -> new StreetBorderLeftMirror(gameView, this);
            case UiElementNames.GREEN -> new Green(gameView, this);
            case UiElementNames.GREEN_RIGHT -> new GreenRight(gameView, this);
            case UiElementNames.GREEN_WITH_STREET -> new GreenWithStreet(gameView, this);

            case UiElementNames.POLICE_CAR -> new PoliceCar(gameView, this);
            case UiElementNames.RANDOM_CAR -> new RandomCar(gameView, this);

            case UiElementNames.USER_CAR -> userCar;

            case UiElementNames.FIELD -> new Field(gameView, this);

            case UiElementNames.FINISH -> new Finish(gameView, this);

            case TRIGGER_TO_LEFT -> new MoveLeftTrigger(gameView, this);
            case TRIGGER_TO_RIGHT -> new MoveRightTrigger(gameView, this);
            case TRIGGER_TO_STRAIGHT -> new MoveStraightTrigger(gameView, this);


            default -> null;
        };
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    private void activateGameObjects() {
        ListIterator<GameObject> iterator = activatableGameObjects.listIterator();

        while (iterator.hasNext()) {
            GameObject gameObject = iterator.next();

            if (gameObject instanceof RandomCar randomCar) {
                if (randomCar.tryToActivate(userCar)) {
                    spawnGameObject(randomCar);
                    iterator.remove();
                }
            } else if (gameObject instanceof Helicopter helicopter) {
                if (helicopter.tryToActivate(userCar)) {
                    spawnGameObject(helicopter);
                    iterator.remove();
                }
            } else if (gameObject instanceof PoliceCar policeCar) {
                if (policeCar.tryToActivate(userCar)) {
                    spawnGameObject(policeCar);
                    iterator.remove();
                }
            }
        }
    }

    @Override
    protected void processFrameUpdate() {
        super.processFrameUpdate();
        activateGameObjects();
    }

    private GameObject spawnLeftHouse() {
        int rand = (int) (Math.random() * 100 % 4);
        return switch (rand) {
            case 0 -> new HouseLeft(gameView, this);
            case 1 -> new HouseLeft1(gameView, this);
            case 2 -> new HouseLeft2(gameView, this);
            case 3 -> new HouseLeft3(gameView, this);
            default -> throw new IndexOutOfBoundsException("Spawn HouseLeft out of bounds");
        };
    }

    private GameObject spawnRightHouse() {
        int rand = (int) (Math.random() * 100 % 4);
        return switch (rand) {
            case 0 -> new HouseRight(gameView, this);
            case 1 -> new HouseRight1(gameView, this);
            case 2 -> new HouseRight2(gameView, this);
            case 3 -> new HouseRight3(gameView, this);
            default -> throw new IndexOutOfBoundsException("Spawn HouseRight out of bounds");
        };
    }
}
