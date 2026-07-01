package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the UI element for the border on the left side.
 */
public class Finish extends CollidingGameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the border on the left side.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public Finish(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(0, 0, width, height);
        size = 0.5;
        width = 1000;
        height = 100;
        distanceToBackground = 301;
    }

    /**
     * If a game object is collided with another game object, it reacts to the collision. This method needs to be
     * overridden by game objects and implemented with appropriate reactions.
     *
     * @param other The other game object that is involved in the collision.
     */
    @Override
    public void reactToCollisionWith(CollidingGameObject other) {

    }

    /**
     * Draws the game object to the canvas.
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("finish.png", position.getX() + 70, position.getY() - 350, 3, 0);
    }
}
