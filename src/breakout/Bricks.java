package breakout;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bricks extends GraphicsGroup {

    public static final double BRICK_HEIGHT = BreakoutGame.CANVAS_HEIGHT * .045;
    public static final double BRICK_WIDTH = BreakoutGame.CANVAS_WIDTH * .112;
    private ArrayList<Rectangle> bricksList = new ArrayList<Rectangle>();
    private final List<Color> colorList = new ArrayList<Color>(
        Arrays.asList(Color.BLUE, Color.GREEN, Color.YELLOW, Color.PINK));

    public Bricks() {
        super();
        addBricks();
    }

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
