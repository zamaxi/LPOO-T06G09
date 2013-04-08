package maze.cli;

import java.util.Scanner;


import maze.logic.Map;

public class Interface {

	private static Scanner readK;
	private static  int n_dragoes;
	private static  int modo_de_jogo;
	
	public static int getModo_de_jogo() {
		return modo_de_jogo;
	}


	public static void setModo_de_jogo(int modo_de_jogo) {
		Interface.modo_de_jogo = modo_de_jogo;
	}


	public static int getN_dragoes() {
		return n_dragoes;
	}


	public static void setN_dragoes(int n_dragoes) {
		Interface.n_dragoes = n_dragoes;
	}

	
	
	
	public static void printMapa(char[][] args)
	{
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
	}

	static int g = Map.game_logic();

	public static void select()
	{
		System.out.println("Defina o tamanho do mapa!");
		Scanner scan = new Scanner (System.in);
		String number = scan.nextLine();
		int size = Integer.parseInt(number);
		Map.mapa = Map.CreateMap(size);
		
		int key;
		readK = new Scanner(System.in);
		System.out.println("Qual o modo de jogo que quer jogar?\n 1-Dragao parado\n 2-Dragao com movimento aleatorio\n 3-Dragao com movimento aleatorio intrecalado com dormir");
		key= readK.nextInt();
		setModo_de_jogo(key);
		
		System.out.println("Quantos dragoes quer em jogo?\n");
		key= readK.nextInt();
		setN_dragoes(key);
	}
	
	
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