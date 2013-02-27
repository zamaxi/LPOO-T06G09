import java.util.Random;

public class Map {
	
	
	static String[][] mapa ={{"X","X","X","X","X","X","X","X","X","X\n"},
							 {"X"," "," "," "," "," "," "," "," ","X\n"},
							 {"X"," ","X","X"," ","X"," ","X"," ","X\n"},
							 {"X"," ","X","X"," ","X"," ","X"," ","X\n"},
							 {"X"," ","X","X"," ","X"," ","X"," ","X\n"},
							 {"X"," "," "," "," "," "," ","X"," ","X\n"},
							 {"X"," ","X","X"," ","X"," ","X"," ","X\n"},
						   	 {"X"," ","X","X"," ","X"," ","X"," ","X\n"},
						 	 {"X"," ","X","X"," "," "," "," "," ","X\n"},
							 {"X","X","X","X","X","X","X","X","X","X\n"}};

	public static void printMapa(String[][] args)
	{
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(args[i][j]);
			}
		}
	}

	
	public static void randomizeMap(String[][] args)
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
			args[0][local] = "S";
			
			if(args[1][local] == "X")
				args[1][local] = " ";			
			
		}
		
		if(aresta == 1)
		{
			local= randomGenerator.nextInt(7)+1;
			args[9][local] = "S";
			
			if(args[8][local] == "X")
				args[8][local] = " ";
			
		}
		
		if(aresta == 2)
		{
			local= randomGenerator.nextInt(7)+1;
			args[local][0] = "S";
			
			if(args[local][1] == "X")
				args[local][1] = " ";
			
		}
		if(aresta == 3)
		{
			local= randomGenerator.nextInt(7)+1;
			args[local][9] = "S";
			
			if(args[local][8] == "X")
				args[local][8] = " ";
			
		}
		
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		Hero h = new Hero(mapa);
		Sword e= new Sword(mapa);
		Dragon d = new Dragon(mapa);
		int verify=0;
		
		randomizeMap(mapa);
		
		printMapa(mapa);
		while(verify == 0)
			{	
				if(d.asword== true)
					
				verify = h.MoveHero(mapa);
				printMapa(mapa);
				
				if(verify == 1)
				{
					printMapa(mapa);
					System.out.println("Venceu!!");
					break;
				}
			if(verify == 2)
				{
					printMapa(mapa);
					System.out.println("Perdeste!! O teu Herói morreu");
					break;
				}
			if(h.dragon_killed == false)
				d.MoveDragon(mapa);
				
			}
		
		
	
		
	}
}





/*
public static void main(String[] args) { 
	Heroi h = new Heroi(map);
	Espada e = new Espada(map);
	PrintMap(map);
	while(h.alive == true) {
		h.HeroMove(map);
		if(h.alive==true)
		PrintMap(map);
	}
}*/
