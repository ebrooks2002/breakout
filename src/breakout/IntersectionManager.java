// Author: Ethan Brooks
// Class Description: Checks if the ball has collided with either a brick or the paddle, and then changes the velocity of the ball accordingly.
package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;
/**
Class that checks for intersections.
 */
public class IntersectionManager {

    /**
     * Checks if the bottom of ball has collided with the paddle, and if so, reverses y velocity.
     * @param ball
     * @param paddle
     * @param canvas
     */
    public void paddleIntersection(Ball ball, Paddle paddle, CanvasWindow canvas) {

        Point ballBottom = new Point(ball.getCenterX(), ball.getCenterY() + Ball.BALL_RADIUS + 1);

        if (canvas.getElementAt(ballBottom) == paddle) {

            if (ball.getCenterX() < paddle.getX() + paddle.getWidth() / 2) {
                ball.setYVelocity(ball.getYVelocity() * -1);
                ball.setXVelocity(Math.abs(ball.getXVelocity()) * -1);
                return;
            }
            if (ball.getCenterX() > paddle.getX() + paddle.getWidth() / 2) {
                ball.setYVelocity(ball.getYVelocity() * -1);
                ball.setXVelocity(Math.abs(ball.getXVelocity()));
                return;
            }
        }
    }
    /**
     * Checks if ball has collided with a brick, and if so, changes velocity accordingly.
     * @param ball
     * @param bricks
     */
    public void brickIntersection(Ball ball, Bricks bricks) {

        Point ballBottom = new Point(ball.getCenterX(), ball.getCenterY() + Ball.BALL_RADIUS + 1);
        Point ballLeft = new Point(ball.getCenterX() - Ball.BALL_RADIUS - 1, ball.getCenterY());
        Point ballTop = new Point(ball.getCenterX(), ball.getCenterY() - Ball.BALL_RADIUS - 1);
        Point ballRight = new Point(ball.getCenterX() + Ball.BALL_RADIUS + 1, ball.getCenterY());

        for (Rectangle brick : bricks.getBricksList()) {

            if (bricks.getElementAt(ballTop) == brick) {
                removeBricks(bricks, brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                return;
            }

            else if (bricks.getElementAt(ballBottom) == brick) {
                removeBricks(bricks, brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                return;
            }

            else if (bricks.getElementAt(ballLeft) == brick) {
                removeBricks(bricks, brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                return;
            }

            else if (bricks.getElementAt(ballRight) == brick) {
                removeBricks(bricks, brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                return;
            }
        }
    }

    public void removeBricks(Bricks bricks, Rectangle brick) {
        bricks.remove(brick);
        bricks.getBricksList().remove(brick);
    }

}

