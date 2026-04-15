package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

public class FollowerBall {
    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;
    private final Position targetPosition;
    private final RandomBall followMe;
    private double speedInPixel;
    private double rotation;

    public FollowerBall(GameView gameView, RandomBall followMe) {
        this.gameView = gameView;
        this.position = new Position(0, 0);
        this.followMe = followMe;
        this.targetPosition = new Position(followMe.getPosition());
        size = 55;
        width = 1;
        height = 1;
        speedInPixel = 3;
    }

    public void addToCanvas() {
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 0, true, Color.green);
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 2, false, Color.white);
    }

    public void updatePosition() {
        position.moveToPosition(followMe.getPosition(), speedInPixel);
    }
}
