package breakout;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Point;

public class BallManager {

    public String paddleIntersection(Ball ball, Paddle paddle, CanvasWindow canvas){
        double xPos = ball.getCenterX();
        double yPos = ball.getCenterY() + Ball.BALL_RADIUS;
        Point ballBottom = new Point(xPos, yPos + 1);

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
    
    public void brickIntersection(Ball ball, Bricks brick) {

    }


}

