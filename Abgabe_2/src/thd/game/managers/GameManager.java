package thd.game.managers;

import thd.game.utilities.GameView;

public class GameManager {

    GameView gameView;

    public GameManager(GameView _gameView) {
        this.gameView = _gameView;
    }

    void processFrame(){
        while (gameView.isVisible()) {
            gameView.plotCanvas();
        }
    }
}
