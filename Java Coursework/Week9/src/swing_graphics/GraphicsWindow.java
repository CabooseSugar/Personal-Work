package swing_graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicsWindow extends JFrame implements ActionListener {

    public GraphicsWindow() throws HeadlessException {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.drawRect(15,50, 200, 100); //Swing graphics origin for coordinates x/y starts at upper left hand part of screen rather than bottom left
        g.setColor(Color.blue);
        g.fillRect(250,250, 100, 50);
        g.setColor(Color.yellow);
        g.drawLine(50,50, 400, 400);
    }

    public static void main(String[] args) {
        GraphicsWindow graphicsWindow = new GraphicsWindow();
        graphicsWindow.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

