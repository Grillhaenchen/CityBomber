package thd.game.level;

/**
 * This is the Class for Level 2.
 */
public class Level2 extends Level {
    /**
     * Crate a instance of Level 2.
     */
    public Level2() {
        world = """ 
                            \s
                L  S       R\s
                       P    \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       F\s
                          P \s 
                L  S       F\s 
                        C   \s 
                L  S       F\s 
                            \s
                L  S       F\s 
                            \s 
                L  S       F\s 
                            \s
                L  S       F\s
                          P \s 
                L  S       F\s 
                        C   \s 
                L  S       F\s 
                            \s 
                L  S       F\s 
                            \s 
                L  S       F\s 
                            \s
                L  S       F\s
                          P \s 
                L  S       F\s 
                        C   \s 
                L  S       F\s 
                            \s  
                L  SU      F\s""";

        worldOffsetColumns = 27;
        worldOffsetLines = 0;
        number = 2;
    }
}
