package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;

/**
 * The game of Breakout.
 */

public class BreakoutGame {
    public static final int CANVAS_WIDTH = 900;
    public static final int CANVAS_HEIGHT = 900;

    private CanvasWindow canvas;
    private Paddle paddle;
    private Ball ball;
    private Bricks bricks;
    private GraphicsText youWin; 
    private GraphicsText youLose; 
    private static GraphicsText livesLeft;
    private static int lives = 3;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        paddle = new Paddle();
        ball = new Ball();
        bricks = new Bricks();
        livesLeft = new GraphicsText("You have " + getLives() + " lives left!");
        youWin = new GraphicsText("You Win!");
        youLose = new GraphicsText("You Lose!");
        configureText();
        canvas.add(livesLeft);
        ball.addToCanvas(canvas);
        paddle.addToCanvas(canvas);
        bricks.addToCanvas(canvas);
    }
    public static void main(String[] args){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }

    public void configureText() {

        youWin.setFont(FontStyle.BOLD, 34);
        youWin.setFillColor(Color.WHITE);
        youLose.setFont(FontStyle.BOLD, 34);
        youLose.setFillColor(Color.WHITE);
        youWin.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        youLose.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
        livesLeft.setFont(FontStyle.PLAIN, 12);
        livesLeft.setCenter(CANVAS_WIDTH * .1, CANVAS_HEIGHT * .025);
        livesLeft.setFillColor(Color.WHITE);
    }

    public void run() {

        canvas.onMouseMove((mouse) -> paddle.move(mouse.getPosition()));
        
        canvas.animate(() -> {
            if (getLives() > 0 && bricks.getBricksList().size() > 0) {
                ball.updatePosition(canvas, paddle, bricks);
                if (ball.floorHit()) {
                    setLives(lives - 1);
                    resetBall();
                    
                }
                if (bricks.getBricksList().size() == 0) {
                    canvas.removeAll();
                    canvas.add(youWin);
                }
            }
         });
    }

    public static void setLives(int n) {
        lives = n;
        livesLeft.setText("You have " + getLives() + " lives left");
        System.out.println(lives);
       
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
            canvas.removeAll();
            canvas.add(youLose);
        }
    }

    public static int getLives(){
        return lives;
    }

}
