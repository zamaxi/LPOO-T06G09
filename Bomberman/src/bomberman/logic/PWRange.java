package bomberman.logic;

/**
 * 
 * @author Kratos
 *Construtor da Classe PWRange
 *Objecto controlado pelo utilizador
 */
public class PWRange extends Powerup{

	public PWRange(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '3';
		index = 3;
	}

}
