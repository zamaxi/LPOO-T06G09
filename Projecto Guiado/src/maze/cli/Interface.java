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


	public static Integer getN_dragoes() {
		return n_dragoes;
	}


	public static void setN_dragoes(int n_dragoes) {
		Interface.n_dragoes = n_dragoes;
	}

	
	
	
	/**
	 * @param args -mapa de jogo
	 * Imprime o mapa alfanumerico no ecra
	 */
	public static void printMapa(char[][] args)
	{
		for(int i=0;i<args.length;i++)
		{
			System.out.println(args[i]);
		}
	}

	/**
	 * @param args-mapa de jogo
	 * Interface alfanumerica do jogo. 
	 * @see Map
	 */
	public static void main(String[]args){
		
		
		
		int key;
		readK = new Scanner(System.in);
		System.out.println("Qual o modo de jogo que quer jogar?\n 1-Dragao parado\n 2-Dragao com movimento aleatorio\n 3-Dragao com movimento aleatorio intrecalado com dormir");
		key= readK.nextInt();
		setModo_de_jogo(key);
		
		System.out.println("Quantos dragoes quer em jogo?\n");
		key= readK.nextInt();
		setN_dragoes(key);
		
		System.out.println("Defina o tamanho do mapa!");
		Scanner scan = new Scanner (System.in);
		String number = scan.nextLine();
		int size = Integer.parseInt(number);
		//Map.mapa = Map.CreateMap(size);
		
		printMapa(Map.mapa);
		
		System.out.println("Prima uma tecla:");
		char keybind;
		String keym;

		readK = new Scanner(System.in);
		keym= readK.next();
		keybind = keym.charAt(0);
		
		Map.game_logic(keybind);
		
		int verify=0;
			while(verify==0){
				printMapa(Map.mapa);
				System.out.println("Prima uma tecla:");

				readK = new Scanner(System.in);
				keym= readK.next();
				keybind = keym.charAt(0);
				verify=Map.game_logic(keybind);
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