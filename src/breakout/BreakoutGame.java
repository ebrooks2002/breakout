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
    private Ball ball;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
    }
    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public void run() {
        paddle = new Paddle();
        ball = new Ball();
        ball.addToCanvas(canvas);
        paddle.addToCanvas(canvas);
        canvas.onClick((mouse) -> ball.updatePosition());
        canvas.onMouseMove((mouse) -> paddle.move(mouse.getPosition()));
    }
}
