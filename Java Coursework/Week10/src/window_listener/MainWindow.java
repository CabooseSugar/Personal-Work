package window_listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {

    public static void main(String[] args) {
        MainWindow window = new MainWindow();

    }

    public MainWindow() throws HeadlessException {
        setSize(400, 600);
        setTitle("Close Example");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setVisible(true);

        //
        // Add some components
        JTextField text = new JTextField();
        text.setText("Please try closing the window");
        add(text);

        //
        // Set background color
        getContentPane().setBackground(Color.MAGENTA);

        //
        // add Listener for window closing
        addWindowListener(new CloseWindowListener());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
