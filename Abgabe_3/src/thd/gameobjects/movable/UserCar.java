package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * With this Class can the  User interact and drive through the Map.
 */
public class UserCar extends GameObject {

    private final OwnMovementPattern ownMovementPattern;

    /**
     * Creates a User car .
     *
     * @param gameView GameView instance
     */
    public UserCar(GameView gameView) {
        super(gameView, new Position(0, (double) GameView.HEIGHT / 2), new Position(0, (double) GameView.HEIGHT / 2));
        this.ownMovementPattern = new OwnMovementPattern();
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void updatePosition() {

    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("car_red_driving.png", position.getX(), position.getY(), 1, 0);
    }
}
