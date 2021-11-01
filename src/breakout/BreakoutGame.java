package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;


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
        canvas.onMouseMove((mouse) -> paddle.move(mouse.getPosition()));
        
    }
    public static void main(String[] args){
        new BreakoutGame();
    }
}
