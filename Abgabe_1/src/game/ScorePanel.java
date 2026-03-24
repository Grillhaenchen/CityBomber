package game;

import java.awt.*;

public class ScorePanel {
    GameView gameView;
    Position position;
    double size;
    double rotation;
    double width;
    double height;

    public ScorePanel(GameView gameView) {
        this.gameView = gameView;
        this.width = 100;
        this.height = 70;
        this.position = new Position(GameView.WIDTH - width, height);
        this.size = 30;
        this.rotation = 90;
    }

    public void addToCanvas() {
        gameView.addTextToCanvas("Objekt 3", position.getX(), position.getY(), size, true, Color.WHITE, rotation);
    }

    @Override
    public String toString() {
        return "UFO: " + this.position.toString();
    }
}
