package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class BallManager {

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

        if (canvas.getElementAt(ballTop) == bricks){
            return "topbounce";
        }
        return "false";
    }


}

