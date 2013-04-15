package maze.test;

import static org.junit.Assert.*;

import maze.logic.Eagle;
import maze.logic.Hero;
import maze.logic.Map;

import org.junit.Test;

public class TestComplex {
	
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
	
	Eagle z = new Eagle(mapa);
	Hero h = new Hero(mapa);

	@Test
	public void eagleFly() {
		assertEquals(3, h.moveHero(Map.mapa, 'q'));
	}
	
	

}
