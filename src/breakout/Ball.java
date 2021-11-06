package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball extends Ellipse {

    public static final Color BALL_COLOR  = Color.WHITE;
    public static final double BALL_RADIUS = 10;

    private double centerX;
    private double centerY;
    private double xVelocity;
    private double yVelocity;

    private double initialSpeed;
    private double angleInRadians;

    public Ball() {
        
        super(0, 0, BALL_RADIUS*2, BALL_RADIUS*2);
        
        centerX = BreakoutGame.CANVAS_WIDTH * 0.5;
        centerY = BreakoutGame.CANVAS_HEIGHT * 0.7;
        initialSpeed = 5;
        
        angleInRadians = Math.toRadians(45);
        this.xVelocity = initialSpeed * Math.cos(angleInRadians);
        this.yVelocity = initialSpeed * -Math.sin(angleInRadians);

        this.setCenter(centerX, centerY);
        this.setFillColor(BALL_COLOR);
        
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(this);
    }

    public void updatePosition() {
        
        if (this.ballInBounds()) {
            centerX = this.getCenterX() + (xVelocity);
            centerY = this.getCenterY() - (yVelocity);
            this.setCenter(centerX, centerY);
        }
        else {
            this.bounce();
        }
    }

    public boolean ballInBounds() {
        boolean inXBounds = (centerX < BreakoutGame.CANVAS_WIDTH) && (centerX > 0);
        boolean inYBounds = (centerY < BreakoutGame.CANVAS_HEIGHT && centerY > 0);
        if (inXBounds && inYBounds) {
            return true;
        }
        else {
            return false;
        }
    }

    public void bounce() {

    if (this.getCenterY() > 0) {
        if (this.yVelocity > 0) {
            this.angleInRadians = -1 * angleInRadians;
            this.xVelocity = -1 * xVelocity;
            centerX = this.getCenterX() + xVelocity;
            centerY = this.getCenterY() + yVelocity;
        }   
        else {
            this.yVelocity = -1 * yVelocity;
            this.xVelocity = -1 * xVelocity;
            centerX = this.getCenterX() + (xVelocity);
            centerY = this.getCenterY() - (yVelocity);
            
        }
    }
    else {
        
        this.angleInRadians = -1 * angleInRadians;
        this.yVelocity =  -1 * yVelocity;
        centerX = this.getCenterX() + xVelocity;
        centerY = this.getCenterY() + yVelocity;
        
    }
    }
}

