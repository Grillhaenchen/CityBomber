package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * Followerball Class who moves Randowm.
 */
public class FollowerBall extends GameObject {

    private final RandomBall followMe;

    /**
     * Create a instance of FollowerBall.
     *
     * @param gameView GameView instance
     * @param followMe RandomBall instance
     */
    public FollowerBall(GameView gameView, RandomBall followMe) {
        super(gameView, new Position(0, 0), new Position(followMe.getPosition()));
        this.followMe = followMe;

        size = 55;
        width = 1;
        height = 1;
        speedInPixel = 3;
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 0, true, Color.green);
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 2, false, Color.white);
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void updatePosition() {
        position.moveToPosition(followMe.getPosition(), speedInPixel);
    }
}
