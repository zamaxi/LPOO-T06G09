package maze.logic;


/** 
 * 
 * Class Celula.java- cria um objecto constituido por 2 coordenadas 
 * para a criacao do mapa randomizado
 * 
 * @see Map
 * @author Gabriel Borges, Marco Pinto
 *
 *
 */
public class Celula {

	int x;
	int y;

	Celula(int cx,int cy){
		x=cx;
		y=cy;
	}

	/**
	 * @param args  mapa de jogo
	 * @return bool, returna false caso a celula ja tenha sido visitada ou o inverso
	 */
	public boolean CelulasNV(char [][] args) {

		if(x+2<args.length)
			if(args[y][x+2]=='V')
				return true;
		if(x-2>0)
			if(args[y][x-2]=='V')
				return true;
		if(y+2<args.length)
			if(args[y+2][x]=='V')
				return true;
		if(y-2>0)
			if(args[y-2][x]=='V')
				return true;

		return false;
	}

}