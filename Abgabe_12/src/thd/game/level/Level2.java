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
                f       f     \s
                L S  gggg S  R\s
                L S  gggg S  R\s
                L Sp gggg S  R\s
                L S  gggg S  R\s
                L Dp gggg S  R\s
                L D Cgggg S  R\s
                L D  gggg S  R\s
                L bS  gg S   R\s
                L GbSp  S    R\s
                L GGbS S     R\s
                L GGGbS      R\s
                L GGGBSp     R\s
                L GGBS       R\s
                L GBS        R\s
                L BS         R\s
                L S  R   f   R\s
                L S  R    S  R\s
                L Sp R    S  R\s
                L S CRggg S  R\s
                L D  Rggg S  R\s
                LVD  Rggg S PR\s
                L bSp gggS  Rg\s
                L GbS  gS  Rgg\s
                L GGbS S  Rggg\s
                LXGGGbSp Rgggg\s
                LVGGGBS  Rgggg\s
                L GGBS  Rggggg\s
                L GBSp Rgggggg\s
                L BSp Rggggggg\s
                LYS  Rgggggggg\s
                L Sp Rgggggggg\s
                L S  Rgggggggg\s
                L SU Rgggggggg\s
                L S  Rgggggggg\s
                L S  Rgggggggg\s
                L S  Rgggggggg\s
                L S  Rgggggggg\s""";
        worldOffsetColumns = 30;
        worldOffsetLines = 0;
        number = 2;
        name = "Level 2";
    }
}
