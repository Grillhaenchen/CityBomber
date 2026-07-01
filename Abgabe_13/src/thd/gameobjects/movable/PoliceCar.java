package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * PoliceCar can spawn more than one follows the UserCar.
 */
public class PoliceCar extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<UserCar> {
    private enum State {
        Normal,
        Explode
    }

    private State currentState;

    /**
     * Creates a Police Car.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public PoliceCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(5 * size, 5 * size, 0, 0);
        size = 2;
        width = 35 * size;
        height = 65 * size;
        distanceToBackground = 400;

        currentState = State.Normal;
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserShot shot) {
            currentState = State.Explode;
            gamePlayManager.addPoints(30);
            gamePlayManager.destroyGameObject(other);
        } else if (other instanceof UserCar) {
            currentState = State.Explode;
            gamePlayManager.addPoints(10);
        }
    }

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
        if (currentState == State.Normal) {
            gameView.addImageToCanvas("police_car.png", position.getX(), position.getY(), size, 0);
        } else if (currentState == State.Explode) {
            gameView.addImageToCanvas("car_explosion.png", position.getX(), position.getY(), size, 0);
            if (gameView.timer(250, 0, this)) {
                gamePlayManager.destroyGameObject(this);
            }
        }
    }

    @Override
    public boolean tryToActivate(UserCar info) {
        return true;
    }
}
