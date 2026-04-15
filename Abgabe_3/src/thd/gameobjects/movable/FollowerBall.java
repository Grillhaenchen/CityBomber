package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * Followerball Class who moves Randowm.
 */
public class FollowerBall extends GameObject {
    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;
    private final Position targetPosition;
    private final RandomBall followMe;
    private double speedInPixel;
    private double rotation;

    /**
     * Create a instance of FollowerBall.
     *
     * @param gameView GameView instance
     * @param followMe RandomBall instance
     */
    public FollowerBall(GameView gameView, RandomBall followMe) {
        super(gameView);
        this.gameView = gameView;
        this.position = new Position(0, 0);
        this.followMe = followMe;
        this.targetPosition = new Position(followMe.getPosition());
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
