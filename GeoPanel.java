// Oracle OpenJDK version 18.0.1.2

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Class GeoPanel, subclass of the superclass JPanel. Handles the logic of the panel.
 * Implements the interfaces MouseListener and MouseMotionListener.
 */
public class GeoPanel extends JPanel implements MouseListener, MouseMotionListener {
    // Standard height of figures
    private static int h;

    // Arraylist containing the figures
    private ArrayList<Figure> figures = new ArrayList<>();

    // Boolean to keep track of whether a figure is selected
    private boolean selectedFigure = false;

    // Instance variables to keep track of off-sets when dragging a figure
    private int xOffSet;
    private int yOffSet;

    /**
     * Constructor, sets color of the window and adds the figures to the arraylist figures.
     * @param s size of the window.
     */
    public GeoPanel (int s) {
        h = s/5;

        setBackground( Color.WHITE );
        setForeground( Color.BLACK );

        addMouseListener(this);
        addMouseMotionListener(this);

        figures.add(new Square(s/4-h/2, s/2+h/2, h, h));
        figures.add(new Triangle(2*s/4, s/2+h/2, h, h));
        figures.add(new Circle(3*s/4-h/2, s/2+h/2, h, h));
    }

    /**
     * Method to paint the figures in the window
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        // Paint the figures in order of the arraylist
        for (Figure figure : figures) {
            figure.paintFigure(g);
        }
    }

    /**
     * Methods not used, but defined by the interfaces MouseListener and MouseMotionListener
     * to handle different mouse events.
     * @param e the event to be processed
     */
    public void mouseClicked (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited (MouseEvent e) {}
    public void mouseMoved (MouseEvent e) {}

    /**
     * Method to control what happens when the mouse button is pressed.
     * If the mouse is on a figure, select that figure by moving it to
     * the end of the arraylist figures.
     * @param e the event to be processed
     */
    public void mousePressed (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (figures.get(2).contains(x,y)) {
            selectFigure(2);
        }
        else if (figures.get(1).contains(x, y)) {
            selectFigure(1);
        }
        else if (figures.get(0).contains(x,y)) {
            selectFigure(0);
        }

        if (selectedFigure) {
            xOffSet = x - figures.get(figures.size()-1).getX();
            yOffSet = y - figures.get(figures.size()-1).getY();
        }
    }

    /**
     * Method to control what happens when the mouse is dragged.
     * @param e the event to be processed
     */
    public void mouseDragged (MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (selectedFigure) {
            figures.get(figures.size()-1).setX(x - xOffSet);
            figures.get(figures.size()-1).setY(y - yOffSet);
        }
        repaint();
    }

    /**
     * Method to control what happens when the mouse button is released.
     * @param e the event to be processed
     */
    public void mouseReleased (MouseEvent e) {
        selectedFigure = false;
    }

    /**
     * Method to 'select' a figure. Moves the selected figure to the
     * last index of the arraylist and indicates a figure is selected
     * by setting selectedFigure to true.
     * @param index index of the figure to be selected
     */
    private void selectFigure(int index) {
        figures.add(figures.get(index));
        figures.remove(figures.get(index));
        selectedFigure = true;
    }
}
