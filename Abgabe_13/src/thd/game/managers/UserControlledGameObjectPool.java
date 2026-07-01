package thd.game.managers;

import thd.game.level.Level;
import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.*;

import java.awt.event.KeyEvent;

/**
 * Class for UserInput.
 */
class UserControlledGameObjectPool {

    protected final GameView gameView;
    protected UserCar userCar;
    protected UserShot shot;
    protected Street street;
    protected Helicopter helicopter;
    protected Score score;
    protected Lives lives1;
    protected Countdown countdown;
    protected Level level;
    protected Overlay overlay;

    UserControlledGameObjectPool(GameView gameView) {
        this.gameView = gameView;
    }

    protected void processFrame() throws TooManyGameObjectsException {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            processKeyCode(keyCode);
        }
    }

    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_A) {
            userCar.left();
        } else if (keyCode == KeyEvent.VK_D) {
            userCar.right();
        } else if (keyCode == KeyEvent.VK_SPACE) {
            userCar.shoot();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            userCar.left();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            userCar.right();
        }
    }
}
