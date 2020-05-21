package window_listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class ConfirmWindow extends JFrame implements ActionListener {
    public ConfirmWindow() throws HeadlessException {
        setSize(600, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Close Confirmation");
        setLayout(new BorderLayout());

        add(new JTextField("Are you sure you want to close the window?"), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton okButton = new JButton();
        okButton.setText("OK");
        okButton.addActionListener(this);
        buttonPanel.add(okButton);

        JButton cancelButton = new JButton();
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this);
        buttonPanel.add(cancelButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "OK":
                System.exit(0);
                break;
            case "Cancel":
                dispose();
                break;
        }

    }
}
