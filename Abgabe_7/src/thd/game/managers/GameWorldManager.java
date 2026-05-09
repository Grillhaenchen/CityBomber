package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GameWorldManager extends GamePlayManager {
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
                    PP  P              B                 \s
                  P P B   P            B                 \s 
                P   P B     P          B                 \s 
                    P B                B                 \s 
                    P B                B                 \s 
                    P B                B                 \s 
                R   P B  U  R          B                 \s
                    P B B              B          P  P   \s
                  P P B   P            B                 \s 
                P   P B     P          B                 \s 
                    P B                B                 \s 
                    P B                B                 \s 
                    P B                B                 \s 
                R   P B  U  R          B                 \s""";

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
        worldOffsetColumns = 14;
        worldOffsetLines = 4;
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        activateGameObjects();
    }

    private void spawnGameObjects() {
        spawnGameObject(houseLeft);
        spawnGameObject(houseRight);
        spawnGameObject(gate);
        spawnGameObject(start);
        spawnGameObject(progressBarBlockImages);
        spawnGameObject(street);
        spawnGameObject(score);
        spawnGameObject(countdown);

        addActivatableGameObject(helicopter);
        addActivatableGameObject(policeCar);
        addActivatableGameObject(randomCar);

        spawnGameObject(userCar);
    }


    private void spawnGameObjectsFromWorldString() {
        String[] lines = world.split("\\R");
        final int WORLD_FACTOR = 100;

        for (int row = 0; row < lines[0].length(); row++) {
            for (int column = 0; column < lines.length; column++) {
                double x = (column - worldOffsetColumns) * WORLD_FACTOR;
                double y = (row - worldOffsetLines) * WORLD_FACTOR;
                char character = lines[column].charAt(row);
                GameObject spawnObject = null;
                if (character == 'U') {
                    spawnObject = new UserCar(gameView, this);
                } else if (character == 'P') {
                    spawnObject = new PoliceCar(gameView, this);
                } else if (character == 'R') {
                    spawnObject = new RandomCar(gameView, this);
                } else if (character == 'B') {
                    spawnObject = new Street(gameView, this);
                }

                if (spawnObject != null) {
                    spawnObject.getPosition().updateCoordinates(x, y);
                    spawnGameObject(spawnObject);
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
                if (randomCar.tryToActivate(randomCar)) {
                    spawnGameObject(randomCar);
                }
            } else if (gameObject instanceof Helicopter helicopter) {
                if (helicopter.tryToActivate(helicopter)) {
                    spawnGameObject(helicopter);
                }
            } else if (gameObject instanceof PoliceCar policeCar) {
                if (policeCar.tryToActivate(policeCar)) {
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
