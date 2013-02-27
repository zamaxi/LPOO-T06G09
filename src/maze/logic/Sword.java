package maze.logic;

import java.util.Random;


public class Sword {

	private static int x,y;
	
	public Sword(char [][] args)
	{
		Random randomGenerator = new Random();

		y=0;
		x=0;
		
		while(args[y][x] == args[0][0])
		{
			int movex = randomGenerator.nextInt(7)+1;
			int movey = randomGenerator.nextInt(7)+1;
			x= movex;
			y= movey;
		}
		
		args[y][x]='E';
		
	}
	
	
}
