package bomberman.test;

import static org.junit.Assert.*;

import bomberman.gui.GamePanel;
import bomberman.logic.Bomb;
import bomberman.logic.Bomberman;
import bomberman.logic.Game;
import bomberman.logic.Monster;

public class Test {
	
	char [][] map = new char[11][11];
	
	Bomberman b = new Bomberman();
	Game g = new Game();
	Bomb b2 = new Bomb();
	Monster m = new Monster(g.getZ().getMapa());
	
	@org.junit.Test
	public void moveBomberman() {
		b.move(g);
		
		assertEquals(false, b.getColide());
	}

	@org.junit.Test
	public void dropBomb() {
		b2.dropBomb();
		
		assertEquals(true, b2.getDropped());	
	}

	@org.junit.Test
	public void catchPowerup() {
		g.getZ().getMapa()[0][0] = '4';
		
		b.checkCollisions(g, 0, 0);
		
		assertEquals(true, b.speedUp);
	}

	@org.junit.Test
	public void enemyMovement() {
		m.moveMonster(g);
		
		assertEquals(false, m.getColide());
	}

	@org.junit.Test
	public void enemyKill() {
		b2.setX(0);
		b2.setY(0);
		m.setX(0);
		m.setY(0);
	}

	@org.junit.Test
	public void breakWall() {

	}

	@org.junit.Test
	public void loseGame() {
		b.setLives(0);
		
		assertEquals(0, b.getLives());
	}

	@org.junit.Test
	public void winGame() {

	}
}
