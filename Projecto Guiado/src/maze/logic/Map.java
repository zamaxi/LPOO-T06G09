package maze.logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import maze.cli.Interface;
import maze.logic.Celula;


/**
 * Class Map
 * @author Gabriel Borges, Marco Pinto
 */
/**
 * @author Kratos
 *
 */
/**
 * @author Kratos
 *
 */
public class Map implements Serializable{



	public static char[][] mapa; 

	static Hero h;
	static Sword e;
	static Eagle z;
	static Dragon d;
	static Vector<Dragon> v = new Vector<Dragon>();


	public static void add(){
		h = new Hero(mapa);
		e = new Sword(mapa);
		z = new Eagle(mapa);
	}

	public static int mapSize;



	public static int getMapSize() {
		return mapSize;
	}

	public static void setMapSize(int mapSize) {
		Map.mapSize = mapSize;
	}
	
	
	public static char [][] CreateMap(char [][] args, Hero j, Vector<Dragon> f, Eagle k, Sword o){
		mapa = args;
		h = new Hero(mapa, j.getX(), j.getY());
		e = new Sword(mapa, o.getX(), o.getY());
		z = new Eagle(mapa);
		v = f;

		return mapa;

	}

	/**
	 * @param tamanho do mapa
	 * @return mapa de jogo
	 * Este metodo cria um mapa randomizado com o tamanho pretendido pelo utilizador
	 * @see Celula
	 */
	public static char [][] CreateMap(Integer tamanho){

		if(tamanho < 10 || tamanho == null)
			tamanho = 10;

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
		Map.mapa = mapa;
		randomizeMap(Map.mapa);

		h = new Hero(Map.mapa);
		e = new Sword(Map.mapa);
		z = new Eagle(Map.mapa);

		for (int i = 1; i < Interface.getN_dragoes(); i++) {
			d = new Dragon(Map.mapa);
			v.add(d);
		}

		d = new Dragon(Map.mapa);
		v.add(d);
		setDragons(v);
		
		return mapa;
	}




	private static Vector<Dragon> dragons = new Vector<Dragon>();

	public static Vector<Dragon> getDragons() {
		return dragons;
	}

	public static void setDragons(Vector<Dragon> dragons) {
		Map.dragons = dragons;
	}

	
	/**
	 * @param NumeroDragoes
	 * Desenha no mapa o numero de dragoes indicado pelo utilizador
	 * Se for menor ou igual a 0, desenha pelo menos 1
	 */
	public static void drawDragon(Integer NumeroDragoes) {

		if(Interface.getN_dragoes() == 0 || Interface.getN_dragoes()  == null ){
			Dragon d1 = new Dragon(Map.mapa);
			dragons.add(d1);
		}


		for (int i = 0; i < NumeroDragoes; i++) {
			Dragon d = new Dragon(Map.mapa);
			dragons.add(d);

			// dragons.get(i).moveDragon(mapa);
		}
	}

	/**
	 * @param pos
	 * Remove um dragao do vector caso este seja morto.
	 */
	public static void removeDragon(char pos){
		for (int i = 0; i < dragons.size(); i++){
			switch(pos){
			case 'c':{
				if(dragons.get(i).getY() == (h.getY()+1)){
					dragons.get(i).setKilled(true);
					dragons.remove(i);
					break;
				}
			}
			case 'b':{
				if(dragons.get(i).getY() == (h.getY()-1)){
					dragons.get(i).setKilled(true);
					dragons.remove(i);
					break;
				}
			}
			case 'd':{
				if(dragons.get(i).getX() == (h.getX()+1)){
					dragons.get(i).setKilled(true);
					dragons.remove(i);
					break;
				}
			}
			case 'e':{
				if(dragons.get(i).getX() == (h.getX()-1)){
					dragons.get(i).setKilled(true);
					dragons.remove(i);
					break;
				}
			}
			default:break;
			}
		}
	}

	public static void setMapa(char[][] mapa) {
		Map.mapa = mapa;
	}

	public static void setH(Hero h) {
		Map.h = h;
	}

	public static void setE(Sword e) {
		Map.e = e;
	}

	public static char[][] getMapa() {
		return mapa;
	}

	public static Hero getH() {
		return h;
	}

	public static Sword getE() {
		return e;
	}

	public static Eagle getZ() {
		return z;
	}

	public static Vector<Dragon> getV() {
		return v;
	}

	public static void setZ(Eagle z) {
		Map.z = z;
	}

	public static void setV(Vector<Dragon> v) {
		Map.v = v;
	}

	/**
	 * @param args
	 * Cria uma saida numa posicao Random no mapa, retirando os cantos do mesmo
	 */
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

	/**
	 * @param key
	 * @return result
	 * Gere toda  a logica de jogo. Recebe uma tecla do utizador, e conforme esta, mover� o heroi ou aguia para a posicao indicada.
	 */
	public static int game_logic(char key) {
		int verify = 0;


		if (Hero.isAlive() == true) {

			removeDragon(h.getDragonPos());

			for (int i = 0; i < dragons.size(); i++) {
				if (Interface.getModo_de_jogo() == 1)
					break;
				else
					getDragons().get(i).moveDragon(mapa);
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
