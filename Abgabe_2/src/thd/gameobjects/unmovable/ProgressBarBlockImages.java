package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

class ProgressBarBlockImages {

    /**
     * this is the Progressbar on the left side of the gameUI.
     */
    private static final String block = """
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            R
            """;
    private final GameView gameView;
    private final Position position;
    private final double size;
    private final double width;
    private final double height;
    private double speedInPixel;
    private double rotation;

    ProgressBarBlockImages(GameView gameView) {
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
    private void addToCanvas() {
        gameView.addBlockImageToCanvas(block, 1, 1, 2, 2);
    }
}
