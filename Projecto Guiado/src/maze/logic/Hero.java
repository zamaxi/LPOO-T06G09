package maze.logic;

import java.util.Random;

public class Hero{
	
	private static int x,y;

	public Hero(char[][] args)
	{
		Random randomGenerator = new Random();

		y=0;
		x=0;
		
		while(args[y][x] == args[0][0])
		{
			int movex = randomGenerator.nextInt(8)+1;
			int movey = randomGenerator.nextInt(8)+1;
			x= movex;
			y= movey;
		}
		
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

	private boolean armed = false;

	public boolean isArmed() {
		return armed;
	}


	public void setArmed(boolean armed) {
		this.armed = armed;
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

			if(args[y+1][x] == 'D'){
				if(isArmed() == true){
					args[y+1][x] = ' ';
					Dragon.setKilled(true);
				}

				else result =2;
			}

			if((args[y+1][x] == 'S' || args[y+1][x] == 'S') && isArmed() ==true){
				result= 1;
				return result;
			}

			if(args[y+1][x] == ' '){
				args[y][x] = ' ';
				args[y+1][x] = getHero();
				y++;
			}
			if(args[y+1][x] == 'd'){
				if(isArmed()==false)
					return result;
				else Dragon.setKilled(true);
			}
			
		}

		if(keybind == 'w'){
			if(args[y-1][x] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y-1][x] = ' ';
			}

			if(args[y-1][x] == 'D'){
				if(isArmed() == true){
					args[y-1][x] = ' ';
					Dragon.setKilled(true);
				}
				else result =2;
			}

			if((args[y-1][x] == 'S' || args[y-1][x] == 'S') && isArmed() ==true){
				result =1;
				return result;
			}

			if(args[y-1][x] == ' '){
				args[y][x] = ' ';
				args[y-1][x] = getHero();
				y--;
			}
			if(args[y-1][x] == 'd'){
				if(isArmed()==false)
					return result;
				else Dragon.setKilled(true);
			}
		}

		if(keybind == 'd'){
			if(args[y][x+1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y][x+1] = ' ';
			}

			if(args[y][x+1] == 'D'){
				if(isArmed() == true){
					args[y][x+1] = ' ';
					Dragon.setKilled(true);
				}
				
				else result =2;
			}

			if((args[y][x+1] == 'S' || args[y][x+1] == 'S') && isArmed() ==true){
				result=1;
				return result;
			}

			if(args[y][x+1] == ' '){
				args[y][x] = ' ';
				args[y][x+1] = getHero();
				x++;
			}
			
			if(args[y][x+1] == 'd'){
				if(isArmed()==false)
					return result;
				else Dragon.setKilled(true);
			}
		}

		if(keybind == 'a'){
			if(args[y][x-1] == 'E'){
				setArmed(true);
				setHero(isArmed());
				args[y][x-1] = ' ';
			}

			if(args[y][x-1] == 'D'){
				if(isArmed() == true){
					args[y][x-1] = ' ';
					Dragon.setKilled(true);
				}
				else result =2;
			}

			if((args[y][x-1] == 'S' || args[y][x-1] == 'S')  && isArmed() ==true){ 
				result=1;
				return result;
			}

			if(args[y][x-1] == ' '){
				args[y][x] = ' ';
				args[y][x-1] = getHero();
				x--;
			}
			
			if(args[y][x-1] == 'd'){
				if(isArmed()==true)
					{
						args[y][x-1] = ' ';
						Dragon.setKilled(true);
					}
				else return result; 
			}
		}
		return result;
	}

}
