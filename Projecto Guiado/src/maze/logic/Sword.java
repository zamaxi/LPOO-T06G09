package maze.logic;

public class Sword extends Element {

	public static int c,d;
	public Sword(char[][] args) {
		super(args);
		// TODO Auto-generated constructor stub
		c = x;
		d = y;
		args[y][x]='E';
	}


	
	
}
