package maze.gui;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Wall {

    private String craft = "craft.png";

    private int dx;
    private int dy;
    private int x;
   

	private int y;
    private Image image;

    public Wall() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
        image = ii.getImage();
        x = 0;
        y = 0;
    }


    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
		this.x = x;
	}
    
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
		this.y = y;
	}
    
    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -30;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 30;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -30;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 30;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
