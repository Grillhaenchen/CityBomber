package thd.game.managers;

import thd.game.utilities.GameView;

import java.awt.*;

public class GameViewManager {

    private final GameView gameView;
    GameManager gameManager;

    public GameViewManager() {
        gameView = new GameView();
        gameView.updateWindowTitle("City Bomber");
        gameView.updateStatusText("Kilian Mayerhofer - Java Programmierung SS 2026");
        gameView.updateWindowIcon("car_red_flying.png");
        gameView.updateBackgroundColor(Color.GRAY);
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
