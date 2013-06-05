package bomberman.logic;

import java.awt.Rectangle;

public class Bombant {

	int x,y;
	Rectangle bounds;
	boolean explodes = false;
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public Bombant(int z, int d) {
		// TODO Auto-generated constructor stub
		x = d;
		y = z;
	}

	public void dropBomb(final char[][]map,final int x1,final int y1){
		map[x1][y1]='f';
		System.out.println("DROPOU");
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						map[x1][y1] = ' ';
						if(map[x1+1][y1] != 'X')
							map[x1+1][y1] = ' ';
						if(map[x1][y1+1] != 'X')
							map[x1][y1+1] = ' ';
						if(map[x1-1][y1] != 'X')
							map[x1-1][y1] = ' ';
						if(map[x1][y1-1] != 'X')
							map[x1][y1-1] = ' ';
					}
				}, 
				2000 
				);
	}
	
	public  Rectangle getBounds() {
		return bounds;
	}
	
	public void setBounds(int x1,int y1, int width, int height){
		bounds = new Rectangle(x1,y1,width,height);
	}
	
	public void bombIntersect(){
		
	}
}
