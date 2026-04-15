package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

class OwnMovementPattern extends MovementPattern {
    private final Position[] pattern;
    private int currentIndex;

    OwnMovementPattern() {
        pattern = new Position[]{
                new Position(300, 100),
                new Position(1500, 50),
                new Position(1400, 800),
                new Position(1000, 700)};
    }

    @Override
    protected Position nextPosition() {
        if (currentIndex >= pattern.length) {
            currentIndex = 0;
        }
        return pattern[currentIndex++];
    }

    @Override
    protected Position startPosition() {
        currentIndex = 0;
        return nextPosition();
    }
}
