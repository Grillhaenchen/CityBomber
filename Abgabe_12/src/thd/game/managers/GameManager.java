package thd.game.managers;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.utilities.FileAccess;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Score;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

import java.io.File;
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

        startNewGame();
    }

    @Override
    protected void processFrame() throws TooManyGameObjectsException {
        super.processFrame();
        gameManagement();
    }

    private void gameManagement() {
        if (endOfGame()) {
            if (!overlay.isMessageShown()) {
                overlay.showMessage("Game Over", 2);
            } else {
                overlay.stopShowing();
                startNewGame();
            }
        } else if (endOfLevel()) {
            if (gameView.timer(0, 2000, this)) {
                overlay.showMessage("Great Job!");
            } else {
                overlay.stopShowing();
                switchToNextLevel();
                initializeLevel();
            }
        }
    }

    private boolean endOfLevel() {
        return userCar.isInFinish();
    }

    private boolean endOfGame() {
        return lives <= 0 || (!hasNextLevel() && endOfLevel());
    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
        overlay.showMessage(level.name, 2);
    }

    @Override
    protected void initializeGame() {
        super.initializeGame();
        initializeLevel();
    }

    private void startNewGame() {
        FileAccess.readSaveGameFromDisc();
        FileAccess.readDifficultyFromDisc();
        Level.difficulty = Difficulty.EASY;
        FileAccess.writeDifficultyToDisc();
        FileAccess.writeSaveGameToDisc();
        initializeGame();


    }
}
