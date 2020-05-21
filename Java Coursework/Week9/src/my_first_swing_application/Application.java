
package my_first_swing_application;

import javax.swing.*;
import java.awt.*;

public class Application extends  JFrame{
    public static void main() {
    }
    }

        /* JAVA GUI
    - GUI, graphic user interface
    - 3 approaches to GUI in Java:
        1. AWT - older approach
        2. Swing - improvement on AWT
        3. JavaFX - not part of JDK11 anymore
        */

        //
        // create window

        // NEED TO WRITE LIKE THIS IF YOU DON'T EXTEND JFRAME
        /*
        JFrame myFrame = new JFrame();
        myFrame.setTitle("My first window");
        myFrame.setSize(500,300);
        myFrame.setVisible(true); // make it so the window is visible at runtime
        */

/*
        setTitle("My first window");
        setSize(500,300);
        setVisible(true);

        // exit options
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // makes it so you can't exit the window - by default it's "HIDE ON CLOSE" which keeps programming running technically
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // this one is the one you probably want, need to manually include it to stop running when exiting window
        // this overwrites DO NOTHING ON CLOSE

        // putting stuff in window
        add(new JLabel("Click me"));
        add(new JTextField());
        //add(new Button("Close me")); // Button is different from JButton, it's AWT, not Swing

        //
        // Flow layout -> components arranged in list
        setLayout(new FlowLayout());
        add(new JLabel("This is a label"));
        add(new JButton("Close me"));
    }

    public static void main(String[] args) {

    }
}

/*
SWING LAYOUT MANAGERS
1. Grid layout, looks like grid
2. flow layout, looks like a train
3. border layout, divides into north south east east and center

/*
*/

