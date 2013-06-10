package bomberman.logic;

import java.awt.Rectangle;

public class Powerup {

	int x,y;
	int index;
	
	public int getIndex() {
		return index;
	}

	public Powerup(char[][] map, int z, int d){
		x = z;
		y = d;
	}
	
	public Rectangle getBounds(int x, int y) {
		return new Rectangle(x, y, 50, 50);

	}
	
}
