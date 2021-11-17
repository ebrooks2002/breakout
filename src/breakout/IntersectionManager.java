package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class IntersectionManager {

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

    public void brickIntersection(Ball ball, Bricks bricks, CanvasWindow canvas) {

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
                ;
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

