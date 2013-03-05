package maze.logic;

import java.util.Random;

import maze.cli.Interface;

public class Map {

	public static char[][] mapa ={{'X','X','X','X','X','X','X','X','X','X'},
		{'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ','X',' ','X',' ','X'},
		{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
		{'X','X','X','X','X','X','X','X','X','X'}};


	public static void randomizeMap(char [][] args)
	{
		/*0-aresta superior
		 * 1-aresta inferior
		 * 2-aresta esquerda 
		 * 3 aresta direita		  
		 */

		Random randomGenerator = new Random();
		int aresta = randomGenerator.nextInt(4);
		int local;
		if(aresta == 0)
		{

			local= randomGenerator.nextInt(7)+1;
			args[0][local] = 'S';

			if(args[1][local] == 'X')
				args[1][local] = ' ';			

		}

		if(aresta == 1)
		{
			local= randomGenerator.nextInt(7)+1;
			args[9][local] = 'S';

			if(args[8][local] == 'X')
				args[8][local] = ' ';

		}

		if(aresta == 2)
		{
			local= randomGenerator.nextInt(7)+1;
			args[local][0] = 'S';

			if(args[local][1] == 'X')
				args[local][1] = ' ';

		}
		if(aresta == 3)
		{
			local= randomGenerator.nextInt(7)+1;
			args[local][9] = 'S';

			if(args[local][8] == 'X')
				args[local][8] = ' ';
		}
	}



	public static int game_logic()
	{
		int verify=0;
		Interface.select();
		Hero h = new Hero(Map.mapa);
		Sword e= new Sword(Map.mapa);
		randomizeMap(mapa);

		while(Hero.isAlive() == true){
			
			if(Dragon.isKilled() == false)
				d.moveDragon(Map.mapa);

			verify = h.moveHero(Map.mapa,Interface.cmdLine());
			if(verify == 1){
				return 1;
			}
			if(verify == 2){
				Hero.setAlive(false);
				return 2;
			}

			
		}
		return 0;
	}
}
