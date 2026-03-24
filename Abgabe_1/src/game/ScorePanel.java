package game;

import java.awt.*;

public class ScorePanel {
    GameView gameView;
    Position position;
    double size;
    double rotation;

    public ScorePanel(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(GameView.WIDTH, 0);
        this.size = 30;
        this.rotation = 90;
    }

    public void addToCanvas() {
        gameView.addTextToCanvas("Objekt 3", position.getX() - 100, position.getY() + 70,
                size, true, Color.WHITE, rotation);
    }

    @Override
    public String toString() {
        return "UFO: " + this.position.toString();
    }
}
