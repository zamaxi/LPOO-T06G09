import java.util.Scanner;
import java.util.Random;


public class Hero {

	private static int x,y;
	boolean venceu= false;
	boolean armed= false;
	boolean dragon_killed= false;
	
	public Hero(String[][] args)
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
		
		if (armed == false)
			args[y][x]="H";
		else
			args[y][x]="A";
		
	}


	public int MoveHero(String[][] args)
	{
		int result=0;
		/* 0- Continua a Mover
		 * 1- Venceu
		 * 2- Morreu
		 */
		String key;
		String Hero="";
		char keybind;


			Scanner readK = new Scanner(System.in);
			System.out.println("Prima uma tecla:");
			key= readK.next();
			keybind = key.charAt(0);


			if(armed != true)
				Hero = "H";
			if(armed == true)
				Hero= "A";
			
			if(keybind == 's')

			{
				if(args[y+1][x] == "E")
				{
					Hero = "A";
					armed=true;
					args[y+1][x] = " ";
				}
				
				if(args[y+1][x] == "D")
				{
					if(armed == true)
						{
							args[y+1][x] = " ";
							dragon_killed = true;
						}
					
					else result =2;
				}
				
				if((args[y+1][x] == "S\n" || args[y+1][x] == "S") && armed ==true)
				{
					venceu = true;
					result= 1;
					return result;
				}

				if(args[y+1][x] == " ")
				{
					args[y][x] = " ";
					args[y+1][x] = Hero;
					y = y+1;
				}
			}

			if(keybind == 'w')
			{
				if(args[y-1][x] == "E")
				{
					Hero = "A";
					armed=true;
					args[y-1][x] = " ";
				}
				
				if(args[y-1][x] == "D")
				{
					if(armed == true)
						{
							args[y-1][x] = " ";
							dragon_killed = true;
						}
					else result =2;
				}
				
				if((args[y-1][x] == "S\n" || args[y-1][x] == "S") && armed ==true)
				{
					venceu = true;
					result =1;
					return result;
				}

				if(args[y-1][x] == " ")
				{
					args[y][x] = " ";
					args[y-1][x] = Hero;
					y = y-1;
				}
			}

			if(keybind == 'd')
			{
				if(args[y][x+1] == "E")
				{
					Hero = "A";
					armed=true;
					args[y][x+1] = " ";
				}
				
				if(args[y][x+1] == "D")
				{
					if(armed == true)
						{
							args[y][x+1] = " ";
							dragon_killed = true;
						}
					else result =2;
				}
				
				if((args[y][x+1] == "S\n" || args[y][x+1] == "S") && armed ==true)
				{
					venceu = true;
					result=1;
					return result;
				}

				if(args[y][x+1] == " ")
				{
					args[y][x] = " ";
					args[y][x+1] = Hero;
					x = x+1;
				}
			}

			if(keybind == 'a')
			{
				if(args[y][x-1] == "E")
				{
					Hero = "A";
					armed=true;
					args[y][x-1] = " ";
				}
				
				if(args[y][x-1] == "D")
				{
					if(armed == true)
						{
							args[y][x-1] = " ";
							dragon_killed = true;
						}
					else result =2;
				}
				
				if((args[y][x-1] == "S\n" || args[y][x-1] == "S")  && armed ==true)
				{ 
					venceu = true;
					result=1;
					return result;
				}

				if(args[y][x-1] == " ")
				{
					args[y][x] = " ";
					args[y][x-1] = Hero;
					x = x-1;
				}
			}
			return result;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

