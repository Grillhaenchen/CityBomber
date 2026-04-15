package thd.gameobjects.base;

import thd.game.utilities.GameView;

/**
 * Represents an object in the game.
 */
public class GameObject {

    private final GameView gameView;
    private final Position position;
    private final Position targetPosition;
    private double speedInPixel;
    private double rotation;
    private double size;
    private double width;
    private double height;

    /**
     * Crates a new GameObject.
     *
     * @param gameView GameView to show the game object on.
     */
    public GameObject(GameView gameView) {
        this.gameView = gameView;
        position = new Position();
        targetPosition = new Position();
    }

    /**
     * Updates the position of the game object.
     */
    public void updatePosition() {
    }

    /**
     * Draws the game object to the canvas.
     */
    public void addToCanvas() {
    }

    /**
     * Returns the current position of the game object.
     *
     * @return position of the game object.
     */
    public Position getPosition() {
        return position;
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
}