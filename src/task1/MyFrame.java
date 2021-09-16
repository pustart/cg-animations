package task1;

import javax.swing.*;

public class MyFrame extends JFrame {
    final DrawingPanel panel = new DrawingPanel();

    MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Drawing tool");
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}