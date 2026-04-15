package thd.gameobjects.base;

import java.util.Random;

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