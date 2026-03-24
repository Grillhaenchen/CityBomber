package game;

import java.awt.*;

public class GameViewManager {

    private final GameView gameView;
    private Ufo ufo;
    public GameViewManager() {
        gameView = new GameView();
        ufo = new Ufo(gameView);
        startGameLoop();
    }
    private void startGameLoop() {
        while (gameView.isVisible()) {
            ufo.updatePosition();
            ufo.addToCanvas();
            gameView.plotCanvas();
        }
    }
}
