package maze.logic;

import java.io.Serializable;
import java.util.Random;


/**
 * @author Gabriel Borges, Marco Pinto;
 * @see Hero, Dragon, Sword;
 * A classe Element encontra uma posicao Random para por os 3 elementos principais de jogo no mapa
 */

/**
 * @author Kratos
 *
 */
public class Element implements Serializable{
	
	protected int x,y;
	
	int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Element(char [][] args, int z, int d){
		x = z;
		y = d;
	}

	
	
	/**
	 * @param args
	 * Class Constructor
	 */
	public Element(char args[][])
	{
		Random randomGenerator = new Random();

		y=0;
		x=0;
		
		while(args[y][x] != ' ')
		{
			int movex = randomGenerator.nextInt(8)+1;
			int movey = randomGenerator.nextInt(8)+1;
			x= movex;
			y= movey;
		}
	}

}
