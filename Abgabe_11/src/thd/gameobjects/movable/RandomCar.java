package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;
import thd.gameobjects.unmovable.MoveLeftTrigger;
import thd.gameobjects.unmovable.MoveRightTrigger;
import thd.gameobjects.unmovable.MoveStraightTrigger;

import java.util.Random;

/**
 * A RandomCar Class that dirves on the Road.
 */
public class RandomCar extends CollidingGameObject implements ShiftableGameObject, ActivatableGameObject<UserCar>, RoadUser {

    static int carCounter = 1;

    private static final Random RANDOM = new Random();

    public static GameObject referenceObject = new GameObject(null, null) {
        // Only for bypass the Wichtl.

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
        speedInPixel = 3;
        distanceToBackground = 400;
        size = 1;
        currentState = State.Normal;
        ctr = carCounter;
        carCounter++;
        targetPosSet = false;
    }

    int ctr;

    @Override
    public void reactToCollisionWith(CollidingGameObject other) {
        if (other instanceof UserShot shot) {
            gamePlayManager.destroyGameObject(this);
            gamePlayManager.addPoints(30);
            gamePlayManager.destroyGameObject(shot);
        } else if (other instanceof MoveLeftTrigger) {
            pattern = new MoveLeftMovementPattern();
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        } else if (other instanceof MoveRightTrigger) {
            pattern = new MoveRightMovementPattern();
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        } else if (other instanceof MoveStraightTrigger) {
            pattern = new StraightMoveMovmentPattern(position);
            pattern.startPosition().ifPresent(targetPosition::updateCoordinates);
        }
    }

    @Override
    public void updatePosition() {
        if (pattern != null) {
            if (position.similarTo(targetPosition, 10) && !pattern.isLastPosition()) {
                pattern.nextPosition().ifPresent(targetPosition::updateCoordinates);
            }

            position.moveToPosition(targetPosition, speedInPixel);
        }
        if (Math.abs(referenceUserCar.getPosition().getY() - position.getY()) <= 200) {
            position.updateCoordinates(new Position(position.getX(), referenceUserCar.getPosition().getY() - 200));
            if (!targetPosSet) {
                targetPosition.updateCoordinates(position);
                targetPosSet = true;
            }

            randomMovement();
        }
    }

    private void randomMovement() {
        if (position.similarTo(targetPosition)) {
            double maxX = 800 - width;
            double minDiff = 250;
            double xPos;
            int attempts = 0;
            do {
                xPos = RANDOM.nextDouble() * maxX;
                attempts++;
            } while (Math.abs(xPos - position.getX()) < minDiff && attempts < 100);

            targetPosition.updateCoordinates(new Position(xPos, referenceUserCar.getPosition().getY() - 200));
            System.out.println("RandomCar " + ctr + " new target position: " + targetPosition + " (attempts: " + attempts + ")");
        }
        position.moveToPosition(targetPosition, speedInPixel);

    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        super.hitBoxOffsets(8 + referenceObject.getPosition().getX(), 0, 0, 0);
        gameView.addImageToCanvas("car_blue.png", position.getX() + referenceObject.getPosition().getX(), position.getY(), size, 0);
    }

    @Override
    public boolean tryToActivate(UserCar info) {
        return true;
    }

}
