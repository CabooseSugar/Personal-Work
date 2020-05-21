package exercise4;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Triangle extends JFrame implements DocumentListener {

    // Instance Data
    private JTextField orderField;
    private int order = 0;

    // Constructor
    public Triangle() throws HeadlessException {
        // Window
        setSize(800,1000);
        setTitle("Sierpinski exercise4.Triangle");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Panel for taking order of triangle at bottom of page
        JPanel orderPanel = new JPanel();
        orderPanel.setPreferredSize(new Dimension(800, 100));
        orderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        add(orderPanel, BorderLayout.PAGE_END);

        // Text Field
        JTextField orderPrompt = new JTextField(); // Enter an order prompt text
        orderPrompt.setText("Enter an order: ");
        orderPrompt.setBorder(new LineBorder(this.getBackground()));
        orderPrompt.setBackground(this.getBackground());
        orderPrompt.setFont(new Font("Sarif", Font.BOLD, 15));
        orderPrompt.setEditable(false);
        orderPanel.add(orderPrompt);

        orderField = new JTextField(); // actual order input field
        orderField.setFont(new Font("Sarif", Font.PLAIN, 15));
        orderField.setPreferredSize(new Dimension(50, 30));
        orderPanel.add(orderField);
        // Document listener used in place of an action listener for the JTextField to detect changes
        orderField.getDocument().addDocumentListener(this);

        // Set Visible
        setVisible(true);
    }

    // Override Methods of DocumentListener
    @Override
    public void insertUpdate(DocumentEvent e) {
        char[] orderFieldCharArr = orderField.getText().toCharArray();
        boolean isValid = true; // used to see if entry into orderField is valid

        // check if character entered into orderField isn't an integer by iterating through char array of orderField ...
        // ... for ASCII values higher than 9
        while(isValid) {
            for (int i = 0; i < orderFieldCharArr.length; i++)
                if (orderFieldCharArr[i] > '9')
                    isValid = false;
                break;
        }
        if (isValid) {
            order = Integer.parseInt(orderField.getText()); // get new number in orderField
            repaint(); // repaint with new order passed to recursive
        }
        else { // so if user had an integer entered but then entered an invalid character, nothing is displayed
            order = 0;
            repaint();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        char[] orderFieldCharArr = orderField.getText().toCharArray();
        boolean isValid = true;

        // same test in insertUpdate
        while(isValid) {
            for (int i = 0; i < orderFieldCharArr.length; i++)
                if (orderFieldCharArr[i] > '9')
                    isValid = false;
                break;
        }
        if (isValid) {
            if (orderField.getText().equals("")) // if removal leaves blank field, set order to 0
                order = 0;
            else
                order = Integer.parseInt(orderField.getText());
            repaint();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // changedUpdate is only called when something like the font or text size is changed, not the text itself
    }

    // Paint Method Override
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        recursiveTriangle(g,order, 700, 850, 400); // first call of recursive method, dictates size of outermost triangle 'shell'
    }

    // Recursive Method - Draws Triangles
    public void recursiveTriangle(Graphics g, int order, int length, int startY, int midPoint) {
        if (order == 0)
                return;
        g.drawLine(midPoint - (length/2) , startY, midPoint + (length/2) , startY); // bottom of triangle
        g.drawLine(midPoint - (length/2), startY, midPoint, startY - length); // left strut
        g.drawLine(midPoint + (length/2), startY, midPoint, startY - length); // right strut
        recursiveTriangle(g, order - 1, length/2, startY, midPoint - (length / 4) ); // recursive for lower left triangle
        recursiveTriangle(g, order - 1, length/2, startY, midPoint + (length / 4) ); // for lower right triangle
        recursiveTriangle(g, order - 1, length/2, startY - (length/2), midPoint); // for upper triangle
    }

    // Main Method
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
    }
}
