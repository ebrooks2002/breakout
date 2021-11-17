// Author: Ethan Brooks
// Class Description: Represents the paddle object used in the BreakoutGame; it's positioned
// according to mouse position.
package breakout;

import java.awt.Color;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

/**
 * Class that represents the paddle.
 */
public class Paddle extends Rectangle {

    public final static Color PADDLE_COLOR = Color.WHITE;
    public final static double PADDLE_WIDTH = BreakoutGame.CANVAS_WIDTH * 0.18;
    public final static double PADDLE_HEIGHT = BreakoutGame.CANVAS_HEIGHT * 0.015;
    public final static double Y_VALUE = BreakoutGame.CANVAS_HEIGHT * .88;
    private double xCenter;

    /**
     * Initializes the paddle and positions it.
     */
    public Paddle() {
        super(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        xCenter = BreakoutGame.CANVAS_WIDTH / 2;
        this.setFillColor(PADDLE_COLOR);
        this.setCenter(xCenter, Y_VALUE);
    }

    /**
     * Moves the paddle according to mouse position (which is the input).
     * @param point
     */
    public void move(Point point) {
        xCenter = point.getX();
        if ((xCenter < BreakoutGame.CANVAS_WIDTH - this.getWidth() / 2) && (xCenter > this.getWidth() / 2)) {
            this.setCenter(xCenter, Y_VALUE);
        }
    }

}
