import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

import java.io.*;
import java.util.Scanner;

class FooJDBC {

    public static void main(String[] args) throws Exception{

        System.out.print("Connecting to the database...");

        // Open an OracleDataSource and get a connection
        OracleDataSource ods = new OracleDataSource();

        //ods.setServiceName("pdbcldb.hbg.psu.edu");
        ods.setURL("jdbc:oracle:thin:@hbgoracle.hbg.psu.edu:1521/pdbcldb.hbg.psu.edu");

        ods.setUser("kzw5332");  // set username -- security issue

        //ods.setPassword("********"); // set password -- security issue
        // revealing the password to whoever reads the code

        // read password from console with echo disabled
        // Console object will be null if run from IDE
        // Need to run from console
        //char[] password = System.console().readPassword("Password: ");
        ods.setPassword(String.valueOf("kzw5332"));

        // Open connection
        Connection conn = ods.getConnection();
        System.out.println("connected.");

        Statement stmt = conn.createStatement();

        ResultSet rset = stmt.executeQuery("select * from section");

    /*
    // extracting attributes names and types
    ResultSetMetaData rsmd = rset.getMetaData();
    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
      System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnTypeName(i));
    }

    while (rset.next()) {
      System.out.println(rset.getString(1) + " " +
                        rset.getString(2) + " " +
                        rset.getString(3) + " " +
                        rset.getFloat(4) + " " +
                        rset.getString(5) + " " +
                        rset.getString(6) +" " +
                        rset.getString(7));
    }
    */

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter faculty name: ");
        String facultyName = sc.nextLine();

        rset = stmt.executeQuery("select * from instructor " +
                "where name = '" + facultyName + "'");

        while (rset.next() ) {
            System.out.println(rset.getString(1) + " " +
                    rset.getString(2) + " " +
                    rset.getString(3) + " " +
                    rset.getFloat(4));
        }

        System.out.println("Using prepared statements.");
        PreparedStatement pStmt = conn.prepareStatement("select * from instructor" +
                " where name = ?");

        System.out.println("Enter faculty name: ");
        facultyName = sc.nextLine();

        pStmt.setString(1,facultyName);
        rset = pStmt.executeQuery();

        while (rset.next() ) {
            System.out.println(rset.getString(1) + " " +
                    rset.getString(2) + " " +
                    rset.getString(3) + " " +
                    rset.getFloat(4));
        }

    }
}
