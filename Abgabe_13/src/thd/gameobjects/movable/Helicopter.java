package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.ActivatableGameObject;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

import java.util.Random;

/**
 * Class for the Helicopter who follow the UserCar and shot on it.
 */
public class Helicopter extends GameObject implements ActivatableGameObject<UserCar> {

    /**
     * This is the animation for the Helicopter.
     */
    private enum FlyAnimation {
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
            pattern.nextPosition().ifPresent(targetPosition::updateCoordinates);
        }
        position.moveToPosition(targetPosition, speedInPixel);
        if (new Random().nextInt(100) == 5) {
            spawnShoot();
        }
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

    private void spawnShoot() {
        HelicopterShoot shot = new HelicopterShoot(gameView, gamePlayManager);
        shot.getPosition().updateCoordinates(new Position(position.getX() - 50, position.getY()));
        gamePlayManager.spawnGameObject(shot);
    }

    @Override
    public boolean tryToActivate(UserCar info) {
        return info.getPosition().getY() == 5;
    }
}
