package thd.gameobjects.movable;

import thd.game.managers.GamePlayManager;
import thd.game.utilities.GameView;
import thd.gameobjects.base.GameObject;

// Diese Klasse muss nicht mit Javadoc kommentiert werden.
public class Jimmy extends GameObject {

    private enum State {RUNNING, JUMPING, HOVERING}

    private static final RunningState[] RUNNING_STATES = RunningState.values();
    private static final JumpingState[] JUMPING_STATES = JumpingState.values();

    public enum RunningState {
        RUNNING_1(JimmyBlockImages.RUNNING_1),
        RUNNING_2(JimmyBlockImages.RUNNING_2),
        RUNNING_3(JimmyBlockImages.RUNNING_3),
        RUNNING_4(JimmyBlockImages.RUNNING_4),
        RUNNING_5(JimmyBlockImages.RUNNING_5);

        private final String display;

        RunningState(String display) {
            this.display = display;
        }
    }

    public enum JumpingState {
        JUMPING_1(JimmyBlockImages.STANDARD, 0),
        JUMPING_2(JimmyBlockImages.JUMPING, 50),
        JUMPING_3(JimmyBlockImages.JUMPING, 30),
        JUMPING_4(JimmyBlockImages.JUMPING, 0),
        JUMPING_5(JimmyBlockImages.JUMPING, 0),
        JUMPING_6(JimmyBlockImages.JUMPING, -30),
        JUMPING_7(JimmyBlockImages.JUMPING, -50),
        JUMPING_8(JimmyBlockImages.STANDARD, 0);

        private final String display;
        private final int up;

        JumpingState(String display, int up) {
            this.display = display;
            this.up = up;
        }
    }

    private State currentState;
    private String blockImage;
    private RunningState runningState;
    private JumpingState jumpingState;

    public Jimmy(GameView gameView, GamePlayManager gamePlayManager) {
        super(gameView, gamePlayManager);
        currentState = State.RUNNING;
        size = 5;
        height = 21 * size;
        width = 15 * size;
        speedInPixel = 5;
        distanceToBackground = 10000;
        resetPosition();
        runningState = RunningState.RUNNING_1;
        jumpingState = JumpingState.JUMPING_1;
    }


    private void resetPosition() {
        position.updateCoordinates(-width, GameView.HEIGHT - height);
    }

    @Override
    public void updateStatus() {
        switch (currentState) {
            case RUNNING -> {
                blockImage = runningState.display;
                if (gameView.timer(80, 0, this)) {
                    switchToNextRunningState();
                }
                position.right(speedInPixel);
            }
            case JUMPING -> {
                blockImage = jumpingState.display;
                if (gameView.timer(80, 0, this)) {
                    switchToNextJumpingState();
                    position.up(jumpingState.up);
                }
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
            resetStates();
        }
    }

    private void switchToNextRunningState() {
        runningState = RUNNING_STATES[(runningState.ordinal() + 1) % RUNNING_STATES.length];
    }

    private void switchToNextJumpingState() {
        jumpingState = JUMPING_STATES[(jumpingState.ordinal() + 1) % JUMPING_STATES.length];
    }

    private void resetStates() {
        runningState = RunningState.RUNNING_1;
        jumpingState = JumpingState.JUMPING_1;
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