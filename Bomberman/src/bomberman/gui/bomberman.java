package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;

import bomberman.logic.Game;

public class bomberman {

	private String craft1 = "testbomb.png";
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
	private int width = 50;
	private int height = 50;
	private Image image;
	Vector<Rectangle> r = new Vector<Rectangle>();
	boolean colide = false;

	public void checkCollisions(Game g, int x1, int y1) {
		Rectangle r3 = new Rectangle(x1, y1, 40, 40);
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;
		if(r.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'X'){
						Rectangle rect = new Rectangle(x, y, 50, 50);
						r.add(rect);
					}
					x += 50;
				}
				y += 50;
			}
		}

		for(int i =0; i < r.size();i++){

			if(r3.intersects(r.get(i))) {
				colide = true;
			}
		}
	}

	public bomberman() {
		ImageIcon ii = new ImageIcon(craft1);
		image = ii.getImage();
		x = 51;
		y = 51;
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	int testDirection;

	public void move(Game g) {
		checkCollisions(g, (this.x + dx), (this.y + dy));
		if(colide == false){
			x += dx;
			y += dy;
		}
		else{
			//			switch(testDirection){
			//			case 1:{
			//				x += 1;
			//			}
			//			case 2:{
			//				x -= 1;
			//			}
			//			case 3:{
			//				y += 1;
			//			}
			//			case 4:{
			//				y -= 1;
			//			}
			//			}
			colide = false;
		}
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
			testDirection = 1;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
			testDirection = 2;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;
			testDirection = 3;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
			testDirection = 4;
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