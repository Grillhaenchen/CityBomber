package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * Randomball Class who moves Randowm.
 */
public class RandomBall extends GameObject {
    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;
    private final Position targetPosition;
    private final QuadraticMovementPattern quadraticMovementPattern;
    private double speedInPixel;
    private double rotation;

    /**
     * Creates a RandomBall object.
     *
     * @param gameView instance of GameView
     */
    public RandomBall(GameView gameView) {
        super(gameView);
        this.quadraticMovementPattern = new QuadraticMovementPattern();
        this.gameView = gameView;
        this.position = new RandomMovementPattern().startPosition();
        this.targetPosition = quadraticMovementPattern.nextPosition();

        size = 55;
        width = 1;
        height = 1;
        speedInPixel = 4;
    }

    /**
     * Get Position of RandomBall.
     *
     * @return Position
     */
    @Override
    public Position getPosition() {
        return position;
    }

    /**
     * Add the Game Piece to the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void addToCanvas() {
        gameView.addOvalToCanvas(targetPosition.getY(), targetPosition.getX(), size, size, 2, false, Color.WHITE);

        if (gameView.gameTimeInMilliseconds() > 5000) {
            gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 0, true, Color.RED);
        } else {
            gameView.addOvalToCanvas(position.getY(), position.getX(), size, size, 0, true, Color.YELLOW);
        }
    }

    /**
     * Update the Position of the Game Piece on the GameView.
     *
     * @see thd.game.utilities.GameView
     */
    @Override
    public void updatePosition() {
        if (gameView.timer(3000, 0, this)) {
            speedInPixel++;
        }

        if (gameView.timer(1000, 4000, this)) {
            position.moveToPosition(targetPosition, speedInPixel);
        }

        if (position.similarTo(targetPosition)) {
            targetPosition.updateCoordinates(quadraticMovementPattern.nextPosition());
        }
    }
}
