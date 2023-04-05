// Oracle OpenJDK version 18.0.1.2

import java.awt.*;

/**
 * Subclass square, extends figure
 */
public class Square extends Figure{
    // Color of the square
    private static Color color = Color.YELLOW;
    private static Color edgeColor = Color.BLACK;

    // Position of the square
    private int x;
    private int y;

    // Dimensions of the square
    private int width;
    private int height;

    /**
     * Constructor, sets values of the square
     * @param x X-position of the square
     * @param y Y-position of the square
     * @param width Width of the square
     * @param height Height of the square
     */
    public Square(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Methods described in the superclass (abstract)
     */
    public void setX(int x){
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }

    public void paintFigure(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(edgeColor);
        g.drawRect(x,y,width,height);
    }

    public boolean contains(int mouseX, int mouseY) {
        return x <= mouseX && y <= mouseY
                && mouseX <= x+height && mouseY <= y+height;
    }
}