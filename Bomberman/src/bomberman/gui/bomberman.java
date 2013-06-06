package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;

import bomberman.logic.Bombant;
import bomberman.logic.Game;

public class bomberman {

	private String craft1 = "testbomb.png";
	private int dx;
	private int dy;
	private int x;
	private Bomb bomb;
	

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

	public void keyPressed(KeyEvent e, Game g) {

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
		
		if(key == KeyEvent.VK_SPACE){
			bomb = new Bomb();
			bomb.setX(this.x);
			bomb.setY(this.y);
			
			dropped = true;
			
			dropBomb();
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
	
	
	boolean dropped;
	
	public boolean getDropped() {
		return dropped;
	}
	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}
	
	public void dropBomb(){
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						dropped = false;		
					}
				},
				2000
				);
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}
	
}

