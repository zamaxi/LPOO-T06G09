package maze.test;
import maze.logic.*;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void moveHero(){
		assertEquals(0, Map.game_logic());
	}
	
	public void getSword(){
		assertEquals(true, Hero.isArmed());
	}
	
	public void lose(){
		assertEquals(2, Map.game_logic());
	}
	
	public void killDragon(){
		assertEquals(true, Dragon.isKilled());
	}
	
	
	
	public void win() {
		assertEquals(1, Map.game_logic());
	}
	
	

}
