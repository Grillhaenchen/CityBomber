package thd.gameobjects.unmovable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.CollidingGameObject;
import thd.gameobjects.base.ShiftableGameObject;

/**
 * Base Class for Map triggers used to move the non UserCars through the Map.
 */
abstract class BaseTrigger extends CollidingGameObject implements ShiftableGameObject {
    /**
     * Base Constructor to create a Trigger.
     *
     * @param gameView        Instance of GameView.
     * @param gamePlayManager Instance of GamePlayManager.
     */
    BaseTrigger(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        height = 30;
        width = 2000;
        distanceToBackground = 350;
    }
}
