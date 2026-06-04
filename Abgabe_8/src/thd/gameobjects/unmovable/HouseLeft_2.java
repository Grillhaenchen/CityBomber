package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

public class HouseLeft_2 extends GameObject implements ShiftableGameObject {

    /**
     * This is the UI element for the end in the Progress bar.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public HouseLeft_2(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(0, 0);
        size = 0.73;
        width = 150;
        height = 43;
        distanceToBackground = 1;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("house_left_2.png", position.getX() + 114, position.getY(), size, 0);
    }
}
