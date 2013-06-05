package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;

import bomberman.logic.Game;

public class monster {

	private Image image;
	int x=0,y=0;
	int width, height;
	int direction =1;
	boolean colide = false;
	Vector<Rectangle> r = new Vector<Rectangle>();
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

	public monster(char args [][]){
		ImageIcon ii = new ImageIcon("Monster.png");
		image = ii.getImage();
		Random randomGenerator = new Random();
		while( args [y][x] != ' '){
		x = randomGenerator.nextInt(args.length -1)+1;
		y = randomGenerator.nextInt(args.length  -1)+1;
		}
		x *= 50;
		y *= 50;
		x += 1;
		y += 1;
		width = image.getWidth(null);
		height = image.getHeight(null);

	}

	public void checkCollisions(Game g, int x1, int y1) {
		Rectangle r3 = new Rectangle(x1, y1, 40, 40);
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;
		if (r.size() == 0) {
			for (int j = 0; j < mapa.length; j++) {
				x = 0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'X') {
						Rectangle rect = new Rectangle(x, y, 50, 50);
						r.add(rect);
					}
					x += 50;
				}
				y += 50;
			}
		}

		for (int i = 0; i < r.size(); i++) {

			if (r3.intersects(r.get(i))) {
				colide = true;
			}
		}
	}
	
	public Image getImage() {
		return image;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
	
	public void moveMonster(Game g) {
		Random randomGenerator = new Random();

		checkCollisions(g, this.x + 1, this.y + 1);

		if (colide == true) {

			direction = randomGenerator.nextInt(4);
			//System.out.println(direction);

			colide = false;
			return;
		}
		if (colide == false) {
			
			if (direction == 0)
				x += 1;
			
			if(direction == 1)
				y += 1;
				
			if(direction == 2)
				x -= 1;
			
			if(direction == 3)
				y -= 1;
			System.out.println("x: " + x);
			System.out.println("y: " + y);
		}
		
	}
}
