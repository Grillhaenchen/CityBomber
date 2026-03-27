package thd.game.managers;

import thd.game.utilities.GameView;

public class GameViewManager {

    private final GameView gameView;


    public GameViewManager() {
        gameView = new GameView();
        startGameLoop();
    }
    private void startGameLoop() {
        while (gameView.isVisible()) {
            gameView.plotCanvas();
        }
    }
}
