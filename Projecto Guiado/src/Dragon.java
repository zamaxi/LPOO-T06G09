
import java.util.Random;

public class Dragon {

	private static int x,y;
	boolean asword;
	public Dragon(String[][] args)
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
		
		args[y][x]="D";
		
	}
	
	public void MoveDragon(String[][] args)
	{
		Random randomGenerator = new Random();
		/*
		 * 0- cima
		 * 1- baixo
		 * 2- direita
		 * 3- esquerda
		 * 4- mantem
		 */
		int move;
		boolean moved=false;
		
		while(moved == false)
		{
			move = randomGenerator.nextInt(5);
			if(move == 0)
			{
				if(args[y-1][x] == " ")
				{
					args[y-1][x] = "D";
					args[y][x]=" ";	
					y= y-1;
					moved = true;
				}
				
				if(args[y-1][x] == "E")
				{
					args[y-1][x] = "F";
					args[y][x]=" ";
					y= y-1;
					moved = true;
				}
			}
			
			if(move == 1)
			{
				if(args[y+1][x] == " ")
				{	
					args[y+1][x] = "D";
					args[y][x]=" ";
					y= y+1;
					moved = true;
				}
				
				if(args[y+1][x] == "E")
				{ 
					args[y+1][x] = "F";
					args[y][x]=" ";
					y= y+1;
					moved = true;
				}
			}
			
			if(move == 2)
			{
				if(args[y][x-1] == " ")
				{	
					args[y][x-1] = "D";
					args[y][x]=" ";	
					x= x-1;
					moved = true;
				}
				
				if(args[y][x-1] == "E")
				{
					args[y][x-1] = "F";
					args[y][x]=" ";
					x= x-1;
					moved = true;
				}
			}
			
			if(move == 3)
			{
				if(args[y][x+1] == " ")
				{
					args[y][x+1] = "D";
					args[y][x]=" ";
					x= x+1;
					moved = true;
				}
				
				if(args[y][x+1] == "E")
				{
					args[y][x+1] = "F";
					args[y][x]=" ";
					x= x+1;
					moved = true;
				}
			}
			
			if(move == 4)
			{
				moved=true;
			}
		}
		
		
	}
	
}
