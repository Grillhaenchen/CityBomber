package thd.game.level;

/**
 * This is the Class for Level 2.
 */
public class Level2 extends Level {
    /**
     * Crate a instance of Level 2.
     */
    public Level2() {
//        world = """
//                            \s
//                L  S       R\s
//                       P    \s
//                L  S       R\s
//                            \s
//                L  S       R\s
//                            \s
//                L  S       F\s
//                          P \s
//                L  S       F\s
//                        C   \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                          P \s
//                L  S       F\s
//                        C   \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                            \s
//                L  S       F\s
//                          P \s
//                L  S       F\s
//                        C   \s
//                L  S       F\s
//                            \s
//                L  SU      F\s""";

        world = """
                L S       S R\s
                L S   P   S R\s
                L S       S R\s
                L S       S R\s
                L D       S R\s
                L D   C   S R\s
                L D       S R\s
                L  S     S  R\s
                L   S   S   R\s
                L    S S    R\s
                L     S     R\s
                L     S     R\s
                L    S      R\s
                L   S       R\s
                L  S        R\s
                L S R       R\s
                L S R     S R\s
                L S R C   S R\s
                L S R     S R\s
                L D R     S R\s
                L D R     P R\s
                L  S     S R \s
                L   S   S R  \s
                L    S S R   \s
                L     S R    \s
                L     S R    \s
                L    S R     \s
                L   S R      \s
                L  S R       \s
                L S  R       \s
                L S  R       \s
                L S  R       \s
                L SU R       \s""";

        worldOffsetColumns = 30;
        worldOffsetLines = 0;
        number = 2;
    }
}
