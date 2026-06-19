package thd.game.managers;

import thd.game.level.*;
import thd.game.utilities.GameView;

import java.util.List;

class LevelManager extends GameWorldManager {

    private List<Level> levels;

    /**
     * Create a instance of GamePlayManager.3
     *
     * @param gameView Instance of GameView.
     */
    protected LevelManager(GameView gameView) {
        super(gameView);
        levels = List.of(new Level1(), new Level2(), new Level3());
        level = levels.getFirst();

    }

    protected boolean hasNextLevel() {
        if (levels.size() <= levels.indexOf(level) + 1) {
            return false;
        } else {
            return true;
        }
    }

    protected void switchToNextLevel() {
        if (hasNextLevel()) {
            level = levels.get(levels.indexOf(level) + 1);
        } else {
            throw new NoMoreLevelsAvailableException("No more levels available");
        }

    }

    @Override
    protected void initializeLevel() {
        super.initializeLevel();
        initializeGameObjects();
    }

    private void initializeGameObjects() {
        gameView.stopAllSounds();
//        Die Methode initializeGameObjects() soll in Zukunft dazu genutzt werden, um Spielelemente an ein neues Level anzupassen, z.B.
//        Anpassungen für das Level am Hintergrund machen.
//        Die Lebensanzeige aktualisieren.
//        Den Punktestand aus dem vorherigen Level übernehmen.
//        Einen Countdown neu starten.
//        Kopieren Sie diesen Text als Kommentar zur Erinnerung für später in diese Methode.
        gameView.playSound("music.wav", true, 0.5f);
    }

    protected void initializeGame() {
        levels = List.of(new Level1(), new Level2(), new Level3());
        level = levels.get(0);
        lives = LIVES;
        points = 0;
    }
}
