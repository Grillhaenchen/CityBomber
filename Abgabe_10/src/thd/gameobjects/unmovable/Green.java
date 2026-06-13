package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * This is the UI element for the green grass.
 */
public class Green extends GameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the green grass.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public Green(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(0, 0);
        size = 1.15;
        width = 150;
        height = 43;
        distanceToBackground = 301;
    }

    /**
     * Add the UI element to the UserWindow.
     */
    @Override
    public void addToCanvas() {
        size = 1.18;
        gameView.addImageToCanvas("green.png", position.getX() - 130, position.getY(), size, 0);
    }
}
