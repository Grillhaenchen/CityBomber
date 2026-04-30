package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.Position;

/**
 * PoliceCar can spawn more than one follows the UserCar.
 */
public class PoliceCar extends CollidingGameObject {
    /**
     * Creates a Police Car.
     *
     * @param gameView Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public PoliceCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(new Position(30, 100));
        width = 30;
        height = 75;
        super.hitBoxOffsets(5, 0, 0, 0);
        distanceToBackground = Integer.MAX_VALUE - 2;
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        gamePlayManager.addPoints(30);
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
        gameView.addImageToCanvas("police_car.png", position.getX(), position.getY(), 1, 0);

    }
}
