package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * Class to Display the Score of the current Game.
 */
public class Score extends GameObject {
    /**
     * Create a instance of the Score.
     *
     * @param gameView    Instance of GameView
     * @param gamePlayManager Instance of GamePlayManager
     */
    public Score(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates((double) GameView.WIDTH / 2, 0);
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("Score: 100", position.getX(), position.getY(), 20, true, Color.black, 0, "droidsansmono.ttf");
        gameView.addRectangleToCanvas(position.getX() - 2, position.getY() + 3, 135, 20, 2, false, Color.WHITE);

    }
}
