package thd.gameobjects.base;

import java.util.Optional;
import java.util.Random;

/**
 * Baseclass for Movement Patterns.
 */
public class MovementPattern {
    protected final Random random;

    protected MovementPattern() {
        random = new Random();
    }

    /**
     * switch to the next position.
     *
     * @return next movement position.
     */
    public Optional<Position> nextPosition() {
        return Optional.empty();
    }

    /**
     * Return the startposition.
     *
     * @return the startposition.
     */
    public Optional<Position> startPosition() {
        return Optional.empty();
    }

    /**
     * True if have the last position of the pattern.
     *
     * @return True if have the last position of the pattern.
     */
    public boolean isLastPosition() {
        return false;
    }
}