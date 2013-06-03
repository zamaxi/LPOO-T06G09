package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import bomberman.logic.Game;

public class bomberman {

	private String craft = "testbomb.png";
	private int dx;
	private int dy;
	private int x;
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int y;
	private int width;
	private int height;
	private Image image;

	public bomberman() {
		ImageIcon ii = new ImageIcon(craft);
		image = ii.getImage();
		x = 50;
		y = 50;
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public void move() {
		x += dx;
		y += dy;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return image;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -1;

		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;

		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;

		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;

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

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
}