import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

public class DatabaseGUI {

    public static OracleDataSource ods;
    public static Connection conn;
    public static JFrame frame = new JFrame();
    public static JButton login = new JButton("Log in");
    public static JTextField username = new JTextField(15);
    public static JPasswordField password = new JPasswordField(15);

    public static JTextField facultyName = new JTextField(15);
    public static JButton query = new JButton("Run Query");

    public static void loginAction(ActionEvent event) throws Exception{
        ods.setUser(username.getText());
        ods.setPassword(password.getText());
        conn = ods.getConnection();
        System.out.println("Connected ");
        frame.add(new JLabel("Connected "));
        frame.setVisible(true);
    }

    public static void queryAction(ActionEvent event) throws Exception{

        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select * from instructor " +
                "where name = '" + facultyName.getText() + "'");

        while (rset.next() ) {
    /*
      System.out.println(rset.getString(1) + " " +
                        rset.getString(2) + " " +
                        rset.getString(3) + " " +
                        rset.getFloat(4));
                        */
            frame.add(new JLabel(rset.getString(1)));
            frame.add(new JLabel(rset.getString(2)));
            frame.add(new JLabel(rset.getString(3)));
            frame.add(new JLabel(rset.getString(4)));
            frame.setVisible(true);
        }

    }
    public static void main(String[] args) throws Exception {
        // OracleDataSource ods = new OracleDataSource();
        ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu");


        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    loginAction(event);
                } catch (Exception E) {};
            }
        });

        query.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    queryAction(event);
                } catch (Exception E) {};
            }
        });

        frame.setLayout(new FlowLayout());
        frame.setTitle("Database Connection Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);

        frame.add(new JLabel("Username "));
        frame.add(username);
        frame.add(new JLabel("Password "));
        frame.add(password);
        frame.add(login);

        frame.add(facultyName);
        frame.add(query);

        frame.setResizable(true);
        frame.setVisible(true);
        //frame.setBackground(Color.BLUE);
    }
}