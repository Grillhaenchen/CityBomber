package thd.game.managers;

import thd.game.utilities.GameView;

public class GameViewManager {

    private final GameView gameView;
    GameManager gameManager;

    public GameViewManager() {
        gameView = new GameView();
        gameManager = new GameManager(gameView);


        startGameLoop();
    }

    private void startGameLoop() {
        while (gameView.isVisible()) {
            gameManager.processFrame();
            gameView.plotCanvas();
        }
    }
}
