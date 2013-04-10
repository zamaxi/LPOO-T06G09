package maze.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import maze.cli.Interface;
import maze.logic.Celula;

public class Map {

	public static char[][] mapa={{'X','X','X','X','X','X','X','X','X','X'},
	      {'X',' ',' ',' ',' ',' ',' ',' ',' ','X'},
	      {'X',' ','X','X',' ','X',' ','X',' ','X'},
	      {'X',' ','X','X',' ','X',' ','X',' ','X'},
	      {'X',' ','X','X',' ','X',' ','X',' ','X'},
	      {'X',' ',' ',' ',' ',' ',' ','X',' ','X'},
	      {'X',' ','X','X',' ','X',' ','X',' ','X'},
	      {'X',' ','X','X',' ','X',' ','X',' ','X'},
	      {'X',' ','X','X',' ',' ',' ',' ',' ','X'},
	      {'X','X','X','X','X','X','X','X','X','X'}};
	
	
	static Hero h;
	static Sword e;
	static Eagle z;
	static Dragon d;
	static Vector<Dragon> v = new Vector<Dragon>();

	
	public static void add(){
		h = new Hero(mapa);
		e = new Sword(mapa);
		d = new Dragon(mapa);
		z = new Eagle(mapa);
	}
	
	public static int mapSize;
	

/*
	public static char [][] CreateMap(int tamanho){

		if(tamanho%2==0)
		{
			tamanho=tamanho-1;
		}

		char [][] mapa = new char [tamanho][tamanho];
		for(int i = 0; i <= tamanho-1 ; i++ ) {
			for(int j = 0 ; j<= tamanho-1 ;j++) {
				if(j%2!=0)
				{
					mapa[i][j] = 'V';
				}

				if(i%2==0||j%2==0)
				{
					mapa[i][j] = 'X';
				}

			}
		}

		for(int i = 0; i <= tamanho-1 ; i++ )
		{
			mapa[0][i]='P';
			mapa[tamanho-1][i]='P';
			mapa[i][0]='P';
			mapa[i][tamanho-1]='P';
		}

		int x=0,y=0, lc , sx=0,sy=0, bx=0,by=0;
		Random r1 = new Random();
		Random r2 = new Random();
		x = r1.nextInt(tamanho);
		y = r2.nextInt(tamanho);
		while(((sx==0 && sy==0) || (sx==(tamanho-1) && sy==0)||(sx==0 && sy==(tamanho-1))||(sx==(tamanho-1) && sy==(tamanho-1)))){

			x = r1.nextInt(tamanho);
			y = r2.nextInt(tamanho);

			mapa[sy][sx]='P';
			mapa[by][bx]='P';

			Random cl = new Random();
			lc = cl.nextInt(4);


			switch (lc)
			{
			case 0: //linha esquerda
			{
				if(y%2==0)
					y=y+1;
				bx=1;
				by=y;
				sx=0;
				sy=y;
				mapa [y][0] = 'S';
				mapa [y][1] =' ';
				break;
			}
			case 1: //linha direita
			{
				if(y%2==0)
					y=y+1;
				bx=tamanho-2;
				by=y;
				sx=tamanho-1;
				sy=y;
				mapa [y][tamanho-1] = 'S';
				mapa [y][tamanho-2] =' ';
				break;
			}
			case 2: //linha cima
			{
				if(x%2==0)
					x=x+1;
				bx=x;
				by=1;
				sx=x;
				sy=0;
				mapa [0][x] = 'S';
				mapa [1][x] =' ';
				break;
			}
			case 3: //linha baixo
			{
				if(x%2==0)
					x=x+1;
				bx=x;
				by=tamanho-2;
				sx=x;
				sy=tamanho-1;
				mapa [tamanho-1][x] = 'S';
				mapa [tamanho-2][x] =' ';
				break;
			}
			}
			
			

		}


		Stack <Celula> naovisitados = new Stack<Celula>();
		Celula f = new Celula (bx,by);

		naovisitados.push(f);

		do
		{
			bx=naovisitados.peek().x;
			by=naovisitados.peek().y;

			if(naovisitados.peek().CelulasNV(mapa)==true)
			{
				Random r3 = new Random();
				int dir = r3.nextInt(4);

				boolean encontrou = false;

				while(encontrou==false)
				{
					switch(dir)
					{
					case 0 ://direita
					{
						if(bx+2<mapa.length)
						{
							if(mapa[by][bx+2]=='V')
							{
								Celula ed = new Celula(bx+2,by);
								naovisitados.push(ed);
								mapa[by][bx+1]=' ';
								mapa[by][bx+2]=' ';
							}
						}
						encontrou=true;
					}
					case 1 ://esquerda
					{
						if(bx-2>0)
						{
							if(mapa[by][bx-2]=='V')
							{
								Celula ed = new Celula(bx-2,by);
								naovisitados.push(ed);
								mapa[by][bx-1]=' ';
								mapa[by][bx-2]=' ';
							}
						}
						encontrou=true;
					}
					case 2 ://baixo
					{
						if(by+2<mapa.length)
						{
							if(mapa[by+2][bx]=='V')
							{
								Celula ed = new Celula(bx,by+2);
								naovisitados.push(ed);
								mapa[by+1][bx]=' ';
								mapa[by+2][bx]=' ';
							}
						}
						encontrou=true;
					}
					case 3 : //cima
					{
						if(by-2>0)
						{
							if(mapa[by-2][bx]=='V')
							{
								Celula ed = new Celula(bx,by-2);
								naovisitados.push(ed);
								mapa[by-1][bx]=' ';
								mapa[by-2][bx]=' ';
							}
						}
						encontrou=true;	
					}
					}
				}
			}

			else
				naovisitados.pop();


		}while(naovisitados.isEmpty()==false);



		int nmrX = (int) Math.abs (tamanho*tamanho*0.03);
		for(int i = 0; i < nmrX ; i++)
		{
			Random x1 = new Random();
			Random x2 = new Random();
			x = x1.nextInt(tamanho);
			y = x2.nextInt(tamanho);
			if((x+2<mapa.length&&x-2>0&&y+2<mapa.length&&y-2>0)&&((mapa[y-1][x]=='X'&&mapa[y+1][x]=='X')||(mapa[y-1][x]=='X'&&mapa[y+1][x]=='X')))
				mapa[y][x]=' ';
			else i--;
		}

		for(int i = 0; i <= tamanho-1 ; i++ )
		{
			mapa[0][i]='X';
			mapa[tamanho-1][i]='X';
			mapa[i][0]='X';
			mapa[i][tamanho-1]='X';
		}
		
		randomizeMap(mapa);
		
		h = new Hero(mapa);
		e = new Sword(mapa);
		z = new Eagle(mapa);
		
		for (int i = 1; i < Interface.getN_dragoes(); i++) {
			d = new Dragon(mapa);
			v.add(d);
		}
		
		d = new Dragon(mapa);
		v.add(d);
		setDragons(v);

		return mapa;
	}
*/	
	
	
	
