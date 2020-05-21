package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    // Instance data
    private JTextArea textArea; // this needs to be declared hear since going to be using it in overridden ActionListen method, menu choices...
                            // .. will be affecting it when clicked on
    // Constructor
    public TextEditor() throws HeadlessException {
        // Window
        setSize(600, 800);
        setTitle("Notepad");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Window layout (border layout)
        BorderLayout border = new BorderLayout();
        setLayout(border);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // JMenus on Menu bar
        JMenu fileMenu = new JMenu(); // create "File" dropdown menu on top menu bar
        fileMenu.setText("File");
        menuBar.add(fileMenu); // add menu bar items to menu bar, not Frame directly

        // JMenus' Items
        JMenuItem newFile = new JMenuItem(); // New option in File dropdown clears all text
        newFile.setText("New");
        newFile.addActionListener(this);
        fileMenu.add(newFile);

        JMenuItem openFile = new JMenuItem(); // Open option reads from .txt file from specific location and puts in JTextArea
        openFile.setText("Open");
        openFile.addActionListener(this);
        fileMenu.add(openFile);

        JMenuItem saveFile = new JMenuItem(); // Save option writes from JTextArea to .txt file in specific location
        saveFile.setText("Save");
        saveFile.addActionListener(this);
        fileMenu.add(saveFile);

        JMenuItem closeFile = new JMenuItem(); // Close option closes window
        closeFile.setText("Close");
        closeFile.addActionListener(this);
        fileMenu.add(closeFile);

        // Text field
        textArea = new JTextArea();
        add(textArea, BorderLayout.CENTER); // notice you choose destination to put text area by BorderLayout in general, not directly with "border"

        setVisible(true); // put setVisible at the end or else the frame won't update until resizing the window forces it to
    }

    // Main method
    public static void main(String[] args) {
        TextEditor textEdit = new TextEditor(); // just creating the object and making it visible at runtime
    }

    // Overriden method from interface ActionListener - defining actions
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toUpperCase()) {
            case "NEW":
                textArea.setText(""); // remove text in the notepad by setting textArea to null
                break;

            case "OPEN":
                // can't throw these exceptions because the interface TextEditor implements doesn't either (same thing happens with superclasses), have to do try catch block
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Kyle\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\ProblemSet4\\src\\exercise1\\TextEditorSave.txt"));
                    textArea.read(reader, " TextEditorSave.txt"); // JTextArea has its own read function, no loops required
                } catch (FileNotFoundException fnf) {
                    System.out.println(fnf.getMessage());
                } catch (IOException io) {
                    System.out.println(io.getMessage());
                }
                break;

            case "SAVE":
                // see case "OPEN" for why need try catch block
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Kyle\\Desktop\\College\\2018-2019\\Fall\\CMPSC221\\ProblemSet4\\src\\exercise1\\TextEditorSave.txt"));
                    textArea.write(writer); // JTextArea has its own write function too
                } catch (IOException io) {
                    System.out.println(io.getMessage());
                }
                break;

            case "CLOSE":
                //setVisible(false); // to just close the window itself
                dispose(); // alternatively, System.Exit(1)
                break;
        }
    }
}

