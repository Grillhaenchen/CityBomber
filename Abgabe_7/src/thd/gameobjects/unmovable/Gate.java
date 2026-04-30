package thd.gameobjects.unmovable;


import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * This is the Gate UI element in at the Progress bar.
 */
public class Gate extends GameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView    GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public Gate(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, new Position(0, (double) GameView.HEIGHT / 2), new Position(0, (double) GameView.HEIGHT / 2), gamePlayManager);
        size = 1;
        width = 1;
        height = 1;
        distanceToBackground=Integer.MAX_VALUE;
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
        gameView.addImageToCanvas("gate.png", position.getX(), position.getY(), 1, 0);
    }
}
