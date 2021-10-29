package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;
import edu.macalester.graphics.events.KeyboardEventHandler;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    public static final int CANVAS_WIDTH = 600;
    public static final int CANVAS_HEIGHT = 800;

    private CanvasWindow canvas;
    private Paddle paddle;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        paddle = new Paddle();
        canvas.add(paddle);

        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.RIGHT_ARROW && canvas.getKeysPressed().size() == 1) {
                paddle.moveRight();
            }
            if (event.getKey() == Key.LEFT_ARROW && canvas.getKeysPressed().size() == 1) {
                paddle.moveLeft();
            }
        });


    }

    public static void main(String[] args){
        new BreakoutGame();
    }
}
