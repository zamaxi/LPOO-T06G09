package maze.logic;

import java.io.Serializable;
import java.util.Random;

public class Element implements Serializable{
	protected int x,y;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Element(char [][] args, int z, int d){
		x = z;
		y = d;
	}

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
