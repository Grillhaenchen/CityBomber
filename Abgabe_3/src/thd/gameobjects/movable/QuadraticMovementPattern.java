package thd.gameobjects.movable;

import thd.gameobjects.base.Position;

class QuadraticMovementPattern {

    private final Position[] pattern;
    private int currentIndex;

    QuadraticMovementPattern() {
        pattern = new Position[]{
                new Position(100, 100),
                new Position(1100, 100),
                new Position(1100, 600),
                new Position(100, 600)};
    }

    Position nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return pattern[currentIndex++];
    }

    Position startPosition() {
        currentIndex = 0;
        return nextPosition();
    }
}