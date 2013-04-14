package maze.logic;

import java.io.Serializable;


/**
 * Class Sword.java
 * @author Gabriel Borges, Marco Pinto
 * Cria uma espada no mapa com o char 'E';
 */
public class Sword extends Element implements Serializable{

	public static int c,d;
	
	/**
	 * @param args
	 * @param z
	 * @param r
	 * 
	 */
	public Sword(char [][] args, int z, int r){
		super(args);
		c = z;
		d = r;
		args[d][c] = 'E';
	}
	
	public Sword(char[][] args) {
		super(args);
		c = x;
		d = y;
		args[d][c]='E';
	
		
	}

public void recoil(char[][] args){
	args[d][c] = ' ';
}
	
	
}
