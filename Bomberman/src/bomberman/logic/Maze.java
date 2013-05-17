package bomberman.logic;

public class Maze {
	//11*11
	char[][]mapa = {{'X','X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X',' ','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X',' ','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X',' ','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X',' ','X',' ','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X','X'}};

	public Maze(){

	}

	public char[][] getMapa() {
		return mapa;
	}

	int length = mapa.length;

	public int getLength() {
		return length;
	}

	public void addBomb(Bomb b){
		mapa[b.y][b.x] = 'e';
	}

	public void addBomberman(Bomberman b){
		mapa[b.y][b.x] = 'b';
	}

	public void addMonster(Monster m){
		mapa[m.y][m.x] = 'm';
	}

	public void addPW(Powerup p){
		mapa[p.y][p.x] = 'p';
	}
}
