// Oracle OpenJDK version 18.0.1.2

import java.awt.*;

/**
 * Abstract superclass Figure, subclassed into triangle, circle and square.
 */
public abstract class Figure{
    /**
     * Abstract get and set methods for the x and y values of the figures.
     */
    abstract public void setX(int xPos);
    abstract public int getX();
    abstract public void setY(int yPos);
    abstract public int getY();

    /**
     * Abstract method to paint the figure
     * @param g Graphics g
     */
    abstract public void paintFigure(Graphics g);

    /**
     * Abstract method to check whether the mouse is inside the boundaries of a figure.
     * @param mouseX X-position of the mouse.
     * @param mouseY Y-position of the mouse.
     * @return True or false if the mouse is inside the boundaries of a figure or not.
     */
    abstract public boolean contains(int mouseX, int mouseY);

}