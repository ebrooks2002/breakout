package breakout;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bricks extends GraphicsGroup{

    public static final double BRICK_HEIGHT = BreakoutGame.CANVAS_HEIGHT * .03;
    public static final double BRICK_WIDTH = BreakoutGame.CANVAS_WIDTH * .11;
    private ArrayList<Rectangle> bricksList = new ArrayList<Rectangle>();
    private final List<Color> colorList = new ArrayList<Color>(Arrays.asList(Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED));

    public Bricks() {
        super();
        double yPos = 500;
        // for (Color color : colorList) {
        //     addRow(color, yPos);
        //     yPos -= BRICK_HEIGHT + 10;
        //     addRow(color, yPos);
        //     yPos -= BRICK_HEIGHT + 10;
        // }
        addRow(Color.BLUE, yPos);
    }
        
   public void addToCanvas(CanvasWindow canvas) {
       canvas.add(this);
   }

   public ArrayList<Rectangle> getBricksList(){
       return bricksList;
   }

   public void addRow(Color color, double yPos) {
        int moveby = 0;
        for (int i = 0; i < 8; i++) {
            Rectangle rect = new Rectangle(20 + moveby, yPos, BRICK_WIDTH, BRICK_HEIGHT);
            rect.setFillColor(color);
            super.add(rect);
            bricksList.add(rect);
            moveby += BRICK_WIDTH + (BRICK_WIDTH * .1);
        }
    }
}
