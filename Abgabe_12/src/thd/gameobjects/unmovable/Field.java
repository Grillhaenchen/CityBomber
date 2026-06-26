package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * The Class for Field Objects.
 */
public class Field extends GameObject implements ShiftableGameObject {
    /**
     * This is the UI element for the Field.
     *
     * @param gameView        GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public Field(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        getPosition().updateCoordinates(GameView.WIDTH - 190, 0);
        size = 0.74;
        width = 150;
        height = 43;
        distanceToBackground = 1;
    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("field.png", position.getX() - 30, position.getY(), size, 0);
    }
}
