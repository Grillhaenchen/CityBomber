package game;

import java.awt.*;

public class Ufo {
    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;

    Ufo(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, (double) GameView.HEIGHT / 2);
        this.speedInPixel = 3;
        this.size = 30;
        this.rotation = 0;
    }

    public void updatePosition() {
        this.position.right();
        this.rotation += 1;
    }

    public void addToCanvas() {
        gameView.addTextToCanvas("Objekt 1", position.getX(), position.getY(),
                size, true, Color.YELLOW, rotation);
    }

    @Override
    public String toString() {
        return "Ufo: " + position;
    }
}
