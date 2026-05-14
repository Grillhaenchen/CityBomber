package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class GameWorldManager extends GamePlayManager {
    private final int worldOffsetColumns;
    private final int worldOffsetLines;
    private final String world;

    private final List<GameObject> activatableGameObjects;

    /**
     * Create a instance of GamePlayManager.
     *
     * @param gameView Instance of GameView.
     */
    protected GameWorldManager(GameView gameView) {
        super(gameView);

        world = """ 
                            \s
                L  S       R\s
                       P    \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s  
                L  SU      R\s""";

        worldOffsetColumns = 27;
        worldOffsetLines = 0;

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
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
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

    private void spawnGameObjectsFromWorldString() {
        String[] lines = world.split("\\R");
        final int WORLD_FACTOR = 100;

        for (int row = 0; row < lines[0].length(); row++) {
            for (int column = 0; column < lines.length; column++) {
                double y = (column - worldOffsetColumns) * WORLD_FACTOR;
                double x = (row - worldOffsetLines) * WORLD_FACTOR;
                char character = lines[column].charAt(row);
                GameObject spawnObject = null;
                if (character == 'L') {
                    spawnObject = new HouseLeft(gameView, this);
                } else if (character == 'P') {
                    spawnObject = new PoliceCar(gameView, this);
                } else if (character == 'C') {
                    spawnObject = new RandomCar(gameView, this);
                } else if (character == 'R') {
                    spawnObject = new HouseRight(gameView, this);
                } else if (character == 'S') {
                    spawnObject = new Street(gameView, this);
                } else if (character == 'U') {
                    spawnObject = userCar;
                }

                if (spawnObject != null) {
                    spawnObject.getPosition().updateCoordinates(x, y);
                    if (spawnObject instanceof Helicopter) {
                        addActivatableGameObject(spawnObject);
                    } else if (spawnObject instanceof Street) {
                        spawnObject.getPosition().updateCoordinates(x - 30, y);
                        spawnGameObject(spawnObject);
                    } else if (spawnObject instanceof HouseRight) {
                        spawnObject.getPosition().updateCoordinates(x - 30, y);
                        spawnGameObject(spawnObject);
                    } else {
                        spawnGameObject(spawnObject);
                    }
                }
            }
        }
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    private void prepareSpawnGameObject(GameObject gameObject, double row, double column) {
        gameObject.getPosition().updateCoordinates((row - worldOffsetLines), (column - worldOffsetColumns));

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
