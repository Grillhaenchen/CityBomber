package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

/**
 * This is the Start UI element in at the Progress bar.
 */
public class Start {

    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;

    private double speedInPixel;
    private double rotation;

    /**
     * This is the Start UI element in at the Progress bar.
     *
     * @param gameView GameView instance
     */
    public Start(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, (double) GameView.HEIGHT / 2);
        size = 1;
        width = 1;
        height = 1;
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    private void updatePosition() {

    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    public void addToCanvas() {
        gameView.addImageToCanvas("start.png", position.getX(), position.getY(), 1, 0);
    }
}
