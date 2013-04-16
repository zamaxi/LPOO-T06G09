package maze.test;

import static org.junit.Assert.*;

import maze.cli.Interface;
import maze.logic.*;

public class Test {

	char[][] mapa ={{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};

	Hero h = new Hero(mapa, 1, 1);

	@org.junit.Test
	public void testMoveHero() {
		assertEquals(0, h.moveHero(mapa, 's'));
	}

	@org.junit.Test
	public void armedHero(){
		mapa[(h.a+1)][h.b] = 'E';
		h.moveHero(mapa, 's');
		assertEquals(true, h.isArmed());
	}
	
	@org.junit.Test
	public void loseGame(){
		mapa[(h.a+1)][h.b] = 'D';
		h.setArmed(false);
		assertEquals(2, h.moveHero(mapa, 's'));
	}
	
	@org.junit.Test
	public void killDragon(){
		mapa[(h.a+1)][h.b] = 'D';
		h.setArmed(true);
		assertEquals(0, h.moveHero(mapa, 's'));
	}
	
	@org.junit.Test
	public void winGame(){
		mapa[(h.a+1)][h.b] = 'S';
		h.setArmed(true);
		assertEquals(1, h.moveHero(mapa, 's'));
	}
	
	@org.junit.Test
	public void reachEndButNotWinGame(){
		mapa[(h.a+1)][h.b] = 'S';
		h.setArmed(false);
		assertEquals(0, h.moveHero(mapa, 's'));
	}
	
	@org.junit.Test
	public void notMoveHero(){
		mapa[(h.a+1)][h.b] = 'X';
		h.setArmed(false);
		h.moveHero(mapa, 's');
		boolean test = true;
		if(mapa[(h.a+1)][h.b] == 'X')
			test = false;
		
		assertEquals(false, test);
	}

}