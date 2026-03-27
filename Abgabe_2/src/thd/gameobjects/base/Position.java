package thd.gameobjects.base;

public class Position {
    private double x;
    private double y;

    public Position() {
        this(0, 0);
    }

    public Position(Position other) {
        this(other.x, other.y);
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void left() {
        x--;
    }

    public void left(double pixel) {
        x -= pixel;
    }

    public void right() {
        x++;
    }

    public void right(double pixel) {
        x += pixel;
    }

    public void up() {
        y--;
    }

    public void up(double pixel) {
        y -= pixel;
    }

    public void down() {
        y++;
    }

    public void down(double pixel) {
        y += pixel;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void updateCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void updateCoordinates(Position other) {
        this.x = other.getX();
        this.y = other.getY();
    }

    @Override
    public String toString() {
        return "Position (" + (int) Math.round(x) + ", " + (int) Math.round(y) + ")";
    }
}

