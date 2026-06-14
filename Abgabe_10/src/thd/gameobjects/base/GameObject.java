package thd.gameobjects.base;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;

import java.util.Objects;

/**
 * Represents an object in the game.
 */
public abstract class GameObject {

    protected final GameView gameView;
    protected final Position position;
    protected final Position targetPosition;
    protected final GamePlayManager gamePlayManager;
    protected double speedInPixel;
    protected double rotation;
    protected double size;
    protected double width;
    protected double height;
    protected int distanceToBackground;

    /**
     * Create a new GameObject.
     *
     * @param gameView        GameView to show the game object on.
     * @param position        Position to show the game object on.
     * @param targetPosition  TargetPosition to show the game object on.
     * @param gamePlayManager Instance of GamePlayManager
     */
    public GameObject(GameView gameView, Position position, Position targetPosition, GamePlayManager gamePlayManager) {
        this.gameView = gameView;
        this.position = position;
        this.targetPosition = targetPosition;
        this.gamePlayManager = gamePlayManager;
    }

    /**
     * Crates a new GameObject.
     *
     * @param gameView GameView to show the game object on.
     * @param gamePlayManager Instance of GamePlayManager
     */
    public GameObject(GameView gameView, GamePlayManager gamePlayManager) {
        this.gameView = gameView;
        this.gamePlayManager = gamePlayManager;
        this.position = new Position(0, 0);
        this.targetPosition = new Position(0, 0);
    }

    /**
     * Get the Distance to the Background.
     *
     * @return Distance to Background
     */
    public int getDistanceToBackground() {
        return distanceToBackground;
    }

    /**
     * Updates the position of the game object.
     */
    public void updatePosition() {
    }

    /**
     * Draws the game object to the canvas.
     */
    public abstract void addToCanvas();

    /**
     * Returns the current position of the game object.
     *
     * @return position of the game object.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns the target position of the game object.
     *
     * @return position of the game object.
     */
    public Position getTargetPosition() {
        return targetPosition;
    }

    /**
     * Returns width of game object.
     *
     * @return Width of game object
     */
    public double getWidth() {
        return width;
    }

    /**
     * Returns height of game object.
     *
     * @return Height of game object
     */
    public double getHeight() {
        return height;
    }

    /**
     * Updates the Status of a GameObject.
     */
    public void updateStatus(){
//        if (position.getX() > 1280 || position.getX() < 0 || position.getY() < 0 || position.getY() > 720) {
//            gamePlayManager.destroyGameObject(this);
//        }
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        GameObject that = (GameObject) object;

        return Double.compare(that.speedInPixel, speedInPixel) == 0
                && Double.compare(that.rotation, rotation) == 0
                && Double.compare(that.size, size) == 0
                && Double.compare(that.width, width) == 0
                && Double.compare(that.height, height) == 0
                && Objects.equals(position, that.position)
                && Objects.equals(targetPosition, that.targetPosition)
                && distanceToBackground == that.distanceToBackground;
    }

    @Override
    public int hashCode() {
        // Der Hash-Code muss auf denselben Feldern basieren wie die equals-Methode
        return Objects.hash(position, targetPosition, speedInPixel, rotation, size, width, height, distanceToBackground);
    }
}