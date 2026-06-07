package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingWithUserCar;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class GameWorldManager extends GamePlayManager {

    private final List<GameObject> activatableGameObjects;

    /**
     * Create a instance of GamePlayManager.
     *
     * @param gameView Instance of GameView.
     */
    protected GameWorldManager(GameView gameView) {
        super(gameView);
        userCar = new UserCar(gameView, this);
        shot = new UserShot(gameView, this);
        start = new Start(gameView, this);
        gate = new Gate(gameView, this);
        street = new Street(gameView, this);
        helicopter = new Helicopter(gameView, this);
        policeCar = new PoliceCar(gameView, this);
        randomCar = new RandomCar(gameView, this);
        score = new Score(gameView, this);
        progressBarBlockImages = new ProgressBarBlockImages(gameView, this);
        houseLeft = new HouseLeft(gameView, this);
        houseRight = new HouseRight(gameView, this);
        countdown = new Countdown(gameView, this);
        activatableGameObjects = new LinkedList<>();
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        activateGameObjects();
    }

    private void spawnGameObjects() {
        spawnGameObject(gate);
        spawnGameObject(start);
        spawnGameObject(progressBarBlockImages);
        spawnGameObject(score);
        spawnGameObject(countdown);
        spawnGameObject(new Jimmy(gameView, this));
        addActivatableGameObject(helicopter);
    }

    protected void initializeLevel() {
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
                GameObject spawnObject = createGameObject(row, lines[column]);
                if (spawnObject instanceof CollidingGameObject collidingGameObject) {
                    addGameObjectForCollision(collidingGameObject);
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
                        default -> spawnGameObject(spawnObject);
                    }
                }
            }
        }
    }

    private void addGameObjectForCollision(CollidingGameObject collidingGameObject) {
        if (collidingGameObject instanceof CollidingWithUserCar) {
            userCar.addGameObjectsForCollision(collidingGameObject);
        }

    }

    private GameObject createGameObject(int row, String lines) {
        char character = lines.charAt(row);
        GameObject spawnObject = switch (character) {
            case 'L' -> spawnLeftHouse();
            case 'P' -> new PoliceCar(gameView, this);
            case 'C' -> new RandomCar(gameView, this);
            case 'R' -> spawnRightHouse();
            case 'S' -> new Street(gameView, this);
            case 'U' -> userCar;
            case 'D' -> new DirtRoad(gameView, this);
            case 'E' -> new Dirt(gameView, this);
            case 'F' -> new Field(gameView, this);
            case 'B' -> new StreetBorderLeft(gameView, this);
            case 'b' -> new StreetBorderLeftMirror(gameView, this);
            case 'G' -> new Green(gameView, this);
            case 'g' -> new GreenRight(gameView, this);
            case 'Q' -> new GreenWithStreet(gameView, this);
            case 'f' -> new Finish(gameView, this);
            default -> null;
        };
        return spawnObject;
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    private void prepareSpawnGameObject(GameObject gameObject, double row, double column) {
        gameObject.getPosition().updateCoordinates((row - level.worldOffsetLines), (column - level.worldOffsetColumns));
        // gameObject.getPosition().updateCoordinates((row) * WORLD_MULTIPLIER, (column) * WORLD_MULTIPLIER);
        // spawnGameObject(gameObject);
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
