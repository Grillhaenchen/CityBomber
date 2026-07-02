package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.ShiftableGameObject;

public class HelicopterShoot extends CollidingGameObject implements ShiftableGameObject {

    /**
     * Creates a Bullet.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HelicopterShoot(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        size = 0.1;
        width = 70;
        height = 70;
        super.hitBoxOffsets(10, 10, 0, 0);
        speedInPixel = 25;
        distanceToBackground = 400;
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserCar car) {
            gamePlayManager.destroyGameObject(this);
            gamePlayManager.lifeLost();
        } else if (other instanceof UserShot shoot) {
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
        if (isOutOfGameView()) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("heli_shoot.png", position.getX(), position.getY(), size, 0);
    }

    @Override
    public void updateStatus() {
        if (position.getY() < 20) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    private boolean isOutOfGameView() {
        return position.getY() < 0 || position.getY() > GameView.HEIGHT || position.getX() < 0 || position.getX() > GameView.WIDTH;
    }
}