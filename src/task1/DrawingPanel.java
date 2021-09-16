package task1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel implements ActionListener {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    final Timer timer = new Timer(4, this);

    Oval oval1 = new Oval(Color.WHITE, 300, 200, 20, 20, 0, -1);
    Oval oval2 = new Oval(Color.WHITE, 350, 250, 20, 20, 1, -1);
    Oval oval3 = new Oval(Color.WHITE, 400, 300, 20, 20, 1, 0);
    Oval oval4 = new Oval(Color.WHITE, 350, 350, 20, 20, 1, 1);
    Oval oval5 = new Oval(Color.WHITE, 300, 400, 20, 20, 0, 1);
    Oval oval6 = new Oval(Color.WHITE, 250, 350, 20, 20, -1, 1);
    Oval oval7 = new Oval(Color.WHITE, 200, 300, 20, 20, -1, 0);
    Oval oval8 = new Oval(Color.WHITE, 250, 250, 20, 20, -1, -1);

    public DrawingPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.black);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //paint background

        Graphics2D g2d = (Graphics2D) g;

        ovalDrawing(g2d, oval1);
        ovalDrawing(g2d, oval2);
        ovalDrawing(g2d, oval3);
        ovalDrawing(g2d, oval4);
        ovalDrawing(g2d, oval5);
        ovalDrawing(g2d, oval6);
        ovalDrawing(g2d, oval7);
        ovalDrawing(g2d, oval8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ovalRedrawing(oval1);
        ovalRedrawing(oval2);
        ovalRedrawing(oval3);
        ovalRedrawing(oval4);
        ovalRedrawing(oval5);
        ovalRedrawing(oval6);
        ovalRedrawing(oval7);
        ovalRedrawing(oval8);

        repaint();
    }

    private void ovalDrawing(Graphics2D g2d, Oval oval) {
        g2d.setColor(oval.getColor());
        g2d.fillOval(oval.getX(), oval.getY(), oval.getWidth(), oval.getHeight());
    }

    private void ovalRedrawing(Oval oval) {
        if (oval.getX() >= PANEL_WIDTH - oval.getWidth() || oval.getX() < 0) {
            oval.setxVelocity(oval.getxVelocity() * -1);
        }
        oval.setX(oval.getX() + oval.getxVelocity());

        if (oval.getY() >= PANEL_HEIGHT - oval.getHeight() || oval.getY() < 0) {
            oval.setyVelocity(oval.getyVelocity() * -1);
        }
        oval.setY(oval.getY() + oval.getyVelocity());
    }
}