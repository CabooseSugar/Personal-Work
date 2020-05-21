import oracle.jdbc.pool.OracleDataSource;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu");

        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        ods.setUser("kzw5332");
        ods.setPassword("kzw5332");
        Connection conn = ods.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from takes natural join course where id = " + id);
        while(rs.next())
        {
            rs.getString(1);
        }
    }
}





        /*
        Nav nav = new Nav();

        JFrame frame = new JFrame("Database");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        Login l = new Login(nav, ods);
        frame.add(l.getPanel());
        Menu m = new Menu(nav, ods);
        frame.add(m.getPanel());
        Retrieve r = new Retrieve(nav, ods);
        frame.add(r.getPanel());
        Operations o = new Operations(nav, ods);
        frame.add(o.getPanel());

        nav.setLogin(l);
        nav.setMenu(m);
        nav.setRetrieve(r);
        nav.setOperation(o);

        nav.goTo(1);

        frame.setResizable(false);
        frame.setVisible(true);
        */





