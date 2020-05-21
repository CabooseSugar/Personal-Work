import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends JDialog implements ActionListener {
    private Nav nav;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField enterUser;
    private JPasswordField enterPass;
    private JButton loginBtn;
    private JLabel error;
    private JPanel panel;
    private OracleDataSource ods;

    public Login(Nav nav, OracleDataSource ods) {
        this.nav = nav;

        userLabel = new JLabel();
        userLabel.setText("Username:");
        enterUser = new JTextField();

        passLabel = new JLabel();
        passLabel.setText("Password:");
        enterPass = new JPasswordField();

        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);

        error = new JLabel();

        panel = new JPanel(new GridLayout(3, 3, 10, 10));

        panel.add(userLabel);
        panel.add(enterUser);
        panel.add(passLabel);
        panel.add(enterPass);
        panel.add(loginBtn);
        panel.add(error);

        this.ods = ods;

        pack();
        panel.setVisible(true);
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String currentUser = enterUser.getText();
        String currentPass = enterPass.getText();
        ods.setUser(currentUser);
        ods.setPassword(currentPass);
        Connection conn = null;

        try {
            conn = ods.getConnection();
        } catch (SQLException e) {
            displayLoginError();
        }
        try {
            nav.initConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        nav.goTo(2);
    }

    public void displayLoginError() {
        error.setText("Invalid credentials, try again.");
    }
}