	private static Vector<Dragon> dragons = new Vector<Dragon>();

	public static Vector<Dragon> getDragons() {
		return dragons;
	}

	public static void setDragons(Vector<Dragon> dragons) {
		Map.dragons = dragons;
	}

	public static void drawDragon(int NumeroDragoes) {
		for (int i = 0; i < NumeroDragoes; i++) {
			Dragon d = new Dragon(Map.mapa);
			dragons.add(d);
			
			// dragons.get(i).moveDragon(mapa);
		}
	}

	public static void randomizeMap(char[][] args) {
		/*
		 * 0-aresta superior 1-aresta inferior 2-aresta esquerda 3 aresta
		 * direita
		 */
		
		Random randomGenerator = new Random();
		int aresta = randomGenerator.nextInt(4);
		int local;
		if (aresta == 0) {

			local = randomGenerator.nextInt(args.length) + 1;
			args[0][local] = 'S';

			if (args[1][local] == 'X')
				args[1][local] = ' ';

		}

		if (aresta == 1) {
			local = randomGenerator.nextInt(args.length) + 1;
			args[(args.length-1)][local] = 'S';

			if (args[(args.length-2)][local] == 'X')
				args[(args.length-2)][local] = ' ';

		}

		if (aresta == 2) {
			local = randomGenerator.nextInt(args.length) + 1;
			args[local][0] = 'S';

			if (args[local][1] == 'X')
				args[local][1] = ' ';

		}
		if (aresta == 3) {
			local = randomGenerator.nextInt(args.length) + 1;
			args[local][(args.length-1)] = 'S';

			if (args[local][(args.length-2)] == 'X')
				args[local][(args.length-2)] = ' ';
		}
	}

	public static int game_logic(char key) {
		int verify = 0;
		

		if (Hero.isAlive() == true) {

			if (Dragon.isKilled() == false) {
				for (int i = 0; i < dragons.size(); i++) {
				/*	if (Interface.getModo_de_jogo() == 1)*/
						break;
				/*	else
						getDragons().get(i).moveDragon(mapa);*/
				}

			}

			if(z.isLevantaVoo() == true ){
				z.move_Eagle(mapa, Sword.c, Sword.d);

				if(Eagle.found == true)
					e.recoil(mapa);
			}
			verify = h.moveHero(Map.mapa, key);

			if (verify == 1) {
				return 1;
			}
			if (verify == 2) {
				Hero.setAlive(false);
				return 2;
			}
			if (verify == 3)
				z.setLevantaVoo(true);

		}
		return 0;
	}
}
