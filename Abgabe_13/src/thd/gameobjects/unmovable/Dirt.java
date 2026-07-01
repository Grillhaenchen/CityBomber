package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the Class for the Dirt Object.
 */
public class Dirt extends GameObject implements ShiftableGameObject {
    /**
     * This is the UI element for Dirt Objects.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public Dirt(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(GameView.WIDTH - 190, 0);
        size = 0.50;
        width = 150;
        height = 43;
        distanceToBackground = 1;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("dirt.png", position.getX(), position.getY(), size, 0);
    }
}
