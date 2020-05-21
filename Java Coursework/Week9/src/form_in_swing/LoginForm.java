package form_in_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private final String USERNAME = "yeezy";
    private final String PASSWORD = "000000";


    // INSTANCE DATA
    JLabel errorMessage = new JLabel();
    JLabel successMessage = new JLabel();
    JTextField usernameField = new JTextField();
    JTextField passwordField = new JTextField();

    public LoginForm() throws HeadlessException {
        setSize(600,600);
        setTitle("Login to application");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.white);

        // TOP ROW
        JPanel messagePanel = new JPanel();
        errorMessage.setBackground(Color.red);
        errorMessage.setVisible(false);
        successMessage.setBackground(Color.green);
        successMessage.setVisible(false);
        messagePanel.add(errorMessage);
        messagePanel.add(successMessage);
        add(messagePanel, BorderLayout.NORTH); // add message panel to frame

        // CENTER CONTENT
        JPanel form = new JPanel();
        JPanel userRow = new JPanel();
        userRow.setLayout(new FlowLayout());
        userRow.add(new JLabel("Username"));
        usernameField = new JTextField();
        userRow.add(usernameField);
        form.add(userRow);

        JPanel passRow = new JPanel();
        passRow.setLayout(new FlowLayout());
        passRow.add(new JLabel("Password"));
        passwordField = new JTextField();
        passRow.add(passwordField);
        form.add(passRow);

        add(form, BorderLayout.CENTER);

        // Button Row
        JPanel buttonRow = new JPanel();
        buttonRow.setLayout(new FlowLayout());
        JButton button = new JButton("Log In");
        button.addActionListener(this);
        buttonRow.add(new JButton("Login:"));
        buttonRow.add(new JButton("Password:"));
        add(buttonRow, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
