package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * PoliceCar can spawn more than one follows the UserCar.
 */
public class PoliceCar extends GameObject {
    /**
     * Creates a Police Car.
     *
     * @param gameView Instance of GameView
     */
    public PoliceCar(GameView gameView) {
        super(gameView);
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
