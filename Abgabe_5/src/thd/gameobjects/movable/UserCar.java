package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.MainCharacter;
import thd.gameobjects.base.Position;

/**
 * With this Class can the  User interact and drive through the Map.
 */
public class UserCar extends GameObject implements MainCharacter {

    private final int shotDurationInMilliseconds;

    /**
     * Creates a User car .
     *
     * @param gameView    GameView instance
     * @param gamePlayManager Instance of GamePlayManager
     */
    public UserCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        position.updateCoordinates(new Position(((double) GameView.WIDTH / 2), ((double) GameView.HEIGHT / 2) - 90));

        size = 1;
        shotDurationInMilliseconds = 300;
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
        gameView.addImageToCanvas("car_red_driving.png", position.getX(), position.getY(), size, 0);
    }

    /**
     * Moves the Car left.
     */
    public void left() {
        position.left(1);
    }

    /**
     * Moves the Car right.
     */
    public void right() {
        position.right(1);
    }

    /**
     * Moves car up.
     */
    public void up() {
        position.up(1);
    }

    /**
     * Moves Car down.
     */
    public void down() {
        position.down(1);
    }

    /**
     * Displays shoot.
     */
    @Override
    public void shoot() {
        if (gameView.timer(shotDurationInMilliseconds, 0, this)) {
            gamePlayManager.spawnGameObject(new UserShot(gameView, gamePlayManager));
        }
    }

    @Override
    public void updateStatus() {
        if (gameView.timer(5000, 0, this)) {
            size++;
        }
    }
}

