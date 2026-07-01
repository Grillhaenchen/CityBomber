package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

import java.util.Optional;

/**
 * Movement Position for Helicopter.
 */
public class HelicopterMovementPattern extends MovementPattern {
    private final Position[] pattern;
    private int currentIndex;

    /**
     * Create a new MovementPattern for the Helicopter with predefined positions.
     */
    HelicopterMovementPattern() {
        pattern = new Position[]{
                new Position(200, 100),
                new Position(800, 400),
                new Position(1000, 1200),
                new Position(500, 800),
                new Position(300, 200)};
    }

    @Override
    public Optional<Position> nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return Optional.ofNullable(pattern[currentIndex++]);
    }

    @Override
    public Optional<Position> startPosition() {
        currentIndex = 0;
        return nextPosition();
    }

    @Override
    public boolean isLastPosition() {
        return currentIndex >= pattern.length;
    }
}
