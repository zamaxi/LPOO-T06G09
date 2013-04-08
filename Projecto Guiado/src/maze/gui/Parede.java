package maze.gui;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Parede {

    private String parede = "parede.png";

    
    
    private int dx;
    private int dy;
    private int x;
   

	private int y;
    private Image image;

    public Parede() {
        ImageIcon ii = new ImageIcon("parede.png");
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



   
}
