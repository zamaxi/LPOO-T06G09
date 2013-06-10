package bomberman.logic;

public class PWVest extends Powerup {

	public PWVest(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '5';
		index = 5;
	}
	
	

}
