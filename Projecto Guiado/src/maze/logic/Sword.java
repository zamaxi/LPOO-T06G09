package maze.logic;


public class Sword extends Element {

	public static int c,d;
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
