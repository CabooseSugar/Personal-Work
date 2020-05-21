package flag_panel_with_menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame implements ActionListener {
    JPanel greenPanel;
    JPanel whitePanel;
    JPanel redPanel;

    // Constructor
    public MenuFrame() throws HeadlessException {
        // Frame
        setSize(900, 500);
        setTitle("Flag example");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Flag colors
        setLayout(new GridLayout(1,3));
        greenPanel = new JPanel();
        add(greenPanel);
        whitePanel = new JPanel();
        add(whitePanel);
        redPanel = new JPanel();
        add(redPanel);

        // Java Menu
        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);  // use JMenuBar instead of MenuBar, that's swing instead of AWT

        // JMenu
        JMenu menu = new JMenu();
        menu.setText("File");
        jMenuBar.add(menu);

        // JMenu Items
        JMenuItem greenItem = new JMenuItem();
        greenItem.setText("Green");
        greenItem.addActionListener(this);
        menu.add(greenItem);
        JMenuItem whiteItem = new JMenuItem();
        whiteItem.setText("White");
        whiteItem.addActionListener(this);
        menu.add(whiteItem);
        JMenuItem redItem = new JMenuItem();
        redItem.setText("Red");
        redItem.addActionListener(this);
        menu.add(redItem);


    }

    public static void main(String[] args) {
        MenuFrame menuFrame = new MenuFrame();
        menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand().toUpperCase()) {
            case "GREEN":
                greenPanel.setBackground(Color.green);
                break;
            case "WHITE":
                whitePanel.setBackground(Color.white);
                break;
            case "RED":
                redPanel.setBackground(Color.red);
                break;
        }
    }
}

