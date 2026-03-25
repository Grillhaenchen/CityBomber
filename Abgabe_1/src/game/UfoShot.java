package game;

import java.awt.*;

public class UfoShot {

    GameView gameView;
    Position position;
    double speedInPixel;
    double size;
    double rotation;
    double width;
    double height;

    public UfoShot(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(1100, 650);
        this.size = 30;
        this.width = 150;
        this.height = 33;
        this.rotation = 2;
        this.speedInPixel = 2;
    }

    public void updatePosition() {
        this.position.left(speedInPixel);
    }

    public void addToCanvas() {

        // InnerBorder(White)
        gameView.addRectangleToCanvas(position.getX(), position.getY(), width, height, 5, false, Color.WHITE);
        // Green Box
        gameView.addRectangleToCanvas(position.getX() + 2.5, position.getY() + 2.5, width, height, 0, true, Color.GREEN);
        // Yellow Box
        gameView.addRectangleToCanvas(position.getX() + 130 + 2.5, position.getY() + 2.5, width - 130, height, 0, true, Color.YELLOW);
        // Text
        gameView.addTextToCanvas("Objekt 2", position.getX() + 2.5, position.getY() - 2.5, size, true, Color.BLUE, 0);
    }

    @Override
    public String toString() {
        return "UfoShot: " + this.position.toString();
    }
}
