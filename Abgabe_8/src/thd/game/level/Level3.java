package thd.game.level;

/**
 * This is the Class for Level 3.
 */
public class Level3 extends Level {
    /**
     * Create a instance of Level 3.
     */
    public Level3() {
        world = """ 
                            \s
                L  D       R\s
                       P    \s 
                L  D       R\s 
                            \s 
                L  D       R\s 
                            \s
                L  D       R\s
                          P \s 
                L  D       R\s 
                        C   \s 
                L  D       R\s 
                            \s
                L  D       R\s 
                            \s 
                L  D       R\s 
                            \s
                L  D       R\s
                          P \s 
                L  D       R\s 
                        C   \s 
                L  D       R\s 
                            \s 
                L  D       R\s 
                            \s 
                L  D       R\s 
                            \s
                L  D       R\s
                          P \s 
                L  D       R\s 
                        C   \s 
                L  D       R\s 
                    U       \s  
                L  D       R\s""";

        worldOffsetColumns = 26;
        worldOffsetLines = 0;
        number = 3;
    }
}
