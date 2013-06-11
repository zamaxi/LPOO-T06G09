package bomberman.logic;

import java.awt.Rectangle;

public class Powerup {

	int x,y;
	int index;
	
	public int getIndex() {
		return index;
	}
/**
 * Cria um powerup no mapa
 * @param map
 * @param z
 * @param d
 */
	public Powerup(char[][] map, int z, int d){
		x = z;
		y = d;
	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return Rectangle
	 */
	public Rectangle getBounds(int x, int y) {
		return new Rectangle(x, y, 50, 50);

	}
	
	public void collision(){
		
	}
	
}
