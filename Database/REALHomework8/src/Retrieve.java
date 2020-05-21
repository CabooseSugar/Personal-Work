import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.*;
import javax.xml.transform.Result;

public class Retrieve extends JDialog implements ActionListener {
    private Nav nav;
    private JLabel infoLabel;
    private JButton backBtn;
    private JButton viewBtn;
    private JComboBox tableList;
    private JPanel panel;
    private OracleDataSource ods;
    private Connection conn;

    public Retrieve(Nav nav, OracleDataSource ods) throws SQLException {
        this.nav = nav;

        infoLabel = new JLabel();
        infoLabel.setText("Select table:");

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        viewBtn = new JButton("View");
        viewBtn.addActionListener(this);

        panel = new JPanel(new GridLayout(3, 3, 10, 10));

        panel.add(infoLabel);
        this.ods = ods;
    }

    public void connect(Connection c) throws SQLException {
        conn = c;

        ArrayList<String> tableNames = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT table_name FROM user_tables ORDER BY table_name");
        while (rs.next()) {
            tableNames.add(rs.getString(1));
        }

        int i = 0;
        String[] tableNamesStr = new String[tableNames.size()];
        for (String s : tableNames) {
            tableNamesStr[i] = s;
            i++;
        }

        tableList = new JComboBox(tableNamesStr);
        tableList.setSelectedIndex(0);
        tableList.addActionListener(this);
        panel.add(tableList);

        panel.add(viewBtn);
        panel.add(backBtn);

        pack();
        panel.setVisible(false);

    }

    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == backBtn) {
            nav.goTo(2);
        }
        if (actionEvent.getSource() == viewBtn) {
            String table = (String) tableList.getSelectedItem();

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData md = rs.getMetaData();
                int colNum = md.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= colNum; i++) {
                        System.out.println(rs.getString(i) + " ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}