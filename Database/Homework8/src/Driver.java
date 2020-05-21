import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;


import javax.swing.*;

public class Driver {

    public static void main(String[] args) {
        Connection connection = null;
        final String PATH = "jdbc:oracle:thin:@//hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu";

        //Try to connect to the database. If it doesn't work, connection will be null.
        try {
        connection = DriverManager.getConnection(PATH, "kzw5332", "kzw5332");
            System.out.println("you connected, I guess.");
        } catch (SQLException ignored) {
            System.out.println("fail");
        }
    }
}