package thd.gameobjects.unmovable;


import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

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
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(10, (double) (GameView.HEIGHT / 2) + 50);
        size = 0.5;
        width = 150;
        height = 43;
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
        gameView.addImageToCanvas("gate.png", position.getX(), position.getY(), size, 0);
    }
}
