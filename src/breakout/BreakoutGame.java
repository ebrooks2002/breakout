package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 1100;

    private CanvasWindow canvas;
    private Paddle paddle;
    private Ball ball;
    private Bricks bricks;
    private static int lives = 3;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        paddle = new Paddle();
        ball = new Ball();
        bricks = new Bricks();
        ball.addToCanvas(canvas);
        paddle.addToCanvas(canvas);
        bricks.addToCanvas(canvas);
    }
    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public void run() {
        canvas.onMouseMove((mouse) -> paddle.move(mouse.getPosition()));
        canvas.animate(() -> {
            ball.updatePosition(canvas, paddle, bricks);
         });
    }

    public static void setLives(int n) {
        lives = n;
    }

    public static int getLives(){
        return lives;
    }
    
}
