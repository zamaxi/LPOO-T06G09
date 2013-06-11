package bomberman.test;

import static org.junit.Assert.*;

import bomberman.logic.Bomb;
import bomberman.logic.Bomberman;
import bomberman.logic.Game;

public class Test {
	
	Bomberman b = new Bomberman();
	Game g = new Game();
	Bomb b2 = new Bomb();
	
	@org.junit.Test
	public void moveBomberman() {

	}

	@org.junit.Test
	public void dropBomb() {
		b2.dropBomb();
		
		assertEquals(true, b2.getDropped());	
	}

	@org.junit.Test
	public void catchPowerup() {

	}

	@org.junit.Test
	public void enemyMovement() {

	}

	@org.junit.Test
	public void enemyKill() {

	}

	@org.junit.Test
	public void breakWall() {

	}

	@org.junit.Test
	public void loseGame() {

	}

	@org.junit.Test
	public void winGame() {

	}
}
