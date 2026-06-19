package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.MainCharacter;
import thd.gameobjects.base.Position;
import thd.gameobjects.unmovable.Finish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * With this Class can the  User interact and drive through the Map.
 */
public class UserCar extends CollidingGameObject implements MainCharacter {

    private enum State {
        Left(-45),
        Right(+45),
        Normal(0);

        private int angle;

        State(int angle) {
            this.angle = angle;
        }
    }


    private final int shotDurationInMilliseconds;
    private final List<CollidingGameObject> collidingGameObjectsForPathDecision;
    private final List<GameObject> roadUsers;
    private State currentState;
    private static final int CENTER_OFFSET = 250;
    private boolean finished;

    /**
     * Creates a User car .
     *
     * @param gameView        GameView instance
     * @param gamePlayManager Instance of GamePlayManager
     */
    public UserCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(10, 15, 0, 0);
        width = 70;
        height = 120;
        size = 1;
        speedInPixel = 10;
        distanceToBackground = 500;
        shotDurationInMilliseconds = 200;
        collidingGameObjectsForPathDecision = new LinkedList<CollidingGameObject>();
        roadUsers = new ArrayList<GameObject>();
        currentState = State.Normal;
        finished = false;
        gameView.playSound("motor.wav", true, 0.2f);
        shoot();
    }

    /**
     * Add game objects for collision.
     *
     * @param collidingGameObject GameObject who can collide.
     */
    public void addGameObjectsForCollision(CollidingGameObject collidingGameObject) {
        collidingGameObjectsForPathDecision.add(collidingGameObject);
    }

    /**
     * add all roadcars.
     *
     * @param gameObject items on the road.
     */
    public void addRoadUsers(GameObject gameObject) {
        roadUsers.add(gameObject);
    }

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof Finish) {
            finished = true;
        }
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
        gameView.addImageToCanvas("car_red_driving.png", position.getX(), position.getY(), size, currentState.angle);
    }

    /**
     * Moves the Car left.
     */
    public void left() {
        currentState = State.Left;
        if (position.getX() > GameView.WIDTH / 2.0 - CENTER_OFFSET) {
            position.left(speedInPixel);
        } else {
            gamePlayManager.moveWorldToRight(speedInPixel);
        }

        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                position.right((speedInPixel * 3));
                gamePlayManager.lifeLost();
                gameView.playSound("collison.wav", false, 1.0f);
                break;
            }
        }
    }

    /**
     * Moves the Car right.
     */
    public void right() {
        currentState = State.Right;
        if (position.getX() < GameView.WIDTH / 2.0 + CENTER_OFFSET) {
            position.right(speedInPixel);
        } else {
            gamePlayManager.moveWorldToLeft(speedInPixel);
        }
        for (CollidingGameObject collidingGameObject : collidingGameObjectsForPathDecision) {
            if (collidesWith(collidingGameObject)) {
                this.position.left((speedInPixel * 3));
                gamePlayManager.lifeLost();
                gameView.playSound("collison.wav", false, 1.0f);
                break;
            }
        }
    }

    /**
     * Show normal State of Car.
     */
    public void displayNormalState() {
        currentState = State.Normal;
    }

    /**
     * Displays shoot.
     */
    @Override
    public void shoot() {
        if (gameView.timer(shotDurationInMilliseconds, 0, this)) {
            UserShot shot = new UserShot(gameView, gamePlayManager);
            shot.getPosition().updateCoordinates(new Position(position.getX() + 25, position.getY()));
            gameView.playSound("shot.wav", false, 1.0f);
            gamePlayManager.spawnGameObject(shot);
        }
    }

    /**
     * update the status.
     */
    @Override
    public void updateStatus() {

    }

    /**
     * return True if UserCar is in the Finish.
     *
     * @return True if UserCar is in the Finish
     */
    public boolean isInFinish() {
        return this.finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

