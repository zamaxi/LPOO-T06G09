package maze.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class graphics extends JFrame {

    public graphics() {
       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                graphics ex = new graphics();
                ex.setVisible(true);
            }
        });
    }
}