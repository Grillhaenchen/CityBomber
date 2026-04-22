package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * A RandomCar Class that dirves on the Road.
 */
public class RandomCar extends GameObject {
    /**
     * Creates a RandomCar.
     *
     * @param gameView    Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public RandomCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);

        position.updateCoordinates(new Position(650, 100));
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
