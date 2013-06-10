package bomberman.logic;

import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;



public class Game {


	Vector <Monster > monstrinhos = new Vector <Monster >();
	public Vector<Monster> getMonstrinhos() {
		return monstrinhos;
	}

	int n_monster=3;
	
	
	static Maze z = new Maze();
   
	public Maze getZ() {
		return z;
	}

	public Game(){
		z.randomize();
		for(int i =0; i < n_monster;i++){
			Monster monster1 = new Monster(z.getMapa());
			monstrinhos.add(monster1);
		}
	}
	
	

        
        
	
	
	
	
	
	
}
