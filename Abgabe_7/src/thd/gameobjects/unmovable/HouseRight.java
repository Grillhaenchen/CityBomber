package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * Creates the Right side of the Map for now.
 */
public class HouseRight extends GameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HouseRight(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(GameView.WIDTH - 190, 0);
        size = 0.50;
        width = 150;
        height = 43;
        distanceToBackground = 1;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("house2.png", position.getX(), position.getY(), size, 0);
//        gameView.addImageToCanvas("house2.png", position.getX(), position.getY() + 300, size, 0);
//        gameView.addImageToCanvas("house2.png", position.getX(), position.getY() + 600, size, 0);
    }
}
