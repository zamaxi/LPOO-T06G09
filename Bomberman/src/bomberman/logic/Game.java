package bomberman.logic;



public class Game {

	static Maze z= new Maze();
	static Monster m = new Monster(z.getMapa());
	public static Bomberman b = new Bomberman(1,1);
	public static Powerup p = new PWBomb(5,5);
	
	public Monster getM() {
		return m;
	}

	public Maze getZ() {
		return z;
	}

	public void setZ(Maze z) {
		this.z = z;
	}

	public Game(){
 
	}
	
	public static void initilaizeObjects(){
		z.addBomberman(Game.b);
		z.addMonster(m);
		z.addPW(Game.p);
	}
	
	public static void gameLogic(char key){		
		b.moveBomberman(z.getMapa(), key);
	}
}
