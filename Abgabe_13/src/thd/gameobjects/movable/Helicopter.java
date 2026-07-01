package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.*;

/**
 * Class for the Helicopter who follow the UserCar and shot on it.
 */
public class Helicopter extends GameObject implements ActivatableGameObject<UserCar> {

    public enum FlyAnimation {
        FIRST("helicopter_1.png"),
        SECOND("helicopter_2.png"),
        THIRD("helicopter_3.png"),
        FOURTH("helicopter_4.png");

        private final String imagePath;

        FlyAnimation(String imagePath) {
            this.imagePath = imagePath;
        }
    }

    private FlyAnimation currentFlyAnimation;
    private final MovementPattern pattern;

    /**
     * Creates a Object of Helicopter.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public Helicopter(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        distanceToBackground = 400;
        currentFlyAnimation = FlyAnimation.FIRST;
        size = 1;
        pattern = new HelicopterMovementPattern();
        speedInPixel = 5;
    }

    @Override
    public void updatePosition() {
        if (gameView.timer(80, 0, this)) {
            currentFlyAnimation = FlyAnimation.values()[(currentFlyAnimation.ordinal() + 1) % FlyAnimation.values().length];
        }
        if (position.similarTo(targetPosition)) {
            pattern.nextPosition().ifPresent(p -> targetPosition.updateCoordinates((Position) p));
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
        gameView.addImageToCanvas(currentFlyAnimation.imagePath, position.getX(), position.getY(), 0.5, 0);
    }

    @Override
    public boolean tryToActivate(UserCar info) {
        if (info.getPosition().getY() != 5) {
            return false;
        }
        return true;
    }
}
