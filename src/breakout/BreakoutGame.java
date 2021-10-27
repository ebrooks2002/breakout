package breakout;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;

    private static CanvasWindow canvas;

    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(Color.BLACK);
        canvas.add(new Paddle());

    }

    public static void main(String[] args){
        new BreakoutGame();
    }
}
