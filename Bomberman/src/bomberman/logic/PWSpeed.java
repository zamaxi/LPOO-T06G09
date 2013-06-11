package bomberman.logic;

/**
 * 
 * @author KratosBomb
 *Construtor da Classe PWSpeed
 *Objecto controlado pelo utilizador
 */
public class PWSpeed extends Powerup{

	public PWSpeed(char[][]args, int z, int d) {
		super(args, z, d);
		args[y][x] = '4';
		index = 4;
	}

}
