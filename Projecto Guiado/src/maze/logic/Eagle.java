package maze.logic;

public class Eagle{
	
	private int x,y; //posição da aguia	
	private boolean levantaVoo = false;
	private int counter =0;
	public Eagle(char args[][])
	{
		y= Hero.a;
		x= Hero.b;
	}
	
	public boolean isLevantaVoo() {
		return levantaVoo;
	}

	public void setLevantaVoo(boolean levantaVoo) {
		this.levantaVoo = levantaVoo;
	}
	
	boolean awake;
	private char eagle = 'V';
	
	public char getEagle() {
		return eagle;
	}

	public void setEagle(char eagle) {
		this.eagle = eagle;
	}


	public void move_Eagle(char args[][], int xespada, int yespada)
	{
		char path = 0;
		boolean found;
		
		if(counter == 0){
		y = Hero.a;
		x = Hero.b;
		}
		
		
			if(yespada > y && xespada > x){
				
				if(counter != 0)
					args[y][x]=path;
				path = args[y+1][x+1];
				args[y+1][x+1] = getEagle();
				y++;
				x++;
				
			}
			if(yespada < y && xespada < x){
				args[y-1][x-1] = getEagle();
				y--;
				x--;
			}
	
			if(yespada == y && xespada > x){
				args[y][x+1] = getEagle();
				x++;
			}
			if(yespada > y && xespada == x){
				args[y+1][x] = getEagle();
				y++;
			}
			if(yespada < y && xespada == x){
				args[y-1][x] = getEagle();
				y--;
			}
			if(yespada == y && xespada < x){
				args[y][x-1] = getEagle();
				x--;
			}
			if(yespada > y && xespada < x){
				args[y+1][x-1] = getEagle();
				y++;
				x--;
			}
			if(yespada < y && xespada > x){
				args[y-1][x+1] = getEagle();
				x++;
				y--;
			}
			if(yespada == y && xespada == x)
				found = true;
			
			
		counter++;
	}
}
