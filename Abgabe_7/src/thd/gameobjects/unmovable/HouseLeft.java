package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Creates the Left side of the Map.
 */
public class HouseLeft extends GameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HouseLeft(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(0, 0);
        size = 0.75;
        width = 150;
        height = 43;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("house1.png", position.getX(), position.getY(), size, 180);
        gameView.addImageToCanvas("house1.png", position.getX(), position.getY() + 300, size, 180);
        gameView.addImageToCanvas("house1.png", position.getX(), position.getY() + 600, size, 180);
    }

}
