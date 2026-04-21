package thd.game.managers;

import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

public class GamePlayManager extends UserControlledGameObjectPool {

    GameObjectManager gameObjectManager;

    GamePlayManager(GameView gameView) {
        super(gameView);
        this.gameObjectManager = new GameObjectManager();
    }

    public void spawnGameObject(GameObject gameObject) {
        gameObjectManager.add(gameObject);
    }

    public void destroyGameObject(GameObject gameObject) {
        gameObjectManager.remove(gameObject);
    }

    protected void destroyAllGameObjects() {
        gameObjectManager.removeAll();
    }

    @Override
    protected void processFrame() {
        super.processFrame();
        gameObjectManager.processFrame();
        gamePlayManagement();
    }

    private void gamePlayManagement() {
    }
}
