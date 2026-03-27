package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.UserCar;

public class GameManager {

    private final GameView gameView;
    private UserCar userCar;

    public GameManager(GameView gameView) {
        this.gameView = gameView;
        userCar = new UserCar(this.gameView);
    }

    void processFrame(){
        while (gameView.isVisible()) {
            userCar.addToCanvas();
            gameView.plotCanvas();
        }
    }
}
