package thd.game.level;

/**
 * Base Class for all Levels.
 */
public class Level {
    public String name;
    public int number;
    public String world;
    public int worldOffsetColumns;
    public int worldOffsetLines;
    public static Difficulty difficulty = Difficulty.STANDARD;
}
