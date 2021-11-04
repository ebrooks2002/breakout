package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball extends Ellipse {

    public static final Color BALL_COLOR  = Color.WHITE;
    public static final double BALL_RADIUS = 10;

    private double ball_center_x;
    private double ball_center_y;
    private double ball_x_velocity;
    private double ball_y_velocity;
    private double initialSpeed;

    public Ball() {
        
        super(0, 0, BALL_RADIUS*2, BALL_RADIUS*2);
        
        ball_center_x = BreakoutGame.CANVAS_WIDTH * 0.5;
        ball_center_y = BreakoutGame.CANVAS_HEIGHT * 0.7;
        
        double initialAngleInRadians = Math.toRadians(180);
        this.ball_x_velocity = initialSpeed * Math.cos(initialAngleInRadians);
        this.ball_y_velocity = initialSpeed * -Math.sin(initialAngleInRadians);

        this.setCenter(ball_center_x, ball_center_y);
        this.setFillColor(BALL_COLOR);
        
    }

    public double getCenterX() {
        return ball_center_x;
    }

    public double getCenterY() {
        return ball_center_y;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(this);
    }

    public void updatePosition() {
        
        if (this.ballInBounds()){
            
            ball_center_x = this.getCenterX() + (ball_x_velocity);
            ball_center_y = this.getCenterY() - (ball_y_velocity);
            System.out.println("hi");
            this.setCenter(ball_center_x, ball_center_y);
        }
    }

    public boolean ballInBounds(){
        boolean inXBounds = (ball_center_x < BreakoutGame.CANVAS_WIDTH) && (ball_center_x > 0);
        boolean inYBounds = (ball_center_y < BreakoutGame.CANVAS_HEIGHT && ball_center_y > 0);
        if (inXBounds && inYBounds) {
            return true;
        }
        else {
            return false;
        }
    }

    
}

