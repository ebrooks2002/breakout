package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */

public class BreakoutGame {
    public static final int CANVAS_WIDTH = 800;
    public static final int CANVAS_HEIGHT = 900;

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
            if (ball.floorHit()) {
                setLives(lives - 1);
                resetBall();
            }
            if (bricks.getBricksList().size() == 0) {
                System.out.println("you win!");
            }
         });
    }

    public static void setLives(int n) {
        lives = n;
    }

    public void resetBall() {
        if (getLives() > 0) {
            ball.removeFromCanvas(canvas);
            ball = new Ball();
            ball.addToCanvas(canvas);
            canvas.pause(300);
            canvas.draw();
        }
        else {
            System.out.println("you lose!");
            System.exit(0);
        }
    }

    public static int getLives(){
        return lives;
    }
    
}
