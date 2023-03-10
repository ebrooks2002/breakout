// Authour: Ethan Brooks
// Description: Creates a ball extending the ellipse class. It updates the position of the ball, and
// checks for wall/brick/paddle collisions.
package breakout;

import java.awt.Color;
import java.util.Random;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

/**
 * Class that represents a ball that moves around and bounces off other objects.
 */
public class Ball extends Ellipse {

    public static final Color BALL_COLOR = Color.WHITE;
    public static final double BALL_RADIUS = Paddle.PADDLE_WIDTH * 0.07;
    private final double speed = 8;
    private final IntersectionManager intersectionManager = new IntersectionManager();
    private double centerX;
    private double centerY;
    private double xVelocity;
    private double yVelocity;
    private double angleInRadians;
    
    /**
     * Iniializes the ball, and sets up starting position, angle and velocity.
     */
    public Ball() {
        super(0, 0, BALL_RADIUS * 2, BALL_RADIUS * 2);

        centerX = BreakoutGame.CANVAS_WIDTH * 0.5;
        centerY = BreakoutGame.CANVAS_HEIGHT * 0.7;
        

        Random rand = new Random();
        int randNum = rand.nextInt(6);
        int[] startAngles = { 230, 240, 250, 290, 300, 310 };
        angleInRadians = Math.toRadians(startAngles[randNum]);

        this.xVelocity = speed * Math.cos(angleInRadians);
        this.yVelocity = speed * -Math.sin(angleInRadians);

        this.setCenter(centerX, centerY);
        this.setFillColor(BALL_COLOR);
    }

    /**
     * 
     * @param canvas
     * @param paddle
     * @param bricks Updates the position of the ball on the screen, while checking for collisions
     */
    public void updatePosition(CanvasWindow canvas, Paddle paddle, Bricks bricks) {
        moveBall();
        intersectionManager.brickIntersection(this, bricks);
        intersectionManager.paddleIntersection(this, paddle, canvas);
        if (wallHit()) {
            xVelocity = -1 * xVelocity;
            moveBall();
        } else if (ceilingHit()) {
            yVelocity = -1 * yVelocity;
            moveBall();
        }
    }

    /**
     * Moves position of ball according to velocity;
     */
    public void moveBall() {
        centerX = this.getCenterX() + xVelocity;
        centerY = this.getCenterY() + yVelocity;
        this.setCenter(centerX, centerY);
    }

    public boolean ceilingHit() {
        if (this.getCenterY() - BALL_RADIUS < 0) {
            return true;
        }
        return false;
    }

    public boolean floorHit() {
        if (this.getCenterY() > BreakoutGame.CANVAS_HEIGHT) {
            return true;
        }
        return false;
    }

    public boolean wallHit() {
        if (this.getCenterX() - BALL_RADIUS < 0 || this.getCenterX() + BALL_RADIUS > BreakoutGame.CANVAS_WIDTH) {
            return true;
        }
        return false;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getSpeed() {
        return speed;
    }

}

