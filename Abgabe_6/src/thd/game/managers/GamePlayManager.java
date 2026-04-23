package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

/**
 * Class for the GamePlayManager his main purpose is the creation of GameObjects and the remove of them.
 */
public class GamePlayManager extends UserControlledGameObjectPool {

    private final GameObjectManager gameObjectManager;
    private int currentNumberOfVisibleSquares;

    private static final int LIVES = 3;
    protected int lives;
    protected int points;

    /**
     * Create a instance of GamePlayManager.
     *
     * @param gameView Instance of GameView.
     */
    protected GamePlayManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
        lives = LIVES;
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
     */
    @Override
    protected void processFrame() throws TooManyGameObjectsException {
        super.processFrame();
        gameObjectManager.processFrame();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
        if (gameView.timer(1000, 0, this) && currentNumberOfVisibleSquares < 5) {
            currentNumberOfVisibleSquares++;
        }
    }

    /**
     * remove one life.
     */
    public void lifeLost() {
        lives--;
    }

    /**
     * add Points.
     *
     * @param points the amount of point you will add
     */
    public void addPoints(int points) {
        this.points += points;
    }
}
