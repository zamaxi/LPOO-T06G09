package bomberman.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;




public class Monster   {

	int x,y, n_monsters;
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getY() {
		return y;
	}


	Timer timer;
	
	
	public Monster(char [][] args){
		Random randomGenerator = new Random();
		
		while(args[y][x] != ' ')
		{
			int movex = randomGenerator.nextInt(args.length -1)+1;
			int movey = randomGenerator.nextInt(args.length  -1)+1;
			x= movex;
			y= movey;
		}
		
		args[y][x] = 'M';

	}
	
	
	static int movement = 1; //1-right 2 down 3-left 4-right
	
	public void moveMonster(char[][] args)
	{
		
		
		if(args[y][x+1] == ' ' && movement == 1){
			args[y][x]=' ';
			args[y][x+1] = 'M';
			x++;
			return;
		}
		
		
		if(args[y+1][x] == ' ' && movement == 2){
			args[y][x]=' ';
			args[y+1][x] = 'M';
			y++;
			return;
		}

		
		if(args[y][x-1] == ' ' && movement == 3){
			args[y][x]=' ';
			args[y][x-1] = 'M';
			x--;
			return;
		}

		if(args[y-1][x] == ' ' && movement == 4){
			args[y][x]=' ';
			args[y-1][x] = 'M';
			y--;
			return;
		}
		else movement++;
		
		if(movement == 5)
			movement = 1;
		
	}


}


