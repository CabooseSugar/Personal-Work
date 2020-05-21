package exercise3;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BarGraph extends JFrame {
    // Instance Data
    private int[] values;
    // Constructor
    public BarGraph(int[] values) throws HeadlessException {
        this.values = values; // will need this later for paint method

        // Window
        setSize(200 + (150 * values.length), 800); //window resizes based on amount of items on x axis
        setTitle("Bar graph");
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        // don't exit on close so if have multiple graphs they don't all exit at once
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Graph Title
        JTextField title = new JTextField("Jelly Beans in Jar");
        title.setFont(new Font("Sarif", Font.BOLD, 30));
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setBackground(Color.WHITE);
        title.setBorder(new LineBorder(Color.WHITE));
        title.setEditable(false);
        add(title, BorderLayout.PAGE_START);

        // X Axis Info - done with flow layout at Page_End of frame(line handled in paint method)
        JPanel xAxisPanel = new JPanel(); // create panel to put at PAGE_END of frame
        xAxisPanel.setPreferredSize(new Dimension(800, 100)); // adjust frame size so items aren't stuck so far down frame
        xAxisPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 125, 10)); // set appropriate distance between each item
        xAxisPanel.setBackground(Color.WHITE);
        add(xAxisPanel, BorderLayout.PAGE_END);

        for (int i = 0; i < values.length; i++) // adding items to xAxisPanel
        {
            JTextField xAxisText = new JTextField("Jar " + (i +1));
            xAxisText.setFont(new Font("Sarif", Font.PLAIN, 15));
            xAxisText.setBorder(new LineBorder(Color.WHITE)); // get rid of that black line border around text fields
            xAxisPanel.add(xAxisText);
        }

        // Y Axis Info - done with Grid Layout at Line Start of frame (line handled in paint method)
        JPanel yAxisPanel = new JPanel();
        yAxisPanel.setLayout(new GridLayout(13, 1, 0 ,33));
        yAxisPanel.setBackground(Color.WHITE);
        add(yAxisPanel, BorderLayout.LINE_START);

        for (int i = 12; i > 0; i--) {
            JTextField yAxisText = new JTextField("" + (i*50));
            yAxisText.setFont(new Font("Sarif", Font.PLAIN, 12));
            yAxisText.setBorder(new LineBorder(Color.WHITE));
            yAxisPanel.add(yAxisText);
        }

        // Set Visible
        setVisible(true);
    }

    // Paint Method Override
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Creating X axis line
        g.setColor(Color.BLACK);
        g.drawLine(60, 685, 1140, 685);
        // Creating Y Axis line
        g.drawLine(60, 685, 60,  40);
        // Creating marks along Y Axis
        for (int i = 0; i < 12; i ++)
            g.drawLine(50, 635 - (50 * i), 70, 635 - (50 * i));
        // Creating bars
        for (int i = 0; i < values.length; i++) {
            // y has to be 685 minus the height of the bar because the top of the page starts at 0 and the x axis
            // is at 685. When the rectangle is drawn its drawn from top to bottom, so need to start 585 for a bar with
            // value of 100.
            // Getting 160 for the x axis spacing was just brute force testing
            g.fillRect(120 + (160 * i), 685 - values[i], 50, (values[i] ));

        }
    }

    // Main Method
    public static void main(String[] args) {
        int[] values1 = {100, 150, 300, 550};
        BarGraph graph1 = new BarGraph(values1);
        int [] values2 = {50, 300, 200, 432, 100, 300};
        BarGraph graph2 = new BarGraph(values2); // will print two graphs
    }
}
