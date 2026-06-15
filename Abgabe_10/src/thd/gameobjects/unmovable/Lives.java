package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * Handels the lives in the code.
 */
public class Lives extends GameObject {

    private int lives;

    /**
     * create a live instance.
     *
     * @param gameView        instance of gameview.
     * @param gamePlayManager instance of gamePlayManger.
     */
    public Lives(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates((double) GameView.WIDTH / 2 - 200, 0);
        distanceToBackground = Integer.MAX_VALUE;
        lives = 0;
    }

    /**
     * Sets available lives.
     *
     * @param lives points to add.
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("Lives: " + lives, position.getX(), position.getY(), 20, true, Color.black, 0, "droidsansmono.ttf");
        gameView.addRectangleToCanvas(position.getX() - 2, position.getY() + 3, 135, 20, 2, false, Color.WHITE);
    }
}
