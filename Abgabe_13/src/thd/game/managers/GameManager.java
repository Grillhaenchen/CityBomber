package thd.game.managers;

import thd.game.level.Difficulty;
import thd.game.level.Level;
import thd.game.utilities.FileAccess;
import thd.game.utilities.GameView;
import thd.screens.GameInfo;
import thd.screens.Screens;

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
                Screens.showEndScreen(gameView, "Du hast das Spiel durchgespielt. Wähle ob du nochmal starten willst.", "droidsansmono.ttf");
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
        String diff = Screens.showStartScreen(gameView, GameInfo.TITLE, GameInfo.DESCRIPTION, Level.difficulty.name, "droidsansmono.ttf");
        Level.difficulty = Difficulty.fromName(diff);
        FileAccess.writeSaveGameToDisc();
        initializeGame();
    }
}
