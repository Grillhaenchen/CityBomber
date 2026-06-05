package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

// Diese Klasse muss nicht mit Javadoc kommentiert werden.
public class Jimmy extends GameObject {

    private enum State {RUNNING, JUMPING, HOVERING}

    private State currentState;
    private String blockImage;

    public Jimmy(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        currentState = State.RUNNING;
        size = 5;
        height = 21 * size;
        width = 15 * size;
        speedInPixel = 5;
        distanceToBackground = 10000;
        resetPosition();
    }

    private void resetPosition() {
        position.updateCoordinates(-width, GameView.HEIGHT - height);
    }

    @Override
    public void updateStatus() {
        switch (currentState) {
            case RUNNING -> {
                blockImage = JimmyBlockImages.RUNNING_1;
                position.right(speedInPixel);
            }
            case JUMPING -> {
                blockImage = JimmyBlockImages.JUMPING;
                position.right(speedInPixel);
            }
            case HOVERING -> {
                blockImage = JimmyBlockImages.STANDARD;
                position.right(speedInPixel);
            }
        }
        if (position.getX() > GameView.WIDTH) {
            resetPosition();
            switchToNextState();
        }
    }

    private void switchToNextState() {
        int nextState = (currentState.ordinal() + 1) % State.values().length;
        currentState = State.values()[nextState];
    }

    @Override
    public void addToCanvas() {
        gameView.addBlockImageToCanvas(blockImage, position.getX(), position.getY(), size, rotation);
    }
}