package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Class of PrograssBar displayed on the left side of the UI.
 */
public class ProgressBarBlockImages extends GameObject {

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
            R
            R            
            """;

    /**
     * Create a Progressbar.
     *
     * @param gameView        Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public ProgressBarBlockImages(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(48, (double) (GameView.HEIGHT / 2) + 71);
        distanceToBackground = Integer.MAX_VALUE;
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
        gameView.addBlockImageToCanvas(block, getPosition().getX(), getPosition().getY(), 5, 0);
    }
}
