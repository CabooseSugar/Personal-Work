package applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApplets extends JFrame implements ActionListener {

    public static void main(String[] args) {
        MainApplets applet = new MainApplets();
        applet.setVisible(true);
    }
    private JTextField textField;

    public MainApplets() throws HeadlessException {
        setSize(600,600);
        //setTitle("Example");
        setLayout(new BorderLayout());
        textField = new JTextField();
        add(textField, BorderLayout.CENTER);

        JButton button = new JButton();
        button.setText("Click me");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "Click me":
                textField.setText("You clicked the button");
                break;
        }

    }
}
