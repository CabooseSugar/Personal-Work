import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JDialog implements ActionListener {
    private Nav nav;
    private JLabel infoLabel;
    private JButton retrieveBtn;
    private JButton operationsBtn;
    private JPanel panel;
    private OracleDataSource ods;

    public Menu(Nav nav, OracleDataSource ods) {
        this.nav = nav;

        infoLabel = new JLabel();
        infoLabel.setText("Menu");

        retrieveBtn = new JButton("Retrieve a table");
        retrieveBtn.addActionListener(this);

        operationsBtn = new JButton("Operations on takes");
        operationsBtn.addActionListener(this);

        panel = new JPanel(new GridLayout(3, 3, 10, 10));

       panel.add(infoLabel);
       panel.add(retrieveBtn);
       panel.add(operationsBtn);
       this.ods = ods;

       pack();
       panel.setVisible(false);
    }

    public JPanel getPanel(){
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == retrieveBtn){
            nav.goTo(3);
        }
        else {
            nav.goTo(4);
        }

    }
}