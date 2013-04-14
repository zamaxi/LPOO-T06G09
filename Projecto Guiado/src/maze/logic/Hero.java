package maze.logic;

import java.io.Serializable;


/**
 * Class Hero.java
 * Cria um heroi no mapa
 * @author Gabriel Borges, Marco Pinto
 */
public class Hero extends Element implements Serializable{

	public static int a;
	public static int b;
	public char dragonPos;

	public char getDragonPos() {
		return dragonPos;
	}


	public void setDragonPos(char dragonPos) {
		this.dragonPos = dragonPos;
	}
	
	/**
	 * @param args
	 * @param z
	 * @param r
	 * 
	 */
	public Hero(char [][] args, int z, int r){
		super(args);
		a = r;
		b = z;
		if (armed == false)
			args[a][b]='H';
		else
			args[a][b]='A';
	}


	public Hero(char[][] args) {
		super(args);
		// TODO Auto-generated constructor stub
		a=y;
		b=x;
		if (armed == false)
			args[a][b]='H';
		else
			args[a][b]='A';
	}


	private static boolean Alive = true;

	public static boolean isAlive() {
		return Alive;
	}


	public static void setAlive(boolean alive) {
		Alive = alive;
	}

	private char Hero = 'H';

	public char getHero() {
		return Hero;
	}


	public void setHero(boolean armed) {
		if(armed = false)
			Hero = 'H';
		if(armed = true)
			Hero = 'A';
	}

	private static boolean armed = false;

	public static boolean isArmed() {
		return armed;
	}


	public static void setArmed(boolean arm) {
		armed = arm;
	}

	/**
	 * @param args
	 * @param keybind
	 * @return result of operations ( usado no game_logic())
	 * 
	 * Move o heroi no mapa conforme a tecla recebida. Se encontra a espada, fica armado e a partir dai pode matar dragoes. 
	 * So e permitido vencer o jpgo se tiver armado
	 */
	public int moveHero(char [][] args, char keybind){
		int result=0;
		/* 0- Continua a Mover
		 * 1- Venceu
		 * 2- Morreu
		 */
		if(keybind == 's'){
			if(args[a+1][b] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[a+1][b] = ' ';
			}

			if(Eagle.gotSword == true)
				if(args[a+1][b] == 'V'){
					setArmed(true);
					setHero(isArmed());
					args[a+1][b] = ' ';
				}

			if(args[a+1][b] == 'd'){
				if(isArmed() == true){
					args[a+1][b] = ' ';
					setDragonPos('b');
				}
			}

			if(args[a+1][b] == 'D'){
				if(isArmed() == true){
					args[a+1][b] = ' ';
					setDragonPos('b');
				}

				else result =2;
			}

			if(args[a+1][b] == 'S' && isArmed() ==true){
				result= 1;
				return result;
			}

			if(args[a+1][b] == ' '){
				args[a][b] = ' ';
				args[a+1][b] = getHero();
				a++;
			}

		}

		if(keybind == 'w'){
			if(args[a-1][b] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[a-1][b] = ' ';
			}

			if(Eagle.gotSword == true)
				if(args[a-1][b] == 'V'){
					setArmed(true);
					setHero(isArmed());
					args[a-1][b] = ' ';
				}

			if(args[a-1][b] == 'd'){
				if(isArmed() == true){
					args[a-1][b] = ' ';
					setDragonPos('c');
				}
			}

			if(args[a-1][b] == 'D'){
				if(isArmed() == true){
					args[a-1][b] = ' ';
					setDragonPos('c');
				}
				else result =2;
			}

			if(args[a-1][b] == 'S' && isArmed() ==true){
				result =1;
				return result;
			}

			if(args[a-1][b] == ' '){
				args[a][b] = ' ';
				args[a-1][b] = getHero();
				a--;
			}
		}

		if(keybind == 'd'){
			if(args[a][b+1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[a][b+1] = ' ';
			}

			if(Eagle.gotSword == true)
				if(args[a][b+1] == 'V'){
					setArmed(true);
					setHero(isArmed());
					args[a][b+1] = ' ';
				}

			if(args[a][b+1] == 'd'){
				if(isArmed() == true){
					args[a][b+1] = ' ';
					setDragonPos('d');
				}
			}

			if(args[a][b+1] == 'D'){
				if(isArmed() == true){
					args[a][b+1] = ' ';
					setDragonPos('d');
				}

				else result =2;
			}

			if(args[a][b+1] == 'S' && isArmed() ==true){
				result=1;
				return result;
			}

			if(args[a][b+1] == ' '){
				args[a][b] = ' ';
				args[a][b+1] = getHero();
				b++;
			}

		}

		if(keybind == 'a'){
			if(args[a][b-1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[a][b-1] = ' ';
			}

			if(Eagle.gotSword == true)
				if(args[a][b-1] == 'V'){
					setArmed(true);
					setHero(isArmed());
					args[a][b-1] = ' ';
				}

			if(args[a][b-1] == 'd'){
				if(isArmed() == true){
					args[a][b-1] = ' ';
					setDragonPos('e');
				}
			}

			if(args[a][b-1] == 'D'){
				if(isArmed() == true){
					args[a][b-1] = ' ';
					setDragonPos('e');
				}
				else result =2;
			}

			if(args[a][b-1] == 'S'  && isArmed() ==true){ 
				result=1;
				return result;
			}

			if(args[a][b-1] == ' '){
				args[a][b] = ' ';
				args[a][b-1] = getHero();
				b--;
			}

		}

		if(keybind == 'q')
			result = 3;
		return result;
	}

}
