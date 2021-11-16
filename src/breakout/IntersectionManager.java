package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class IntersectionManager {

    public String paddleIntersection(Ball ball, Paddle paddle, CanvasWindow canvas){
        
        Point ballBottom = new Point(ball.getCenterX(), ball.getCenterY() + Ball.BALL_RADIUS + 1);

        if (canvas.getElementAt(ballBottom) == paddle) {
            
            if (ball.getCenterX() < paddle.getX() + paddle.getWidth()/2) {
                return "leftbounce";
            }
            if (ball.getCenterX() > paddle.getX() + paddle.getWidth()/2) {
                return "rightbounce";
            }
        }
        return "false";
    }
    
    public String brickIntersection(Ball ball, Bricks bricks, CanvasWindow canvas) {

        Point ballBottom = new Point(ball.getCenterX(), ball.getCenterY() + Ball.BALL_RADIUS + 1);
        Point ballLeft = new Point(ball.getCenterX() - Ball.BALL_RADIUS - 1, ball.getCenterY());
        Point ballTop = new Point(ball.getCenterX(), ball.getCenterY() - Ball.BALL_RADIUS - 1);
        Point ballRight = new Point(ball.getCenterX() + Ball.BALL_RADIUS + 1, ball.getCenterY());
        
        for (Rectangle brick : bricks.getBricksList()){

            if (bricks.getElementAt(ballTop) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                return "topbounce";
            }

            if (bricks.getElementAt(ballBottom) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                return "bottombounce";
            }

            else if (bricks.getElementAt(ballLeft) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);;
                return "leftbounce";
            }

            else if (bricks.getElementAt(ballRight) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                return "rightbounce";
            }
        }
        return "false";
    }

    // public void checkBrickColor(Rectangle brick, Ball ball)  {

    //     if (brick.getFillColor() == Color.GREEN) {
    //         ball.changeSpeed(5.5);
    //     }
    //     if (brick.getFillColor() == Color.YELLOW) {
    //         ball.changeSpeed(6);
    //     }
    //     if (brick.getFillColor() == Color.ORANGE) {
    //         ball.changeSpeed(6.5);
    //     }
    //     if (brick.getFillColor() == Color.RED) {
    //         ball.changeSpeed(7);
    //     }
    // }
}

