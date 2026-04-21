package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * Class for the Helicopter who follow the UserCar and shot on it.
 */
public class Helicopter extends GameObject {
    /**
     * Creates a Object of Helicopter.
     *
     * @param gameView Instance of GameView
     */
    public Helicopter(GameView gameView) {
        super(gameView);
        position.updateCoordinates(new Position(30, 40));
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
        gameView.addImageToCanvas("helicopter.png", position.getX(), position.getY(), 1, 0);

    }

}
