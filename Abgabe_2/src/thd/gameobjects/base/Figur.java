package thd.gameobjects.base;

import thd.game.utilities.GameView;

public abstract class Figur {
    protected GameView gameView;
    protected Position position;

    protected double speedInPixel;
    protected double size;
    protected double rotation;

    public abstract void updatePosition();

    public abstract void addToCanvas();
}
