package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

import java.util.Optional;

/**
 * Movement Pattern for movement to the left side.
 */
class MoveLeftMovementPattern extends MovementPattern {
    private final Position[] pattern;
    private int currentIndex;

    /**
     * Create a new Movement Pattern.
     */
    MoveLeftMovementPattern() {
        pattern = new Position[]{
                new Position(1280, 100),
                new Position(700, 100)};
    }

    /**
     * switch to the next position.
     *
     * @return next movement position.
     */
    @Override
    public Optional<Position> nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return Optional.ofNullable(pattern[currentIndex++]);
    }

    /**
     * Return the startposition.
     *
     * @return the startposition.
     */
    @Override
    public Optional<Position> startPosition() {
        currentIndex = 0;
        return nextPosition();
    }

    /**
     * True if have the last position of the pattern.
     *
     * @return True if have the last position of the pattern.
     */
    @Override
    public boolean isLastPosition() {
        return currentIndex >= pattern.length;
    }
}
