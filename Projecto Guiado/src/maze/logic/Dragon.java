package maze.logic;

import java.util.Random;

import maze.cli.Interface;


public class Dragon extends Element{
	private char Dragon;
	private boolean Killed = false;
	private boolean sleep = false;

	public Dragon(char[][] args) {
		super(args);
		args[y][x]='D';
	}

	public boolean isSleep() {
		return sleep;
	}

	public void setSleep(boolean sleep) {
		this.sleep = sleep;
	}

	public char getDragon() {
		return Dragon;
	}



	public void setDragon(char dragon) {
		Dragon = dragon;
	}



	public boolean isKilled() {
		return Killed;
	}

	public void setKilled(boolean killed) {
		Killed = killed;
	}



	public void moveDragon(char[][] args)
	{
		Random randomGenerator = new Random();
		/*
		 * 0- cima
		 * 1- baixo
		 * 2- direita
		 * 3- esquerda
		 * 4- mantem
		 * 5- dragao a dormir
		 */
		int move;
		int sword =0;
		boolean moved=false;

		while(moved == false)
		{
			if(isSleep() == true)
			{

				args[y][x]='d';
				setSleep(false);
				break;
			}

			if(isKilled() == true)
			{
				args[y][x] = ' ';
				break;
			}

			move = randomGenerator.nextInt(6);
			if(move == 0)
			{
				if(args[y-1][x] == ' ')
				{
					args[y-1][x] = 'D';
					if(sword==1)
						args[y][x]= 'E';
					else 
						args[y][x]=' ';
					y= y-1;
					moved = true;
					sword=0;
				}

				if(args[y-1][x] == 'E')
				{
					args[y-1][x] = 'F';
					args[y][x]=' ';
					y= y-1;
					sword =1;
					moved = true;
				}
			}

			if(move == 1)
			{
				if(args[y+1][x] == ' ')
				{	
					args[y+1][x] = 'D';
					args[y][x]=' ';
					if(sword==1)
						args[y][x]= 'E';
					else 
						args[y][x]=' ';
					y= y+1;
					moved = true;
					sword=0;
				}

				if(args[y+1][x] == 'E')
				{ 
					args[y+1][x] = 'F';
					args[y][x]=' ';
					y= y+1;
					sword=1;
					moved = true;
				}
			}

			if(move == 2)
			{
				if(args[y][x-1] == ' ')
				{	
					args[y][x-1] = 'D';
					if(sword==1)
						args[y][x]= 'E';
					else 
						args[y][x]=' ';
					x= x-1;
					moved = true;
					sword=0;
				}

				if(args[y][x-1] == 'E')
				{
					args[y][x-1] = 'F';
					args[y][x]=' ';
					x= x-1;
					sword=1;
					moved = true;
				}
			}

			if(move == 3)
			{
				if(args[y][x+1] == ' ')
				{
					args[y][x+1] = 'D';
					if(sword==1)
						args[y][x]= 'E';
					else 
						args[y][x]=' ';
					x= x+1;
					moved = true;
					sword=0;
				}

				if(args[y][x+1] == 'E')
				{
					args[y][x+1] = 'F';
					args[y][x]=' ';
					x= x+1;
					sword=1;
					moved = true;
				}
			}

			if(move == 4)
			{
				moved=true;
			}

			if(Interface.getModo_de_jogo()==3){
				if(move == 5)
				{
					moved=true;

					setSleep(true);
				}
			}
		}


	}

}
