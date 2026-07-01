package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;
import thd.gameobjects.unmovable.Finish;
import thd.gameobjects.unmovable.MoveLeftTrigger;
import thd.gameobjects.unmovable.MoveRightTrigger;
import thd.gameobjects.unmovable.MoveStraightTrigger;

import java.util.Random;

/**
 * A RandomCar Class that dirves on the Road.
 */
public class RandomCar extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<UserCar>, RoadUser {

    public static int carCounter = 1;

    private static final Random RANDOM = new Random();

    public static GameObject referenceObject = new GameObject(null, null) {
        // Only for bypass the Wichtl. the first house on the left side is the worldanker.

        @Override
        public void addToCanvas() {

        }
    };

    public static GameObject referenceUserCar = new GameObject(null, null) {
        // Only for bypass the Wichtl.

        @Override
        public void addToCanvas() {

        }
    };

    private enum State {
        Normal,
        Explode
    }

    private State currentState;
    private MovementPattern pattern;
    private boolean targetPosSet;

    /**
     * Creates a RandomCar.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public RandomCar(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(8, 0, 0, 0);
        width = 70;
        height = 120;
        speedInPixel = 10;
        distanceToBackground = 400;
        size = 1;
        currentState = State.Normal;
        ctr = carCounter;
        carCounter++;
        targetPosSet = false;
    }

    private int ctr;

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserShot shot) {
            gamePlayManager.addPoints(30);
            currentState = State.Explode;
            gamePlayManager.destroyGameObject(shot);
            gameView.playSound("car_explosion.wav", false, 100);
        } else if (other instanceof MoveLeftTrigger) {
            pattern = new MoveLeftMovementPattern();
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        } else if (other instanceof MoveRightTrigger) {
            pattern = new MoveRightMovementPattern();
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        } else if (other instanceof MoveStraightTrigger) {
            pattern = new StraightMoveMovmentPattern(position);
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        } else if (other instanceof HouseLeftReference) {
            position.right(2);
            targetPosSet = false;
        } else if (other instanceof HouseRightReference) {
            position.left(2);
            targetPosSet = false;
        } else if (other instanceof LeftObstacle) {
            position.right(100);
        }
        if (other instanceof Finish) {
            gamePlayManager.destroyGameObject(this);
        }
    }

    @Override
    public void updatePosition() {
        double distanceToUserCar = height * ctr + 10;
        if (pattern != null) {
            if (position.similarTo(targetPosition, 10) && !pattern.isLastPosition()) {
                pattern.nextPosition().ifPresent(targetPosition::updateCoordinates);
            }

            position.moveToPosition(targetPosition, speedInPixel);
        }
        if (isDistanceLow(distanceToUserCar)) {
            position.updateCoordinates(calcOffset(distanceToUserCar));
            writeTargetPos();
            randomMovement();
        }
    }

    private boolean isDistanceLow(double distanceToUserCar) {
        return Math.abs(referenceUserCar.getPosition().getY() - position.getY()) <= distanceToUserCar;
    }

    private Position calcOffset(double distanceToUserCar) {
        double x = position.getX();
        double y = referenceUserCar.getPosition().getY() - distanceToUserCar;
        return new Position(x, y);
    }

    private void writeTargetPos() {
        if (!targetPosSet) {
            targetPosition.updateCoordinates(position);
            targetPosSet = true;
        }
    }

    private void randomMovement() {
        if (Math.abs(position.getX() - targetPosition.getX()) <= 1) {
            targetPosition.updateCoordinates(calcNewRandXPos());
        }
        position.moveToPosition(targetPosition, speedInPixel);
    }

    private Position calcNewRandXPos() {
        final int streetWidth = 800;
        double zeroPos = referenceObject.getPosition().getX() + referenceObject.getWidth();
        final double upperBound = zeroPos + streetWidth;
        double xPos = position.getX();
        while (Math.abs(xPos - position.getX()) < 100) {
            xPos = RANDOM.nextDouble(upperBound - zeroPos) + zeroPos;
        }
        return new Position(xPos, referenceUserCar.getPosition().getY() - 200);
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        // super.hitBoxOffsets(8 + referenceObject.getPosition().getX(), 0, 0, 0);
        if (currentState == State.Normal) {
            gameView.addImageToCanvas("car_blue.png", position.getX(), position.getY(), size, 0);
        } else if (currentState == State.Explode) {
            gameView.addImageToCanvas("car_explosion.png", position.getX(), position.getY(), size, 0);
            if (gameView.timer(250, 0, this)) {
                gamePlayManager.destroyGameObject(this);
            }
        }
    }

    @Override
    public boolean tryToActivate(UserCar info) {
        return true;
    }
}
