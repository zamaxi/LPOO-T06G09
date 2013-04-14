package maze.logic;

import java.io.Serializable;


/**
 * Class Eagle
 * Cria uma aguia com a posicao do heroi
 *
 */
public class Eagle implements Serializable{
	
	private int x,y; //posição da aguia	
	private boolean levantaVoo = false;
	private int counter =0;
	public Eagle(char args[][])
	{
		y= Hero.a;
		x= Hero.b;
	}
	
	public boolean isLevantaVoo() {
		return levantaVoo;
	}

	public void setLevantaVoo(boolean levantaVoo) {
		this.levantaVoo = levantaVoo;
	}

	boolean awake;
	private char eagle = 'V';

	public char getEagle() {
		return eagle;
	}

	public void setEagle(char eagle) {
		this.eagle = eagle;
	}

	static char path = 0;
	int xinicial, yinicial;
	static boolean found = false;
	static boolean gotSword = false;
	
	/**
	 * @param args 
	 * @param xespada
	 * @param yespada
	 * 
	 * Move a aguia em direcao a posicao da espada (x e y), e ao encontra-la, volta para a posicao de onde foi lancada
	 * e fica la ate ser apanhada pelo heroi ou morta por um dragao
	 */
	public void move_Eagle(char args[][], int xespada, int yespada) {


		if (counter == 0) {
			y = Hero.a;
			x = Hero.b;
			yinicial = y;
			xinicial = x;
		}

		if (found == false) {
			if (yespada > y && xespada > x) {

				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x + 1];
				args[y + 1][x + 1] = getEagle();
				y++;
				x++;
				counter++;
				return;

			}
			if (yespada < y && xespada < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x - 1];
				args[y - 1][x - 1] = getEagle();
				y--;
				x--;
				counter++;
				return;
			}

			if (yespada == y && xespada > x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y][x + 1];
				args[y][x + 1] = getEagle();
				x++;
				counter++;
				return;
			}
			if (yespada > y && xespada == x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x];
				args[y + 1][x] = getEagle();
				y++;
				counter++;
				return;
			}
			if (yespada < y && xespada == x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x];
				args[y - 1][x] = getEagle();
				y--;
				counter++;
				return;
			}
			if (yespada == y && xespada < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y][x - 1];
				args[y][x - 1] = getEagle();
				x--;
				counter++;
				return;
			}
			if (yespada > y && xespada < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x - 1];
				args[y + 1][x - 1] = getEagle();
				y++;
				x--;
				counter++;
				return;
			}
			if (yespada < y && xespada > x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x + 1];
				args[y - 1][x + 1] = getEagle();
				x++;
				y--;
				counter++;
				return;
			}
			if (yespada == y && xespada == x)
				found = true;
		}
		
		
		
		if (found == true) {
			if (yinicial > y && xinicial > x) {

				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x + 1];
				args[y + 1][x + 1] = getEagle();
				y++;
				x++;
				counter++;
				return;

			}
			if (yinicial < y && xinicial < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x - 1];
				args[y - 1][x - 1] = getEagle();
				y--;
				x--;
				counter++;
				return;
			}

			if (yinicial == y && xinicial > x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y][x + 1];
				args[y][x + 1] = getEagle();
				x++;
				counter++;
				return;
			}
			if (yinicial > y && xinicial == x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x];
				args[y + 1][x] = getEagle();
				y++;
				counter++;
				return;
			}
			if (yinicial < y && xinicial == x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x];
				args[y - 1][x] = getEagle();
				y--;
				counter++;
				return;
			}
			if (yinicial == y && xinicial < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y][x - 1];
				args[y][x - 1] = getEagle();
				x--;
				counter++;
				return;
			}
			if (yinicial > y && xinicial < x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y + 1][x - 1];
				args[y + 1][x - 1] = getEagle();
				y++;
				x--;
				counter++;
				return;
			}
			if (yinicial < y && xinicial > x) {
				if (counter != 0)
					args[y][x] = path;
				path = args[y - 1][x + 1];
				args[y - 1][x + 1] = getEagle();
				x++;
				y--;
				counter++;
				return;
			}
			
			if (yinicial == y && xinicial == x)
				gotSword = true;
		}

	}
}
