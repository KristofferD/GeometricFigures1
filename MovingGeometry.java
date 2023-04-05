// Oracle OpenJDK version 18.0.1.2

import javax.swing.*;

/**
 * Class to initiate the program. Contains the main() method.
 */
public class MovingGeometry {
    /**
     * Main method to initiate the program
     * @param args unused
     */
    public static void main(String[] args) {
        initializeGUI();
    }

    /**
     * Method to initialize the graphics
     */
    private static void initializeGUI() {
        // Window side size
        int s = 500;

        // Create new graphics window and add a GeoPanel object
        JFrame f = new JFrame("Moving Geometry");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new GeoPanel(s));
        f.setSize(s,s);
        f.setVisible(true);
    }
}
