package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.UserCar;

public class GameViewManager {

    private final GameView gameView;
    GameManager gameManager;

    public GameViewManager() {
        gameView = new GameView();
        gameManager = new GameManager(gameView);


        startGameLoop();
    }

    private void startGameLoop() {
        gameManager.processFrame();
    }
}
