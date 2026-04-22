package thd.game.managers;

/**
 * Exeption with notify the user there are to many GameObjects in List.
 */
public class TooManyGameObjectsExeption extends Throwable {
    /**
     * Create a Exception.
     *
     * @param messange notify message
     */
    public TooManyGameObjectsExeption(String messange) {
        super(messange);
    }
}
