package bomberman.logic;

public class Bomb {

	int x,y;

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

	public Bomb(int z, int d) {
		// TODO Auto-generated constructor stub
		x = d;
		y = z;
	}

	public void dropBomb(final char[][]map){
		map[x][y]='f';

		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						map[x][y] = ' ';
						if(map[x+1][y] != 'X')
							map[x+1][y] = ' ';
						if(map[x][y+1] != 'X')
							map[x][y+1] = ' ';
						if(map[x-1][y] != 'X')
							map[x-1][y] = ' ';
						if(map[x][y-1] != 'X')
							map[x][y-1] = ' ';
					}
				}, 
				2000 
				);
	}
}
