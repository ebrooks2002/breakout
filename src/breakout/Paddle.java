package breakout;
import java.awt.Color;

import edu.macalester.graphics.Rectangle;

public class Paddle extends Rectangle {

    public final static Color PADDLE_COLOR = Color.BLUE; 
    public final static int PADDLE_WIDTH = 80;
    public final static int PADDLE_HEIGHT  = 15;
    public final static int PADDLE_SPEED = 10;
    public final static double Y_VALUE = BreakoutGame.CANVAS_HEIGHT*.88;
    private int xCenter;
   

    public Paddle() {
        super(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        xCenter = BreakoutGame.CANVAS_WIDTH / 2;
        this.setFillColor(PADDLE_COLOR);
        this.setCenter(xCenter, BreakoutGame.CANVAS_HEIGHT*.88);
    }

    public void moveRight() {
        if ((xCenter + PADDLE_WIDTH/2) < BreakoutGame.CANVAS_WIDTH - PADDLE_SPEED) {
            xCenter += PADDLE_SPEED;
            this.setCenter(xCenter, Y_VALUE);
        }
    }

    public void moveLeft() {
        if ((xCenter - PADDLE_WIDTH/2) > PADDLE_SPEED) {
            xCenter -= PADDLE_SPEED;
            this.setCenter(xCenter, Y_VALUE);
        }
    }
}
