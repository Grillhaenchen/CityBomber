package thd.game.managers;

import thd.game.utilities.GameView;
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
        final int WORLD_FACTOR = 100;
        for (int row = 0; row < lines[0].length(); row++) {
            for (int column = 0; column < lines.length; column++) {
                double y = (column - level.worldOffsetColumns) * WORLD_FACTOR;
                double x = (row - level.worldOffsetLines) * WORLD_FACTOR;
                GameObject spawnObject = createGameObject(row, lines[column]);

                if (spawnObject != null) {
                    spawnObject.getPosition().updateCoordinates(x, y);
                    switch (spawnObject) {
                        case Helicopter helicopter1 -> addActivatableGameObject(spawnObject);
                        case Street street1 -> {
                            spawnObject.getPosition().updateCoordinates(x - 30, y);
                            spawnGameObject(spawnObject);
                        }
                        case HouseRight right -> {
                            spawnObject.getPosition().updateCoordinates(x - 30, y);
                            spawnGameObject(spawnObject);
                        }
                        default -> spawnGameObject(spawnObject);
                    }
                }
            }
        }
    }

    private GameObject createGameObject(int row, String lines) {
        char character = lines.charAt(row);
        GameObject spawnObject = switch (character) {
            case 'L' -> new HouseLeft(gameView, this);
            case 'P' -> new PoliceCar(gameView, this);
            case 'C' -> new RandomCar(gameView, this);
            case 'R' -> new HouseRight(gameView, this);
            case 'S' -> new Street(gameView, this);
            case 'U' -> userCar;
            case 'D' -> new DirtRoad(gameView, this);
            case 'E' -> new Dirt(gameView, this);
            case 'F' -> new Field(gameView, this);
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
}
