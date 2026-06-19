package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.CollidingWithUserCar;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the UI element for the border on the left side.
 */
public class StreetBorderLeftMirror extends CollidingGameObject implements ShiftableGameObject, CollidingWithUserCar {

    /**
     * This is the UI element for the border on the left side.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public StreetBorderLeftMirror(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(-120, 60, 0, 0);
        size = 0.5;
        width = 150;
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
        gameView.addImageToCanvas("street_border_left_mirror.png", position.getX() - 130, position.getY(), size, 0);
    }
}
