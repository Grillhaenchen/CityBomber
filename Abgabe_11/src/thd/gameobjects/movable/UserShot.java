package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * If the User Fire a bullet this Class handles all the collision detection and the UI element.
 */
public class UserShot extends CollidingGameObject implements ShiftableGameObject {

    /**
     * Creates a Bullet.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public UserShot(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 1;
        width = 20;
        height = 20;
        super.hitBoxOffsets(5, 5, 0, 0);
        speedInPixel = 4;
        distanceToBackground = 400;
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserShot) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see GameView
     */
    @Override
    public void updatePosition() {
        position.up(speedInPixel);
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("shot.png", position.getX(), position.getY(), 1, 0);
    }

    @Override
    public void updateStatus() {
        if (position.getY() < 20) {
            gamePlayManager.destroyGameObject(this);
        }
    }
}
