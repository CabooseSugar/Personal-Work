import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import javax.swing.*;
import javax.swing.border.*;

public class Operations extends JDialog implements ActionListener {
    private Nav nav;
    private JTextField enterInsert;
    private JTextField enterUpdate;
    private JTextField enterI;

    private JLabel insertBtn;
    private JLabel updateBtn;
    private JLabel deleteBtn;
    private JLabel searchStudBtn;
    private JLabel searchSectBtn;
    private JLabel sortByBtn;

    private JButton backBtn;
    private JPanel panel;
    private OracleDataSource ods;

    public Operations(Nav nav, OracleDataSource ods) {
        this.nav = nav;

        //infoLabel = new JLabel();
        //infoLabel.setText("operations");

        backBtn = new JButton("Back");
        backBtn.addActionListener(this);


        panel = new JPanel(new GridLayout(3, 3, 10, 10));

       // panel.add(infoLabel);
        panel.add(backBtn);
        this.ods = ods;

        pack();
        panel.setVisible(false);
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == backBtn){
            nav.goTo(2);
        }
    }
}