package breakout;
import java.awt.Color;
import edu.macalester.graphics.Rectangle;

public class Paddle extends Rectangle {

    private final static Color PADDLE_COLOR = Color.BLUE; 
    private final static int PADDLE_WIDTH = 80;
    private final static int PADDLE_HEIGHT  = 15;

    public Paddle(){
        super(0, 0, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.setFillColor(PADDLE_COLOR);
        this.setCenter(300, 720);
    }

    public void updatePosition(){

    }

}
