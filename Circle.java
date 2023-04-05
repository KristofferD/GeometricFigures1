// Oracle OpenJDK version 18.0.1.2

import java.awt.*;

/**
 * Subclass circle, extends figure
 */
public class Circle extends Figure{
    // Color of the circle
    private static Color color = Color.RED;
    private static Color edgeColor = Color.BLACK;

    // Position of the circle
    private int x;
    private int y;

    // Dimensions of the circle
    private int width;
    private int height;

    /**
     * Constructor, sets values of the circle
     * @param x X-position of the circle
     * @param y Y-position of the circle
     * @param width Width of the circle
     * @param height Height of the circle
     */
    public Circle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Methods described in the superclass (abstract)
     */
    public void setX(int x){ this.x = x; }
    public int getX(){ return x; }
    public void setY(int y){ this.y = y; }
    public int getY(){ return y; }

    public void paintFigure(Graphics g){
        g.setColor(color);
        g.fillOval(x,y,width,height);
        g.setColor(edgeColor);
        g.drawOval(x,y,width,height);
    }

    public boolean contains(int mouseX, int mouseY) {
        return (x+height/2-mouseX)*(x+height/2-mouseX)+
                (y+height/2-mouseY)*(y+height/2-mouseY) <= (height/2)*(height/2);
    }
}