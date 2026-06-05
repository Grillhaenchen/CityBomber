package thd.game.level;

/**
 * Exception Class for if no more Level is available.
 */
public class NoMoreLevelsAvailableException extends RuntimeException {
    /**
     * Constructor for throw a new NoMoreLevelsAvailableException.
     *
     * @param message Exception text.
     */
    public NoMoreLevelsAvailableException(String message) {
        super(message);
    }
}
