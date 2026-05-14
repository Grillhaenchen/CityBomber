package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

import java.awt.*;

/**
 * For Timekeeping.
 */
public class Countdown extends GameObject {
    /**
     * Creates a instance of the Countdown.
     *
     * @param gameView        Instance of GameView.
     * @param gamePlayManager Instance of GamePlayManager.
     */
    public Countdown(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates((double) GameView.WIDTH / 2 + 150, 0);
        height = 20;
        size = 0.5;
        width = 210;
        distanceToBackground = Integer.MAX_VALUE;
    }

    @Override
    public void addToCanvas() {
        gameView.addTextToCanvas("Timer: 00:00:00", position.getX(), position.getY(), 20, true, Color.black, 0, "droidsansmono.ttf");
        gameView.addRectangleToCanvas(position.getX() - 2, position.getY() + 3, width, height, 2, false, Color.WHITE);
    }
}
