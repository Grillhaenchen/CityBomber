package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.Position;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * A RandomCar Class that dirves on the Road.
 */
public class RandomCar extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<UserCar> {

    private enum State {
        Normal,
        Explode
    }

    private State currentState;

    /**
     * Creates a RandomCar.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public RandomCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(8, 0, 0, 0);
        width = 70;
        height = 120;
        distanceToBackground = 400;
        currentState = State.Normal;
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserShot) {
            gamePlayManager.destroyGameObject(this);
            gamePlayManager.addPoints(30);
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
        gameView.addImageToCanvas("car_blue.png", position.getX(), position.getY(), 1, 0);

    }

    @Override
    public boolean tryToActivate(UserCar info) {
        return false;
    }
}
