package thd.gameobjects.base;

import java.util.Random;

/**
 * Baseclass for Movement Patterns.
 */
public class MovementPattern {
    protected final Random random;

    protected MovementPattern() {
        random = new Random();
    }

    protected Position nextPosition() {
        return null;
    }

    protected Position startPosition() {
        return null;
    }
}