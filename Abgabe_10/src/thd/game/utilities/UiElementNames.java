package thd.game.utilities;

import java.util.Optional;

/**
 * Enum for UI Elements.
 */
public enum UiElementNames {
    LEFT_HOUSE('L'),
    RIGHT_HOUSE('R'),
    STREET('S'),
    DIRT_ROAD('D'),
    DIRT('E'),
    STREET_BORDER_LEFT('B'),
    STREET_BORDER_LEFT_MIRROR('b'),
    GREEN('G'),
    GREEN_RIGHT('g'),
    GREEN_WITH_STREET('Q'),

    POLICE_CAR('P'),
    RANDOM_CAR('C'),
    USER_CAR('U'),

    FIELD('F'),
    FINISH('f'),

    TRIGGER_TO_LEFT('Y'),
    TRIGGER_TO_RIGHT('X'),
    TRIGGER_TO_STRAIGHT('V'),

    SPLIT(' ');

    /**
     * Convert Char to Enum.
     *
     * @param character char type.
     * @return UiElement Enum.
     */
    public static UiElementNames fromChar(char character) {
        for (UiElementNames name : UiElementNames.values()) {
            if (name.uiType == character) {
                return name;
            }
        }
        throw new IndexOutOfBoundsException("Map char not found: " + character);
    }

    private char uiType;

    private UiElementNames(char uiType) {
        this.uiType = uiType;
    }
}
