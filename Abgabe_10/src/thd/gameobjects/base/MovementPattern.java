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

    protected Optional<Position> nextPosition() {
        return Optional.empty();
    }

    protected Optional<Position>  startPosition() {
        return Optional.empty();
    }
}