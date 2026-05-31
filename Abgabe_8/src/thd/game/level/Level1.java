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
        number = 1;
    }

}
