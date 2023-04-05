// Oracle OpenJDK version 18.0.1.2

import java.awt.*;

/**
 * Subclass triangle, extends figure
 */
public class Triangle extends Figure{
    // Color of the triangle
    private static Color color = Color.BLUE;
    private static Color edgeColor = Color.BLACK;

    // Dimensions of the triangle
    private int width;
    private int height;

    // Position of the triangle
    private int x;
    private int y;
    private int[] xPoints;
    private int[] yPoints;

    /**
     * Constructor, sets values of the triangle
     * @param x X-position of the triangle
     * @param y Y-position of the triangle
     * @param width Width of the triangle
     * @param height Height of the triangle
     */
    public Triangle(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xPoints = calcXPoints();
        this.yPoints = calcYPoints();
    }

    /**
     * Method to calculate the coordinates of the corners of the triangle
     */
    private int[] calcXPoints(){ return new int[]{x, x+width/2, x-width/2}; }
    private int[] calcYPoints(){ return new int[]{y, y+height, y+height}; }

    /**
     * Methods described in the superclass (abstract)
     */
    public void setX(int x){
        this.x = x;
        this.xPoints = calcXPoints();
    }
    public void setY(int y){
        this.y = y;
        this.yPoints = calcYPoints();
    }
    public int getX(){ return x; }
    public int getY(){ return y; }

    public void paintFigure(Graphics g){
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(edgeColor);
        g.drawPolygon(xPoints, yPoints, 3);
    }

    public boolean contains(int mouseX, int mouseY) {
        return -(mouseY-y) <= 2*(mouseX-x) && 2*(mouseX-x) <= mouseY-y && mouseY-y <= height;
    }
}