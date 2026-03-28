package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.UserCar;
import thd.gameobjects.movable.UserShot;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

public class GameManager {

    private final GameView gameView;
    private UserCar userCar;
    private UserShot shot;
    private Start start;
    private Gate gate;
    private Street street;

    public GameManager(GameView gameView) {
        this.gameView = gameView;
        userCar = new UserCar(gameView);
        shot = new UserShot(gameView);
        start = new Start(gameView);
        gate = new Gate(gameView);
        street = new Street(gameView);

    }

    void processFrame(){
        userCar.addToCanvas();
        userCar.updatePosition();
        shot.addToCanvas();
        start.addToCanvas();
        gate.addToCanvas();
        street.addToCanvas();
    }
}
