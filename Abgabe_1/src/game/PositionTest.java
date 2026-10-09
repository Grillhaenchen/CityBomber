package game;

public class PositionTest {
    public static void main(String[] args) {
        testDefaultConstructor();
        testStepAndPixelMovement();
        testCopyConstructorIsIndependent();
        testUpdateCoordinatesFromPositionCopiesValues();
        testToStringRoundsCoordinates();
        System.out.println("All Position tests passed.");
    }

    private static void testDefaultConstructor() {
        Position position = new Position();
        assertEquals(0, position.getX(), "Default x should be 0");
        assertEquals(0, position.getY(), "Default y should be 0");
    }

    private static void testStepAndPixelMovement() {
        Position position = new Position(10, 10);
        position.left();
        position.up(2.5);
        position.right(3.25);
        position.down();
        assertEquals(12.25, position.getX(), "Movement on x axis should be cumulative");
        assertEquals(8.5, position.getY(), "Movement on y axis should be cumulative");
    }

    private static void testCopyConstructorIsIndependent() {
        Position original = new Position(5, 6);
        Position copy = new Position(original);
        original.right(10);
        original.down(10);
        assertEquals(5, copy.getX(), "Copy constructor should copy x value");
        assertEquals(6, copy.getY(), "Copy constructor should copy y value");
    }

    private static void testUpdateCoordinatesFromPositionCopiesValues() {
        Position source = new Position(30, 40);
        Position target = new Position();
        target.updateCoordinates(source);
        source.left(5);
        source.up(5);
        assertEquals(30, target.getX(), "updateCoordinates(Position) should copy x value");
        assertEquals(40, target.getY(), "updateCoordinates(Position) should copy y value");
    }

    private static void testToStringRoundsCoordinates() {
        Position position = new Position(4.49, 7.5);
        assertEquals("Position (4, 8)", position.toString(), "toString should round coordinates");
    }

    private static void assertEquals(double expected, double actual, String message) {
        if (Double.compare(expected, actual) != 0) {
            throw new AssertionError(message + " - expected: " + expected + ", actual: " + actual);
        }
    }

    private static void assertEquals(String expected, String actual, String message) {
        if (!expected.equals(actual)) {
            throw new AssertionError(message + " - expected: " + expected + ", actual: " + actual);
        }
    }
}
