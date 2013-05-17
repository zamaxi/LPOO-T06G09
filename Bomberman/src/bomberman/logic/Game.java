package bomberman.logic;



public class Game {

	Maze z= new Maze();
	Monster m = new Monster(z.getMapa());
	
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
	
}
