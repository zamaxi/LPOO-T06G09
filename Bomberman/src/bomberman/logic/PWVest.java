package bomberman.logic;

/**
 * 
 * @author Kratos
 *Construtor da Classe PWVest
 *Objecto controlado pelo utilizador
 */
public class PWVest extends Powerup {

	public PWVest(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '5';
		index = 5;
	}
	
	

}
