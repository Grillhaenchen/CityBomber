package thd.game.managers;

import thd.game.utilities.GameView;

import java.awt.*;

/**
 * The GameViewManager handles all the Window Infaormations.
 * <br>
 * It also handles the Gameloop.
 */
public class GameViewManager {

    private final GameView gameView;
    private final GameManager gameManager;

    /**
     * The GameViewManager handles all the Window Infaormations.
     * <br>
     * It also handles the Gameloop.
     */
    public GameViewManager() throws TooManyGameObjectsExeption {
        gameView = new GameView();
        gameView.updateWindowTitle("City Bomber");
        gameView.updateStatusText("Kilian Mayerhofer - Java Programmierung SS 2026");
        gameView.updateWindowIcon("car_red_flying.png");
        gameView.updateBackgroundColor(Color.GRAY);
        gameManager = new GameManager(gameView);

        startGameLoop();
    }

    private void startGameLoop() throws TooManyGameObjectsExeption {
        while (gameView.isVisible()) {
            gameManager.processFrame();
            gameView.plotCanvas();
        }
    }
}
