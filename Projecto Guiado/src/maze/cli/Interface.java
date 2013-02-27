package maze.cli;

import java.util.Scanner;

import maze.logic.Dragon;
import maze.logic.Hero;
import maze.logic.Sword;
import maze.logic.Map;

public class Interface {

	private static Scanner readK;

	public static void printMapa(char[][] args)
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(args[i]);
		}
	}


	public static char cmdLine()
	{

		char keybind;
		String key;

		Map.randomizeMap(Map.mapa);


		readK = new Scanner(System.in);
		System.out.println("Prima uma tecla:");
		key= readK.next();
		keybind = key.charAt(0);
		
		return keybind;
	}
	
	public static void main(String[]args){
		Hero h = new Hero(Map.mapa);
		Sword e= new Sword(Map.mapa);
		Dragon d = new Dragon(Map.mapa);
		int verify = 0;
		
		printMapa(Map.mapa);

		while(Hero.isAlive() == true){

			verify = h.moveHero(Map.mapa,Interface.cmdLine());
			printMapa(Map.mapa);

			if(verify == 1){
				printMapa(Map.mapa);
				System.out.println("Venceu!!");
				break;
			}
			if(verify == 2){
				printMapa(Map.mapa);
				Hero.setAlive(false);
				System.out.println("Perdeste!! O teu Herói morreu");
				break;
			}
			
			if(Dragon.isKilled() == false)
				d.moveDragon(Map.mapa);
		}
	}
}