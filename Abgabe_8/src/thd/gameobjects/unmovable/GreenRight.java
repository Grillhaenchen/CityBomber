package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

public class GreenRight extends GameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public GreenRight(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(0, 0);
        size = 1.18;
        width = 150;
        height = 43;
        distanceToBackground = 301;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("green.png", position.getX() + 70, position.getY(), size, 0);
    }
}
