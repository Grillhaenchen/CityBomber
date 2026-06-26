package thd.gameobjects.movable;

import thd.gameobjects.base.MovementPattern;
import thd.gameobjects.base.Position;

import java.util.Optional;

class StraightMoveMovmentPattern extends MovementPattern {
    private final Position[] pattern;
    private int currentIndex;

    StraightMoveMovmentPattern(Position position) {
        pattern = new Position[]{
                new Position(position.getX(), position.getY()),
                new Position(position.getX(), position.getY())};
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
