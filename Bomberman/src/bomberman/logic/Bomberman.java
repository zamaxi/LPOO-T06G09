package bomberman.logic;

public class Bomberman {

	int x,y;

	public Bomberman(char [][] map, int z, int d){
		x = d;
		y = z;
		
		map[y][x] = 'b';
	}

	void moveBomberman(char[][] map, char key){
		switch(key){
		case 'w':{
			if(map[(y-1)][x]!='X'){
				if(map[y][x] != 'f')
					map[y][x] = ' ';
				else 
					map[y][x] = 'e';
				y -= 1;
				map[y][x] = 'b';
			}
			break;
		}
		case 's':{
			if(map[(y+1)][x]!='X'){
				if(map[y][x] != 'f')
					map[y][x] = ' ';
				else 
					map[y][x] = 'e';
				y += 1;
				map[y][x] = 'b';
			}
			break;
		}
		case 'a':{
			if(map[y][(x-1)]!='X'){
				if(map[y][x] == 'f')
					map[y][x] = 'e';
				else map[y][x] = ' ';
				x -= 1;
				map[y][x] = 'b';
			}
			break;
		}
		case 'd':{
			if(map[y][(x+1)]!='X'){
				if(map[y][x] != 'f')
					map[y][x] = ' ';
				else map[y][x] = 'e';
				x += 1;
				map[y][x] = 'b';
			}
			break;
		}
		case 'b':{
			Bomb e = new Bomb(x, y);
			e.dropBomb(map);
			
		}
		default: break;
		}
	}

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
}
