package breakout;
import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball extends Ellipse {

    public static final Color BALL_COLOR  = Color.WHITE;
    public static final double BALL_RADIUS = Paddle.PADDLE_WIDTH * 0.075;

    private double centerX;
    private double centerY;
    private double xVelocity;
    private double yVelocity;

    private double initialSpeed;
    private double angleInRadians;
    private BallManager ballManager = new BallManager();

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

    public void updatePosition(CanvasWindow canvas, Paddle paddle) {
        centerX = this.getCenterX() + xVelocity;
        centerY = this.getCenterY() + yVelocity;
        setCenter(centerX, centerY);
        System.out.println(this.getX());
        System.out.println(this.getY());
        if (wallHit()) {
            xVelocity = -1 * xVelocity;
            centerX = this.getCenterX() + xVelocity;
            centerY = this.getCenterY() + yVelocity;
            setCenter(centerX, centerY);
        }
        else if (ballManager.paddleIntersection(this, paddle , canvas) == "leftbounce") {
            yVelocity = -1 * yVelocity;
            xVelocity = -1 * (Math.abs(xVelocity));
            centerX = this.getCenterX() + xVelocity;
            centerY = this.getCenterY() + yVelocity;
            setCenter(centerX, centerY);
        }

        else if (ballManager.paddleIntersection(this, paddle, canvas) == "rightbounce") {
            yVelocity = -1 * yVelocity;
            xVelocity = Math.abs(xVelocity);
            centerX = this.getCenterX() + xVelocity;
            centerY = this.getCenterY() + yVelocity;
            setCenter(centerX, centerY);
        }

        else if (ceilingHit()) {
            yVelocity = -1 * yVelocity;
            centerX = this.getCenterX() + xVelocity;
            centerY = this.getCenterY() + yVelocity;
            setCenter(centerX, centerY);
        }
        else if (floorHit()) {
            BreakoutGame.setLives(BreakoutGame.getLives() -1);
            this.setCenter(BreakoutGame.CANVAS_WIDTH * 0.5, BreakoutGame.CANVAS_HEIGHT * 0.7);
        }
    }

    public boolean wallHit() {
        if (this.getCenterX() < 0 || this.getCenterX() > BreakoutGame.CANVAS_WIDTH){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean ceilingHit() {
        if (this.getCenterY() < 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean floorHit() {
        if (this.getCenterY() > BreakoutGame.CANVAS_HEIGHT) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean paddleHit() { 
        return true;
    }

}

