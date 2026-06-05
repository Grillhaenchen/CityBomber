package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

public class GreenWithStreet extends GameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView        GameView instance w
     * @param gamePlayManager GamePlayManager Instance
     */
    public GreenWithStreet(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(0, 0);
        size = 0.97;
        width = 150;
        height = 43;
        distanceToBackground = 301;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("green_with_street.png", position.getX() +69, position.getY(), size, 0);
    }
}
