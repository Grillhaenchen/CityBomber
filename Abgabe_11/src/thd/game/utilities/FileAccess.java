package thd.game.utilities;

import thd.game.level.Difficulty;
import thd.game.level.Level;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Handles the file access for the savegame. It can read and write the savegame to the disc. The savegame contains the difficulty of the game.
 */
public class FileAccess {
    private static final Path SAVEGAME_DIRECTORY = Path.of(System.getProperty("user.home")).resolve("savegame");
    private static final String SAVEGAME_FILENAME = "kilian_mayerhofer_savegame.txt";
    private static final Path SAVEGAME_FILE = SAVEGAME_DIRECTORY.resolve(SAVEGAME_FILENAME);

    /**
     * Write files to Disc.
     */
    public static void writeSaveGameToDisc() {
        try {
            if (!Files.exists(SAVEGAME_DIRECTORY)) {
                Files.createDirectories(SAVEGAME_DIRECTORY);
            }

            String difficultyText = String.valueOf(Level.difficulty);
            Files.writeString(SAVEGAME_FILE, difficultyText);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Wichtl makes strange stuff.
     */
    public static void readDifficultyFromDisc() {
    }

    /**
     * Wichtl makes strange stuff.
     */
    public static void writeDifficultyToDisc() {

    }

    /**
     * Read info from Disc.
     */
    public static void readSaveGameFromDisc() {
        try {
            String content = Files.readString(SAVEGAME_FILE).trim();
            Difficulty difficulty = Difficulty.STANDARD;
            for (Difficulty d : Difficulty.values()) {
                if (d.name().equals(content)) {
                    difficulty = d;
                    break;
                }
            }
            Level.difficulty = difficulty;
        } catch (IOException e) {
            Level.difficulty = Difficulty.STANDARD;
        }
    }
}
