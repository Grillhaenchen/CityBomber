package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Position;

public class UserShot {

    private final GameView gameView;
    private final Position position;

    private final double size;
    private final double width;
    private final double height;

    private double speedInPixel;
    private double rotation;

    public UserShot(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position((double) GameView.WIDTH / 2, (double) GameView.HEIGHT / 2);
        size = 1;
        width = 1;
        height = 1;
    }


    public void updatePosition() {

    }


    public void addToCanvas() {
        gameView.addImageToCanvas("shot.png", position.getX(), position.getY(), 1, 0);
    }
}
