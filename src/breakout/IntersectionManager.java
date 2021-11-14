package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class IntersectionManager {

    public String paddleIntersection(Ball ball, Paddle paddle, CanvasWindow canvas){
        double xPos = ball.getCenterX();
        double yPos = ball.getCenterY();
        Point ballBottom = new Point(xPos, yPos + Ball.BALL_RADIUS + 1);

        if (canvas.getElementAt(ballBottom) == paddle) {
            if (xPos < paddle.getX() + paddle.getWidth()/2) {
                return "leftbounce";
            }
            if (xPos > paddle.getX() + paddle.getWidth()/2) {
                return "rightbounce";
            }
        }
        return "false";
    }
    
    public String brickIntersection(Ball ball, Bricks bricks, CanvasWindow canvas) {
        double xPos = ball.getCenterX();
        double yPos = ball.getCenterY();
        Point ballBottom = new Point(xPos, yPos + Ball.BALL_RADIUS + 1);
        Point ballLeft = new Point(xPos - Ball.BALL_RADIUS - 1, yPos);
        Point ballTop = new Point(xPos, yPos - Ball.BALL_RADIUS - 1);
        Point ballRight = new Point(xPos + Ball.BALL_RADIUS + 1, yPos);

        for (Rectangle brick : bricks.getBricksList()){

            if (bricks.getElementAt(ballTop) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                checkBrickColor(brick, ball);
                return "topbounce";
            }

            else if (bricks.getElementAt(ballBottom) == brick) {
                System.out.println("ya");
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setYVelocity(ball.getYVelocity() * -1);
                checkBrickColor(brick, ball);
                return "bottombounce";
            }

            else if (bricks.getElementAt(ballLeft) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                checkBrickColor(brick, ball);
                return "leftbounce";
            }

            else if (bricks.getElementAt(ballRight) == brick) {
                bricks.remove(brick);
                bricks.getBricksList().remove(brick);
                ball.setXVelocity(ball.getXVelocity() * -1);
                checkBrickColor(brick, ball);
                return "rightbounce";
            }
        }
        return "false";
    }

    public void checkBrickColor(Rectangle brick, Ball ball) {

        if (brick.getFillColor() == Color.BLUE) {
            ball.increaseSpeed();
        }
        if (brick.getFillColor() == Color.GREEN) {
            ball.increaseSpeed();
        }
        if (brick.getFillColor() == Color.YELLOW) {
            ball.increaseSpeed();
        }
        if (brick.getFillColor() == Color.ORANGE) {
            ball.increaseSpeed();
        }
        if (brick.getFillColor() == Color.RED) {
            ball.increaseSpeed();
        }
    }
}

