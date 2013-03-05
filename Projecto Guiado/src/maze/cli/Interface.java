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

	static int g = Map.game_logic();

	public static char cmdLine()
	{
		printMapa(Map.mapa);

		char keybind;
		String key;

		readK = new Scanner(System.in);
		System.out.println("Prima uma tecla:");
		key= readK.next();
		keybind = key.charAt(0);
		
		return keybind;
	}
	
	public static void main(String[]args){
		
		int verify=0;
		
			while(verify==0){
				verify=g;
				//printMapa(Map.mapa);
			}
			
			
			if(verify== 1){
				System.out.println("Venceu!!");
			}
				
			if(verify== 2){
				System.out.println("Perdeste!! O teu Herói morreu");
			}
		//	printMapa(Map.mapa);	
		
		
		
	}
}