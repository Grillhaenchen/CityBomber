package game;

public class GameViewManager {

    private final GameView gameView;
    public GameViewManager() {
        gameView = new GameView();
        startGameLoop();
    }
    private void startGameLoop() {
        while (gameView.isVisible()) {

        }
    }
}
