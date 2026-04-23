package thd.game.managers;

import thd.gameobjects.base.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that handels all GameObjects.
 */
public class GameObjectManager extends CollisionManager {
    private final List<GameObject> gameObjects;
    private final List<GameObject> gameObjectsToBeAdded;
    private final List<GameObject> gameObjectsToBeRemoved;
    private static final int MAXIMUM_NUMBER_OF_GAME_OBJECTS = 500;

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

    void processFrame() throws TooManyGameObjectsException {
        updateLists();
        for (GameObject gameObject : gameObjects) {
            gameObject.updateStatus();
            gameObject.updatePosition();
            gameObject.addToCanvas();
        }
        manageCollisions(false);
    }

    private void updateLists() throws TooManyGameObjectsException {
        removeFromGameObjects();
        addToGameObjects();
        if (gameObjects.size() > MAXIMUM_NUMBER_OF_GAME_OBJECTS) {
            throw new TooManyGameObjectsException("Max Amount of GameElements reached (max " + MAXIMUM_NUMBER_OF_GAME_OBJECTS + ")");

        }
    }

    private void removeFromGameObjects() {

        for (GameObject gameObject : gameObjectsToBeRemoved) {
            gameObjects.remove(gameObject);
            super.removeFromCollisionManagement(gameObject);
        }
        gameObjectsToBeRemoved.clear();
    }

    private void addToGameObjects() {
        gameObjects.addAll(gameObjectsToBeAdded);
        for (GameObject gameObject : gameObjectsToBeAdded) {
            gameObjects.add(gameObject);
            super.addToCollisionManagement(gameObject);
        }
        gameObjectsToBeAdded.clear();
    }

}
