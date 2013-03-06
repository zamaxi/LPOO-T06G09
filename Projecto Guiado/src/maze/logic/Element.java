package maze.logic;

import java.util.Random;

public class Element {
	protected int x,y;
	
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
