package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;

import java.awt.*;

/**
 * Class for Map trigger used to move the non UserCars to the straight side the Map.
 */
public class MoveStraightTrigger extends BaseTrigger {
    /**
     * Create the Trigger.
     *
     * @param gameView        Instance of GameView.
     * @param gamePlayManager Instance of GamePlayManager.
     */
    public MoveStraightTrigger(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        super.hitBoxOffsets(-1200, 0, 0, 0);
    }

    /**
     * react to Collision.
     *
     * @param other The other game object that is involved in the collision.
     */
    @Override
    public void reactToCollisionWith(CollidingGameObject other) {

    }

    /**
     * Add the Game Piece to the GameView.
     */
    @Override
    public void addToCanvas() {
        gameView.addRectangleToCanvas(0, position.getY(), width, height, 0, false, Color.ORANGE);
        super.hitBoxOffsets(-position.getX(), 0, 0, 0);
    }
}
