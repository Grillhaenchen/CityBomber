package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingWithUserCar;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the UI element for the green gras with street.
 */
public class GreenWithStreet extends CollidingGameObject implements ShiftableGameObject, CollidingWithUserCar {

    /**
     * This is the UI element for the green gras with street.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public GreenWithStreet(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(50, 0, 0, 0);
        size = 0.97;
        width = 200;
        height = 202;
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
     * Add the UI element to the UserWindow.
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("green_with_street.png", position.getX() + 69, position.getY(), size, 0);
    }
}
