package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * This is the Start UI element in at the Progress bar.
 */
public class Start extends GameObject {

    /**
     * This is the Start UI element in at the Progress bar.
     *
     * @param gameView    GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public Start(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(10, (double) (GameView.HEIGHT / 2) + 250);
        size = 0.5;
        width = 150;
        height = 43;
        distanceToBackground = Integer.MAX_VALUE;
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see GameView
     */
    @Override
    public void updatePosition() {

    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("start.png", position.getX(), position.getY(), size, 0);
    }
}
