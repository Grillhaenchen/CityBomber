package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.MainCharacter;
import thd.gameobjects.base.Position;
import thd.gameobjects.base.ShiftableGameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * With this Class can the  User interact and drive through the Map.
 */
public class UserCar extends CollidingGameObject implements MainCharacter, ShiftableGameObject {

    private final int shotDurationInMilliseconds;
    private final List<CollidingGameObject> collidingGameObjectsForPathDecision;

    /**
     * Creates a User car .
     *
     * @param gameView        GameView instance
     * @param gamePlayManager Instance of GamePlayManager
     */
    public UserCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);

        width = 70;
        height = 120;
        size = 1;
        speedInPixel = 10;
        distanceToBackground = 500;
        super.hitBoxOffsets(10, 15, 0, 0);
        shotDurationInMilliseconds = 300;
        collidingGameObjectsForPathDecision = new LinkedList<CollidingGameObject>();
        collidingGameObjectsForPathDecision.add(new PoliceCar(gameView, gamePlayManager));
        collidingGameObjectsForPathDecision.add(new RandomCar(gameView, gamePlayManager));
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
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
        if (position.getX() > GameView.WIDTH / 2d - 200) {
            position.left(speedInPixel);
        } else {
            gamePlayManager.moveWorldToRight(speedInPixel);
        }

        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                position.right(speedInPixel);
                gamePlayManager.lifeLost();
                break;
            }
        }
    }

    /**
     * Moves the Car right.
     */
    public void right() {
        if (position.getX() < GameView.WIDTH / 2d - 200) {
            position.right(speedInPixel);
        } else {
            gamePlayManager.moveWorldToLeft(speedInPixel);
        }
        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                this.position.left(speedInPixel);
                gamePlayManager.lifeLost();
                break;
            }
        }
    }

    /**
     * Moves car up.
     */
    public void up() {

        if (position.getY() > 20) {
            position.up(speedInPixel);
        } else {
            gamePlayManager.moveWorldDown(speedInPixel);
        }

        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                position.down(speedInPixel);
                gamePlayManager.lifeLost();
                break;
            }
        }
    }

    /**
     * Moves Car down.
     */
    public void down() {
        if (position.getY() < 420) {
            position.down(speedInPixel);
        } else {
            gamePlayManager.moveWorldUp(speedInPixel);
        }

        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                position.up(speedInPixel);
                gamePlayManager.lifeLost();
                break;
            }
        }
    }

    /**
     * Displays shoot.
     */
    @Override
    public void shoot() {
        if (gameView.timer(shotDurationInMilliseconds, 0, this)) {
            UserShot shot = new UserShot(gameView, gamePlayManager);
            shot.getPosition().updateCoordinates(new Position(position.getX() + 25, position.getY()));

            gamePlayManager.spawnGameObject(shot);
        }
    }

    @Override
    public void updateStatus() {

    }
}

