package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

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


        spawnGameObject(houseLeft);
        spawnGameObject(houseRight);
        spawnGameObject(gate);
        spawnGameObject(start);
        spawnGameObject(progressBarBlockImages);
        spawnGameObject(street);
        spawnGameObject(score);
        spawnGameObject(countdown);

        spawnGameObject(helicopter);
        spawnGameObject(policeCar);
        spawnGameObject(randomCar);

        spawnGameObject(userCar);
    }

    @Override
    protected void processFrame() throws TooManyGameObjectsException {
        super.processFrame();
        gameManagement();
    }

    private void gameManagement() {
    }
}
