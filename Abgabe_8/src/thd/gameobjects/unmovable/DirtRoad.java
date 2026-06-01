package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the Class for the DirtRoad.
 */
public class DirtRoad extends GameObject implements ShiftableGameObject {
    /**
     * This is the UI element for the DirtRoad.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public DirtRoad(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(GameView.WIDTH - 190, 0);
        size = 1.42;
        width = 150;
        height = 43;
        distanceToBackground = 1;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("dirtroad.png", position.getX() - 30, position.getY(), size, 0);
        gameView.addImageToCanvas("dirtroad.png", position.getX() - 30, position.getY() - 100, size, 0);
    }
}
