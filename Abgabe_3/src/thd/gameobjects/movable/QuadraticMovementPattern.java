package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

class QuadraticMovementPattern extends MovementPattern {

    private final Position[] pattern;
    private int currentIndex;

    QuadraticMovementPattern() {
        pattern = new Position[]{
                new Position(100, 100),
                new Position(1100, 100),
                new Position(1100, 600),
                new Position(100, 600)};
    }

    @Override
    public Position nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return pattern[currentIndex++];
    }

    @Override
    public Position startPosition() {
        currentIndex = 0;
        return nextPosition();
    }
}