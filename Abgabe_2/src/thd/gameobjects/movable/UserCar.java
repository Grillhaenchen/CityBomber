package thd.gameobjects.movable;

import thd.game.utilities.GameView;
import thd.gameobjects.base.Figur;
import thd.gameobjects.base.Position;

public class UserCar extends Figur {

    public UserCar(GameView gameView) {
        this.gameView = gameView;
        this.position = new Position(0, (double) GameView.HEIGHT / 2);
    }

    @Override
    public void updatePosition() {

    }

    @Override
    public void addToCanvas() {
        gameView.addImageToCanvas("car_red_driving.png", position.getX(), position.getY(), 1, 0);
    }
}
