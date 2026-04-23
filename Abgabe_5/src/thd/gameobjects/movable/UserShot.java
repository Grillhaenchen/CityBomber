package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

/**
 * If the User Fire a bullet this Class handles all the collision detection and the UI element.
 */
public class UserShot extends GameObject {

    /**
     * Creates a Bullet.
     *
     * @param gameView    GameView instance
     * @param gamePlayManager GamePlayManager Instance
     */
    public UserShot(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, new Position((double) GameView.WIDTH / 2, (double) GameView.HEIGHT / 2), new Position((double) GameView.WIDTH / 2, (double) GameView.HEIGHT / 2), gamePlayManager);
        size = 1;
        width = 1;
        height = 1;
        speedInPixel = 4;
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see GameView
     */
    @Override
    public void updatePosition() {
        position.up(speedInPixel);
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("shot.png", position.getX(), position.getY(), 1, 0);
    }

    @Override
    public void updateStatus(){
        if (position.getY() < 20) {
            gamePlayManager.destroyGameObject(this);
        }
    }
}
