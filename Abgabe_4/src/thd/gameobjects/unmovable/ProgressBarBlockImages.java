package thd.gameobjects.unmovable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

class ProgressBarBlockImages extends GameObject {

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


    ProgressBarBlockImages(GameView gameView) {
        super(gameView, new Position(0, (double) GameView.HEIGHT / 2), new Position(0, (double) GameView.HEIGHT / 2));
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
        gameView.addBlockImageToCanvas(block, 1, 1, 2, 2);
    }
}
