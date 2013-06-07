package bomberman.logic;

import java.awt.Rectangle;
import java.util.Random;
import java.util.Vector;

import bomberman.logic.Game;

public class Monster {
	int x=0,y=0;
	int width, height;
	int direction =1;
	boolean colide = false;
	boolean dead = true;
	
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

	public Monster(char args [][]){
		Random randomGenerator = new Random();
		
		while( args [y][x] != ' '){
			x = randomGenerator.nextInt(args.length -1)+1;
			y = randomGenerator.nextInt(args.length -1)+1;
		}
		
		x *= 50;
		y *= 50;
		x += 1;
		y += 1;
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

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}

	public void moveMonster(Game g) {
		Random randomGenerator = new Random();

		checkCollisions(g, this.x + 1, this.y + 1);

		if (colide == true) {
			if (direction == 0)
				x -= 1;

			if(direction == 1)
				y -= 1;

			if(direction == 2)
				x += 1;

			if(direction == 3)
				y += 1;

			direction = randomGenerator.nextInt(4);
			
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
		}
	}
}
