package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.*;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Score;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Class for UserInput.
 */
class UserControlledGameObjectPool {

    protected final GameView gameView;
    protected UserCar userCar;
    protected UserShot shot;
    protected Start start;
    protected Gate gate;
    protected Street street;
    protected Helicopter helicopter;
    protected PoliceCar policeCar;
    protected RandomCar randomCar;
    protected Score score;

    UserControlledGameObjectPool(GameView gameView) {
        this.gameView = gameView;
    }

    protected void processFrame() {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_A) {
                gameView.addTextToCanvas("Taste A gedrückt", 0, 0, 18, true, Color.WHITE, 0);
            }
            processKeyCode(keyCode);
        }
    }

    private void processKeyCode(int keyCode) {
        if (keyCode == KeyEvent.VK_A) {
            userCar.left();
        } else if (keyCode == KeyEvent.VK_D) {
            userCar.right();
        } else if (keyCode == KeyEvent.VK_W) {
            userCar.up();
        } else if (keyCode == KeyEvent.VK_S) {
            userCar.down();
        } else if (keyCode == KeyEvent.VK_SPACE) {
            userCar.shoot();
        } else if (keyCode == KeyEvent.VK_LEFT) {
            userCar.left();
        } else if (keyCode == KeyEvent.VK_UP) {
            userCar.up();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            userCar.right();
        } else if (keyCode == KeyEvent.VK_DOWN) {
            userCar.down();
        }
    }
}
