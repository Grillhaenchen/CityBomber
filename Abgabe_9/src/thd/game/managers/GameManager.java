package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Score;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

import java.util.Timer;

/**
 * The GameManager handles all the Game Items and processes the Frame.
 */
class GameManager extends LevelManager {

    /**
     * Create a new GameManager.
     *
     * @param gameView GameView instance
     */
    GameManager(GameView gameView) {
        super(gameView);
        initializeGame();
    }

    @Override
    protected void processFrame() throws TooManyGameObjectsException {
        super.processFrame();
        gameManagement();
    }

    private void gameManagement() {
        if (endOfGame()) {
            initializeGame();
        } else if (endOfLevel()) {
            switchToNextLevel();
            initializeLevel();
        }
    }

    private boolean endOfLevel() {
        //return gameView.timer(3000, 0, this);
        return false;
    }

    private boolean endOfGame() {
        return lives == 0 || (!hasNextLevel() && endOfLevel());
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        initializeLevel();
    }
}
