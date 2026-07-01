package thd.game.level;

import java.util.Arrays;
import java.util.Optional;

/**
 * Describe the Difficulty of the Game.
 */
public enum Difficulty {
    EASY("Einfach"),
    STANDARD("Standard");

    public final String name;

    /**
     * gets difficilty form Name.
     *
     * @param name enum name.
     * @return correct enum value or EASY if no match is found.
     */
    public static Difficulty fromName(String name) {
        return Arrays.stream(Difficulty.values())
                .filter(difficulty -> difficulty.name.equalsIgnoreCase(name))
                .findFirst()
                .orElse(EASY);

    }

    Difficulty(String name) {
        this.name = name;
    }
}
