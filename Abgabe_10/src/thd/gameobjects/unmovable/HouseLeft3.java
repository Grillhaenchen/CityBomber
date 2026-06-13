package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingWithUserCar;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the UI element for House on the left side.
 */
public class HouseLeft3 extends CollidingGameObject implements ShiftableGameObject, CollidingWithUserCar {

    /**
     * This is the UI element for House on the left side.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HouseLeft3(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(114, 5, 0, 0);
        size = 0.635;
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
        gameView.addImageToCanvas("house_left_3.png", position.getX() + 115, position.getY(), size, 0);
    }
}
