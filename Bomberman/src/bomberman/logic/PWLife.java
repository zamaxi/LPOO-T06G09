package bomberman.logic;

/**
 * 
 * @author Kratos
 *Construtor da Classe PWLife
 *Objecto controlado pelo utilizador
 */
public class PWLife extends Powerup{

	public PWLife(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '2';
		index = 2;
	}

}
