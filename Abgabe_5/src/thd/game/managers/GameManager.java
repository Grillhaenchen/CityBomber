package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Score;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

/**
 * The GameManager handles all the Game Items and processes the Frame.
 */
class GameManager extends GamePlayManager {

    /**
     * Create a new GameManager.
     *
     * @param gameView GameView instance
     */
    GameManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
        userCar = new UserCar(gameView);
        shot = new UserShot(gameView);
        start = new Start(gameView);
        gate = new Gate(gameView);
        street = new Street(gameView);
        helicopter = new Helicopter(gameView);
        policeCar = new PoliceCar(gameView);
        randomCar = new RandomCar(gameView);
        score = new Score(gameView);


        spawnGameObject(userCar);
        spawnGameObject(shot);
        spawnGameObject(gate);
        spawnGameObject(street);
        spawnGameObject(score);

        spawnGameObject(helicopter);
        spawnGameObject(policeCar);
        spawnGameObject(randomCar);
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameManagement();
    }

    private void gameManagement() {
    }
}
