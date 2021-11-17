// Author: Ethan Brooks
// Class Description: Creates a group of bricks using the GraphicsGroup class. Creates 8 rows of
// different colored Bricks in the graphics group.
package breakout;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing the Bricks.
 */
public class Bricks extends GraphicsGroup {

    public static final double BRICK_HEIGHT = BreakoutGame.CANVAS_HEIGHT * .045;
    public static final double BRICK_WIDTH = BreakoutGame.CANVAS_WIDTH * .112;
    private ArrayList<Rectangle> bricksList = new ArrayList<Rectangle>();
    private final List<Color> colorList = new ArrayList<Color>(
        Arrays.asList(Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK));

    /**
     * creates a graphics group and adds the bricks.
     */
    public Bricks() {
        super();
        addBricks();
    }

    /**
     * Creates a new row of bricks and adds them to graphicsGroup, according to the give color and y
     * position.
     * @param color
     * @param yPos
     */
    public void addRow(Color color, double yPos) {
        int moveby = 0;
        for (int i = 0; i < 8; i++) {
            Rectangle rect = new Rectangle(BreakoutGame.CANVAS_WIDTH * .029 + moveby, yPos, BRICK_WIDTH, BRICK_HEIGHT);
            rect.setFillColor(color);
            super.add(rect);
            bricksList.add(rect);
            moveby += BRICK_WIDTH + (BRICK_WIDTH * .07);
        }
    }

    /**
     * Adds all the rows,
     */
    public void addBricks() {
        double yPos = BreakoutGame.CANVAS_HEIGHT * .5;
        for (Color color : colorList) {
            addRow(color, yPos);
            yPos -= BRICK_HEIGHT + BRICK_HEIGHT * .1;
            addRow(color, yPos);
            yPos -= BRICK_HEIGHT + BRICK_HEIGHT * .1;
        }
    }

    public ArrayList<Rectangle> getBricksList() {
        return bricksList;
    }

}
