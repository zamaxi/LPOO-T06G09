package bomberman.logic;



public class Game {

	static Maze z = new Maze();
	static Monster m = new Monster(z.getMapa());
	public Bomberman b = new Bomberman(z.getMapa(), 1,1);
	
	public Monster getM() {
		return m;
	}

	public Maze getZ() {
		return z;
	}

	public Game(){
 
	}
	
	public void gameLogic(char key){		
		b.moveBomberman(z.getMapa(), key);
	}
}
