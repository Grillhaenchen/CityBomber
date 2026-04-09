package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.awt.*;

public class RandomBall {
    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;
    private final Position targetPosition;
    private double speedInPixel;
    private double rotation;

    public RandomBall(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(100, 100);
        this.targetPosition = new Position(1000, 500);
        size = 55;
        width = 1;
        height = 1;
        speedInPixel = 4;
    }

    public Position getPosition() {
        return position;
    }

    public void addToCanvas() {
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 0, true, Color.yellow);
        gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 2, false, Color.white);
    }

    public void updatePosition() {
        position.moveToPosition(targetPosition, speedInPixel);
    }


}
