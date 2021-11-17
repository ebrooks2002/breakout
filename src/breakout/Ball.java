package breakout;
import java.awt.Color;
import java.util.Random;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Ball extends Ellipse {

    public static final Color BALL_COLOR  = Color.WHITE;
    public static final double BALL_RADIUS = Paddle.PADDLE_WIDTH * 0.07;

    private double centerX;
    private double centerY;
    private double xVelocity;
    private double yVelocity;

    private double initialSpeed;
    private double angleInRadians;
    private IntersectionManager intersectionManager = new IntersectionManager();

    public Ball() {
        
        super(0, 0, BALL_RADIUS*2, BALL_RADIUS*2);
        
        centerX = BreakoutGame.CANVAS_WIDTH * 0.5;
        centerY = BreakoutGame.CANVAS_HEIGHT * 0.7;
        initialSpeed = 7;
        
        Random rand = new Random();
        
        angleInRadians = Math.toRadians(rand.nextInt(90) + 225);
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

    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getYVelocity(){
        return yVelocity;
    }

    public double getXVelocity(){
        return xVelocity;
    }

    public void addToCanvas(CanvasWindow canvas) {
        canvas.add(this);
    }

    public void removeFromCanvas(CanvasWindow canvas) {
        canvas.remove(this);
    }

    public void updatePosition(CanvasWindow canvas, Paddle paddle, Bricks bricks) {
        moveBall();

        if (wallHit()) {
            xVelocity = -1 * xVelocity;
            moveBall();
        }
        else if (intersectionManager.paddleIntersection(this, paddle , canvas) == "leftbounce") {
            yVelocity = -1 * yVelocity;
            xVelocity = -1 * (Math.abs(xVelocity));
            moveBall();
        }

        else if (intersectionManager.paddleIntersection(this, paddle, canvas) == "rightbounce") {
            yVelocity = -1 * yVelocity;
            xVelocity = Math.abs(xVelocity);
            moveBall();
        }

        else if (ceilingHit()) {
            yVelocity = -1 * yVelocity;
            moveBall();
        }

        else if (intersectionManager.brickIntersection(this, bricks, canvas) == "topbounce") {
            moveBall();
        }

        else if (intersectionManager.brickIntersection(this, bricks, canvas) == "bottombounce") {
            
            moveBall();
        }
        else if (intersectionManager.brickIntersection(this, bricks, canvas) == "leftbounce") {
            
            moveBall();
        }

        else if (intersectionManager.brickIntersection(this, bricks, canvas) == "rightbounce") {
            
            moveBall();
        }
    }

    public boolean wallHit() {
        if (this.getCenterX() - BALL_RADIUS < 0 || this.getCenterX() + BALL_RADIUS > BreakoutGame.CANVAS_WIDTH){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean ceilingHit() {
        if (this.getCenterY() - BALL_RADIUS < 0) {
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

    public void moveBall() {
        centerX = this.getCenterX() + xVelocity;
        centerY = this.getCenterY() + yVelocity;
        this.setCenter(centerX, centerY);
    }

    public void changeSpeed(double s) {
        this.xVelocity = this.xVelocity * s;
        this.yVelocity = this.yVelocity * s;
        this.initialSpeed = s;
        
    }

    public double getSpeed() {
        return initialSpeed;
    }

    public void resetBall(CanvasWindow canvas) {
        BreakoutGame.setLives(BreakoutGame.getLives() -1);
        canvas.pause(300);
        this.removeFromCanvas(canvas);
        this.addToCanvas(canvas);
        this.setCenter(BreakoutGame.CANVAS_WIDTH * 0.5, BreakoutGame.CANVAS_HEIGHT * 0.7);
        moveBall();
    }
}

