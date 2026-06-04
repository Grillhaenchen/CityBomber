package thd.game.level;

/**
 * This is the Class for Level 1.
 */
public class Level1 extends Level {
    /**
     * Create a instance of Level 1.
     */
    public Level1() {

        world = """
                L S  R   \s
                L S  R   \s
                L bS  R  \s
                L GbS  R \s
                L GGbS  R\s
                L GGBS  R\s
                L GBS  R \s
                L BS  R  \s
                L S  R   \s
                L S  R   \s
                L S  R   \s
                L S  R   \s
                L S  R   \s
                L bS  R  \s
                L GbS  R \s
                L GGbS  R\s
                L GGBS  R\s
                L GBS  R \s
                L BS  R  \s
                L SC R   \s
                L S  R   \s
                L S  R   \s
                L S  R   \s 
                L S  R   \s 
                L bS  R  \s 
                L GbS  R \s 
                L GGbS  R\s 
                L GGBS PR\s 
                L GBS  R \s 
                L BS  R  \s 
                L SC R   \s 
                L S  R   \s 
                L SU R   \s""";

        worldOffsetColumns = 30;
        worldOffsetLines = 0;
        number = 1;
    }

}
