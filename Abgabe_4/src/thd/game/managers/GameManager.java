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
class GameManager extends UserControlledGameObjectPool{

    private final GameObjectManager gameObjectManager;

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


        gameObjectManager.add(userCar);
        gameObjectManager.add(shot);
        gameObjectManager.add(gate);
        gameObjectManager.add(street);
        gameObjectManager.add(score);

        gameObjectManager.add(helicopter);
        gameObjectManager.add(policeCar);
        gameObjectManager.add(randomCar);
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameObjectManager.processFrame();
    }
}
