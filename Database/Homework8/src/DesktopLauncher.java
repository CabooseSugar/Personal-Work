import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DesktopLauncher {

    public static void main(String[] args) {
        OracleDataSource ods = null;
        try {
            ods = new OracleDataSource();
            String url = "jdbc:oracle:thin:@//hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu";
            ods.setUser("kzw5332");
            ods.setPassword("kzw5332");
            Connection conn = ods.getConnection();
            System.out.println("connected.");

            System.out.println("hey it worked");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("hey it didn't");
        }
    }

}