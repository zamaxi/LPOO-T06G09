package bomberman.logic;

public class PWWall extends Powerup{

	public PWWall(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '6';
		// TODO Auto-generated constructor stub
	}

}
