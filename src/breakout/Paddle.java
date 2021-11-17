package breakout;
import java.awt.Color;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Paddle extends Rectangle {

    public final static Color PADDLE_COLOR = Color.WHITE; 
    public final static double PADDLE_WIDTH = BreakoutGame.CANVAS_WIDTH  * 0.18;
    public final static double PADDLE_HEIGHT  = BreakoutGame.CANVAS_HEIGHT * 0.015;
    public final static double Y_VALUE = BreakoutGame.CANVAS_HEIGHT*.88;
    private double xCenter;
   
    public Paddle() {
        super(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        xCenter = BreakoutGame.CANVAS_WIDTH / 2;
        this.setFillColor(PADDLE_COLOR);
        this.setCenter(xCenter, Y_VALUE);
    }

    public void move(Point point) {
        xCenter = point.getX();
        if ((xCenter < BreakoutGame.CANVAS_WIDTH - this.getWidth()/2) && (xCenter > this.getWidth()/2)) {
            this.setCenter(xCenter, Y_VALUE);
        }
    }

}
