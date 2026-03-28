package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.UserCar;
import thd.gameobjects.movable.UserShot;

public class GameManager {

    private final GameView gameView;
    private UserCar userCar;
    private UserShot shot;

    public GameManager(GameView gameView) {
        this.gameView = gameView;
        userCar = new UserCar(gameView);
        shot = new UserShot(gameView);
    }

    void processFrame(){
        userCar.addToCanvas();
        userCar.updatePosition();
        shot.addToCanvas();
    }
}
