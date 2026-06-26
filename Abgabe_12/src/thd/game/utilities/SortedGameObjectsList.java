package thd.game.utilities;

import thd.gameobjects.base.GameObject;

import java.util.LinkedList;

/**
 * Optimized Class for Handling GameObjects.
 */
public class SortedGameObjectsList extends LinkedList<GameObject> {

    @Override
    public boolean add(GameObject toAdd) {
        int indexToSortIn = 0;
        for (GameObject gameObject : this) {
            if (gameObject.getDistanceToBackground() >= toAdd.getDistanceToBackground()) {
                break;
            }
            indexToSortIn++;
        }
        super.add(indexToSortIn, toAdd);
        return true;
    }
}
