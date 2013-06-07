package bomberman.logic;

import java.util.Random;

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
		mapa[b.getY()][b.getX()] = 'e';
	}

	public void addBomberman(Bomberman b){
		mapa[b.getY()][b.getX()] = 'b';
	}
	
	public void randomize(){
		
		Random randomGenerator = new Random();

		for(int i =1; i < length;i++){
			
			if(i == 10)
				break;
			for(int j =1; j < length;j++){
				
				if(i == 1 && j == 1)
					continue;
				
				int appeared = randomGenerator.nextInt(3);
				
				if(j == 10)
					break;
				
				if(appeared == 0 && mapa[i][j] != 'X')
					mapa[i][j] = 'o';
				
			}
				
			
		}
	}

	public void addMonster(Monster m){
		mapa[m.y][m.x] = 'm';
	}

	public void addPW(Powerup p){
		mapa[p.y][p.x] = 'p';
	}
}
