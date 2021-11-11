package breakout;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;
import java.awt.Color;
import java.util.ArrayList;


public class Bricks extends GraphicsGroup{

    public static final double BRICK_HEIGHT = BreakoutGame.CANVAS_HEIGHT * .025;
    public static final double BRICK_WIDTH = BreakoutGame.CANVAS_WIDTH * .11;
    ArrayList<Rectangle> blueBricks = new ArrayList<>();


    public Bricks(){
        super();

        int move = 0;
        for (int i = 0; i < 8; i++) {
            Rectangle rect = new Rectangle(20 + move, 500, BRICK_WIDTH, BRICK_HEIGHT);
            rect.setFillColor(Color.BLUE);
            blueBricks.add(rect);
            move += BRICK_WIDTH + BRICK_WIDTH * .1;
        }
        int move2 = 0;
        for (int i = 0; i < 8; i++) {
            Rectangle rect = new Rectangle(20 + move2, 500 - (BRICK_HEIGHT + BRICK_HEIGHT * .18), BRICK_WIDTH, BRICK_HEIGHT);
            rect.setFillColor(Color.BLUE);
            blueBricks.add(rect);
            move2 += BRICK_WIDTH + BRICK_WIDTH * .1;
        }

        for (Rectangle blueBrick : blueBricks){
            super.add(blueBrick);
        }
        
    }

   public void addToCanvas(CanvasWindow canvas) {
       canvas.add(this);
   }

}
