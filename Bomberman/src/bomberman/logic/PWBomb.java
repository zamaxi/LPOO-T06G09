package bomberman.logic;

import java.awt.Rectangle;
import java.util.Vector;

public class PWBomb extends Powerup{
	Vector<Rectangle> pw;

	public PWBomb(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '1';
		index = 1;
	}
	
	public void collision(Game g){
		pw = new Vector<Rectangle>();
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;

		if(pw.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == '1'){
						Rectangle rect = new Rectangle(x, y, 50, 50);
						pw.add(rect);
					}						
					x += 50;
				}
				y += 50;
			}
		}
	}

}
