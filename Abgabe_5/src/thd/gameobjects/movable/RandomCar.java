package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * A RandomCar Class that dirves on the Road.
 */
public class RandomCar extends GameObject {
    /**
     * Creates a RandomCar.
     *
     * @param gameView Instance of GameView
     */
    public RandomCar(GameView gameView) {
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
        gameView.addImageToCanvas("car_blue.png", position.getX(), position.getY(), 1, 0);

    }
}
