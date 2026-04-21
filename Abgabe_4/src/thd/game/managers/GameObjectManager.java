package thd.game.managers;

import thd.gameobjects.base.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that handels all GameObjects.
 */
public class GameObjectManager {
    private final List<GameObject> gameObjects;
    private final List<GameObject> gameObjectsToBeAdded;
    private final List<GameObject> gameObjectsToBeRemoved;

    GameObjectManager() {
        this.gameObjects = new LinkedList<>();
        this.gameObjectsToBeAdded = new LinkedList<>();
        this.gameObjectsToBeRemoved = new LinkedList<>();
    }

    void add(GameObject gameObject) {
        gameObjectsToBeAdded.add(gameObject);
    }

    void remove(GameObject gameObject) {
        gameObjectsToBeRemoved.add(gameObject);
    }

    void removeAll() {
        gameObjectsToBeAdded.clear();

        gameObjectsToBeRemoved.addAll(gameObjects);
    }

    void processFrame() {
        updateLists();
        for (GameObject gameObject : gameObjects) {
        }
    }

    private void updateLists() {
        removeFromGameObjects();
        addToGameObjects();
    }

    private void removeFromGameObjects() {
    }

    private void addToGameObjects() {
    }

}
