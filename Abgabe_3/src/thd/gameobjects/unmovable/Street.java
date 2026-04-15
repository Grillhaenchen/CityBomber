package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * This Class handels the Map where the user can drive. *
 */
public class Street extends GameObject {

    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;

    private double speedInPixel;
    private double rotation;

    /**
     * Create a Street Object.
     *
     * @param gameView GameView instance
     */
    public Street(GameView gameView) {
        super(gameView);
        this.gameView = gameView;
        this.position = new Position((double) GameView.WIDTH / 2, (double) GameView.HEIGHT / 2);
        size = 1;
        width = 1;
        height = 1;
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void updatePosition() {

    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("road_4row.png", position.getX(), position.getY(), 1, 0);
    }
}
