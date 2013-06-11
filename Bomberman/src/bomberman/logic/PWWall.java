package bomberman.logic;

/**
 * 
 * @author Kratos
 *Construtor da Classe PWWall
 *Objecto controlado pelo utilizador
 */
public class PWWall extends Powerup{

	public PWWall(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '6';
		index = 6;
	}

}
