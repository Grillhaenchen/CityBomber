package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;

/**
 * This is the UI element for House on the right side.
 */
public class HouseRight extends CollidingGameObject implements ShiftableGameObject, CollidingWithUserCar, HouseRightReference {

    /**
     * This is the UI element for House on the right side.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HouseRight(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(0, 5, 0, 0);
        size = 0.50;
        width = 150;
        height = 195;
        distanceToBackground = 1;
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
        gameView.addImageToCanvas("house_right.png", position.getX(), position.getY(), size, 0);
    }
}
