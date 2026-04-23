package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * PoliceCar can spawn more than one follows the UserCar.
 */
public class PoliceCar extends GameObject {
    /**
     * Creates a Police Car.
     *
     * @param gameView Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public PoliceCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, new Position(30, 100), new Position(30, 100), gamePlayManager);
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
