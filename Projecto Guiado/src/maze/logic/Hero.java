package maze.logic;


public class Hero extends Element{

public static int a;
public static int b;

public Hero(char[][] args) {
		super(args);
		// TODO Auto-generated constructor stub
		a=y;
		b=x;
		if (armed == false)
			args[y][x]='H';
		else
			args[y][x]='A';
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
	
	public int moveHero(char [][] args, char keybind){
		int result=0;
		/* 0- Continua a Mover
		 * 1- Venceu
		 * 2- Morreu
		 */

		if(keybind == 's'){
			if(args[y+1][x] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y+1][x] = ' ';
			}

			if(args[y+1][x] == 'd'){
				if(isArmed() == true){
					args[y+1][x] = ' ';
					Dragon.setKilled(true);
				}
			}
			
			if(args[y+1][x] == 'D'){
				if(isArmed() == true){
					args[y+1][x] = ' ';
					Dragon.setKilled(true);
				}

				else result =2;
			}

			if(args[y+1][x] == 'S' && isArmed() ==true){
				result= 1;
				return result;
			}

			if(args[y+1][x] == ' '){
				args[y][x] = ' ';
				args[y+1][x] = getHero();
				y++;
			}
			
		}

		if(keybind == 'w'){
			if(args[y-1][x] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y-1][x] = ' ';
			}
			
			if(args[y-1][x] == 'd'){
				if(isArmed() == true){
					args[y-1][x] = ' ';
					Dragon.setKilled(true);
				}
			}
			
			if(args[y-1][x] == 'D'){
				if(isArmed() == true){
					args[y-1][x] = ' ';
					Dragon.setKilled(true);
				}
				else result =2;
			}

			if(args[y-1][x] == 'S' && isArmed() ==true){
				result =1;
				return result;
			}

			if(args[y-1][x] == ' '){
				args[y][x] = ' ';
				args[y-1][x] = getHero();
				y--;
			}
		}

		if(keybind == 'd'){
			if(args[y][x+1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y][x+1] = ' ';
			}

			if(args[y][x+1] == 'd'){
				if(isArmed() == true){
					args[y][x+1] = ' ';
					Dragon.setKilled(true);
				}
			}
			
			if(args[y][x+1] == 'D'){
				if(isArmed() == true){
					args[y][x+1] = ' ';
					Dragon.setKilled(true);
				}
				
				else result =2;
			}

			if(args[y][x+1] == 'S' && isArmed() ==true){
				result=1;
				return result;
			}

			if(args[y][x+1] == ' '){
				args[y][x] = ' ';
				args[y][x+1] = getHero();
				x++;
			}
			
		}

		if(keybind == 'a'){
			if(args[y][x-1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y][x-1] = ' ';
			}

			if(args[y][x-1] == 'd'){
				if(isArmed() == true){
					args[y][x-1] = ' ';
					Dragon.setKilled(true);
				}
			}
			
			if(args[y][x-1] == 'D'){
				if(isArmed() == true){
					args[y][x-1] = ' ';
					Dragon.setKilled(true);
				}
				else result =2;
			}

			if(args[y][x-1] == 'S'  && isArmed() ==true){ 
				result=1;
				return result;
			}

			if(args[y][x-1] == ' '){
				args[y][x] = ' ';
				args[y][x-1] = getHero();
				x--;
			}
			
		}
		return result;
	}

}
