package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;

/**
 * Class for the Helicopter who follow the UserCar and shot on it.
 */
public class Helicopter extends GameObject implements ActivatableGameObject<UserCar> {
    /**
     * Creates a Object of Helicopter.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public Helicopter(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        distanceToBackground = 400;
        position.updateCoordinates(new Position(((double) GameView.WIDTH / 2), ((double) GameView.HEIGHT / 2)));
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

    @Override
    public boolean tryToActivate(UserCar info) {
        if (info.getPosition().getY() != 5) {
            return false;
        }
        return true;
    }
}
