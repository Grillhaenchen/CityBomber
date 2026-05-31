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
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s 
                L  S       R\s 
                            \s
                L  S       R\s
                          P \s 
                L  S       R\s 
                        C   \s 
                L  S       R\s 
                            \s  
                L  SU      R\s""";

        worldOffsetColumns = 27;
        worldOffsetLines = 0;
        number = 2;
    }
}
