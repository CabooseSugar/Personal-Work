package flag_panel_generator;

import javax.swing.*;
import java.awt.*;

public class Flag extends JFrame {
    public Flag() throws HeadlessException {

        setSize(900, 500);
        setTitle("Flag program");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Flag
        JPanel colorsPanel = new JPanel();
        add(colorsPanel, BorderLayout.CENTER); // "add" to JFrame being extended

        // Colors
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        colorsPanel.add(bluePanel);
        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.white);
        colorsPanel.add(whitePanel);
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        colorsPanel.add(redPanel);

        //Buttons
        JPanel buttonsPanel = new JPanel();
        add(buttonsPanel, BorderLayout.SOUTH);
        JButton blueButton = new JButton("Blue");
        JButton whiteButton = new JButton("White");
        JButton redButton = new JButton("Red");

    }

    public static void main(String[] args) {
        Flag flagFrame = new Flag();
        flagFrame.setVisible(true);
    }
}


/*
PANELS
- JPanel - top level component used to group other components, think of this as a <div> in HTML
 */

/*
MVC - model view controller
- separating the design/presentation from underlying logic

                          request                   event
                  VIEW ------------>  CONTROLLER ------------> MODEL |
                  ^                                                  |
                  |---------------------------------------------------
                                          change


 */