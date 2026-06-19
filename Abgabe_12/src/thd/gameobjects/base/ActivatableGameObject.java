package thd.gameobjects.base;

/**
 * Used for GameObjects that not always Visible.
 *
 * @param <T>The type of object required to check activation conditions.
 */
public interface ActivatableGameObject<T> {
    /**
     * Checks if the GameObject can be activated.
     *
     * @param info Can be "null". But checks if the GameObject can be activated
     * @return true if can Activated
     */
    boolean tryToActivate(T info);
}
