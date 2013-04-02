package maze.test;

import static org.junit.Assert.*;

import maze.cli.Interface;
import maze.logic.*;

public class Test {

	public char[][] mapa ={{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};
	
	Hero h = new Hero(mapa);
	Sword s = new Sword(mapa);

	@org.junit.Test
	public void testMoveHero() {
		assertEquals(0, h.moveHero(mapa, 's'));
	}
	
	@org.junit.Test
	public void armedHero(){
		h.moveHero(mapa, 's');
		for(int i=0;i<10;i++)
		{
			System.out.println(mapa[i]);
		}
		assertEquals(true, Hero.isArmed());
	}

}
