package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Score;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

import java.util.LinkedList;
import java.util.List;

public class GameWorldManager extends GamePlayManager {
    int worldOffsetColumns;
    int worldOffsetLines;

    String world = """ 
            B   P  P    \s
              P      P  \s 
            P          P\s 
                        \s 
                        \s 
                        \s 
            R       U  R\s""";

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
        spawnGameObjects();
        spawnGameObjectsFromWorldString();
        worldOffsetColumns = 14;
        worldOffsetLines = 4;
        activatableGameObjects=new LinkedList<>();
    }

    public void spawnGameObjects() {
        spawnGameObject(userCar);
        spawnGameObject(gate);
        spawnGameObject(street);
        spawnGameObject(score);

        spawnGameObject(helicopter);
        spawnGameObject(policeCar);
        spawnGameObject(randomCar);
    }

    void spawnGameObjectsFromWorldString() {
        String[] lines = world.split("\\R");
        final int WORLD_FACTOR = 100;

        for (int row = 0; row < lines[0].length(); row++) {
            for (int column = 0; column < lines.length; column++) {
                if (lines[column].charAt(row) == 'U') {
                    UserCar userCar1 = new UserCar(gameView, this);
                    userCar1.getPosition().updateCoordinates(row * 100, column + 100);
                    spawnGameObject(userCar1);
                } else if (lines[column].charAt(row) == 'P') {
                    PoliceCar policeCar1 = new PoliceCar(gameView, this);
                    policeCar1.getPosition().updateCoordinates(row * 100, column + 100);
                    spawnGameObject(policeCar1);
                } else if (lines[column].charAt(row) == 'R') {
                    RandomCar randomCar1 = new RandomCar(gameView, this);
                    randomCar1.getPosition().updateCoordinates(row * 100, column + 100);
                    spawnGameObject(randomCar1);
                }

            }
        }
    }

    private void addActivatableGameObject(GameObject gameObject) {
        activatableGameObjects.add(gameObject);
        addToShiftableGameObjectsIfShiftable(gameObject);
    }

    @Override
    protected void processFrameUpdate() {
        super.processFrameUpdate();
        activateGameObjects();
    }
}
