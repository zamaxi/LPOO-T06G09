package bomberman.logic;

public class PWBomb extends Powerup{

	public PWBomb(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '1';
		// TODO Auto-generated constructor stub
	}

}
