package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;
import thd.gameobjects.movable.Square;

/**
 * Class for the GamePlayManager his main purpose is the creation of GameObjects and the remove of them.
 */
public class GamePlayManager extends UserControlledGameObjectPool {

    private final GameObjectManager gameObjectManager;
    private int currentNumberOfVisibleSquares;

    /**
     * Create a instance of GamePlayManager.
     *
     * @param gameView Instance of GameView.
     */
    protected GamePlayManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
    }

    /**
     * spawn a object on the GameView.
     *
     * @param gameObject Instance of some GameObject.
     */
    public void spawnGameObject(GameObject gameObject) {
        gameObjectManager.add(gameObject);
    }

    /**
     * Removes a GameObject from the GameView.
     *
     * @param gameObject Instance of GameObject.
     */
    public void destroyGameObject(GameObject gameObject) {
        gameObjectManager.remove(gameObject);
    }

    /**
     * Removes All GameObjects from GameView.
     */
    protected void destroyAllGameObjects() {
        gameObjectManager.removeAll();
    }

    /**
     * Process a Frame in the GameView.
     *
     * @throws TooManyGameObjectsExeption thows when the more than 500 GameObjects are Displayed.
     */
    @Override
    protected void processFrame() throws TooManyGameObjectsExeption {
        super.processFrame();
        gameObjectManager.processFrame();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
        if (gameView.timer(1000, 0, this) && currentNumberOfVisibleSquares < 5) {
            spawnGameObject(new Square(gameView, this));
            currentNumberOfVisibleSquares++;
        }
    }
}
