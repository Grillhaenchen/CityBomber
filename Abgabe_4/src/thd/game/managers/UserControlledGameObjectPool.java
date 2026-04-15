package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.movable.UserCar;
import thd.gameobjects.movable.UserShot;
import thd.gameobjects.unmovable.Gate;
import thd.gameobjects.unmovable.Start;
import thd.gameobjects.unmovable.Street;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UserControlledGameObjectPool {

    protected GameView gameView;
    protected UserCar userCar;
    protected UserShot shot;
    protected Start start;
    protected Gate gate;
    protected Street street;

    UserControlledGameObjectPool(){

    }

    protected void processFrame() {
        Integer[] pressedKeys = gameView.keyCodesOfCurrentlyPressedKeys();
        for (int keyCode : pressedKeys) {
            if (keyCode == KeyEvent.VK_A) {
                gameView.addTextToCanvas("Taste A gedrückt", 0, 0, 18, true, Color.WHITE, 0);
            }
        }
    }
}
