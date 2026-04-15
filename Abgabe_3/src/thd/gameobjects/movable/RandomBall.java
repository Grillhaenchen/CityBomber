package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.base.Position;

import java.awt.*;

/**
 * Randomball Class who moves Randowm.
 */
public class RandomBall extends GameObject {

    /**
     * Creates a RandomBall object.
     *
     * @param gameView instance of GameView
     */
    public RandomBall(GameView gameView) {
        super(gameView, new RandomMovementPattern().startPosition(), new QuadraticMovementPattern().nextPosition());
        position.updateCoordinates(position);
        targetPosition.updateCoordinates(position);

        size = 55;
        width = 1;
        height = 1;
        speedInPixel = 4;
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
            targetPosition.updateCoordinates(new QuadraticMovementPattern().nextPosition());
        }
    }
}
