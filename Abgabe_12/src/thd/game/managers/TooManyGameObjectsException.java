package thd.game.managers;

/**
 * Exception with notify the user there are to many GameObjects in List.
 */
public class TooManyGameObjectsException extends RuntimeException {
    /**
     * Create a Exception.
     *
     * @param message notify message
     */
    public TooManyGameObjectsException(String message) {
        super(message);
    }
}
