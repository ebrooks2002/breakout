package breakout;


import java.awt.Color;
import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class IntersectionManager {

    public void paddleIntersection(Ball ball, Paddle paddle, CanvasWindow canvas){
        
        Point ballBottom = new Point(ball.getCenterX(), ball.getCenterY() + Ball.BALL_RADIUS + 1);

        if (canvas.getElementAt(ballBottom) == paddle) {
            
            if (ball.getCenterX() < paddle.getX() + paddle.getWidth()/2) {
                ball.setYVelocity(ball.getYVelocity() * -1);
                ball.setXVelocity(Math.abs(ball.getXVelocity()) * -1);
                return;
            }
            if (ball.getCenterX() > paddle.getX() + paddle.getWidth()/2) {
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
        
        for (Rectangle brick : bricks.getBricksList()){

            if (bricks.getElementAt(ballTop) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                increaseBallSpeed(brick, ball);
                return;
            }

            if (bricks.getElementAt(ballBottom) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                increaseBallSpeed(brick, ball);
                return;
            }

            else if (bricks.getElementAt(ballLeft) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);;
                increaseBallSpeed(brick, ball);
                return;
            }

            else if (bricks.getElementAt(ballRight) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                increaseBallSpeed(brick, ball);
                return;
            }
        }
        
    }

    public void increaseBallSpeed(Rectangle brick, Ball ball)  {

        if (brick.getFillColor() == Color.GREEN && ball.getSpeed() < 1.2) {
            ball.changeSpeed(1.2);
        }
        if ((brick.getFillColor() == Color.YELLOW) && (ball.getSpeed() < 1.3)) {
            ball.changeSpeed(1.3);
        }
        if (brick.getFillColor() == Color.PINK && (ball.getSpeed() < 1.4)) {
            ball.changeSpeed(1.4);
        }
        
    }
}

