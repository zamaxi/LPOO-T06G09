package bomberman.logic;

public class PWRange extends Powerup{

	public PWRange(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '3';
		index = 3;
	}

}
