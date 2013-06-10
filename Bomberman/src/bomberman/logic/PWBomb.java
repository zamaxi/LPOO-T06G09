package bomberman.logic;

public class PWBomb extends Powerup{

	public PWBomb(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '1';
		index = 1;
	}

}
