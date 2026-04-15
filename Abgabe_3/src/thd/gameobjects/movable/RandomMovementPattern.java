package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

import java.util.Random;

class RandomMovementPattern {

    private final Random random;

    RandomMovementPattern() {
        random = new Random();
    }

    Position startPosition() {
        return new Position(GameView.WIDTH / 2d, GameView.HEIGHT / 2d);
    }

    Position nextPosition() {
        return new Position(random.nextInt(GameView.WIDTH), random.nextInt(GameView.HEIGHT));
    }
}