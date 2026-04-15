package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * With this Class can the  User interact and drive through the Map.
 */
public class UserCar extends GameObject {

    private boolean shotInProgress;

    /**
     * Creates a User car .
     *
     * @param gameView GameView instance
     */
    public UserCar(GameView gameView) {
        super(gameView, new Position(0, (double) GameView.HEIGHT / 2), new Position(0, (double) GameView.HEIGHT / 2));
        shotInProgress = false;
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see GameView
     */
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
        gameView.addImageToCanvas("car_red_driving.png", position.getX(), position.getY(), 1, 0);
        if (shotInProgress) {
            gameView.addTextToCanvas("X", position.getX(), position.getY(), 20, true, Color.BLACK, 0);
        }
    }

    public void left() {
        position.left(1);
    }

    public void right() {
        position.right(1);
    }

    public void up() {
        position.up(1);
    }

    public void down() {
        position.down(1);
    }

    public void shoot() {
        shotInProgress = true;
    }
}

