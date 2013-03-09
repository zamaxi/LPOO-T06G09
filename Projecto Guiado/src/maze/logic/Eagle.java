package maze.logic;

public class Eagle{
	
	private int x,y; //posição da aguia
	private int a,b;
	
	
	public Eagle(char args[][])
	{
		y= Hero.a;
		x= Hero.b;
	}
	
	boolean awake;
	private char eagle = 'V';
	
	public char getEagle() {
		return eagle;
	}

	public void setEagle(char eagle) {
		this.eagle = eagle;
	}

	public void move_Eagle(char args[][],char keybind)
	{
		char ocupied = 0;
		boolean found;
		if(keybind == ' ')
		{
			if(Sword.d > y && Sword.c > x){
				args[y+1][x+1] = ocupied;
				args[y+1][x+1] = getEagle();
			}
			if(Sword.d < y && Sword.c < x)
				args[y-1][x-1] = getEagle();
			
			if(Sword.d == y && Sword.c > x)
				args[y][x+1] = getEagle();
			
			if(Sword.d > y && Sword.c == x)
				args[y+1][x] = getEagle();
			
			if(Sword.d < y && Sword.c == x)
				args[y-1][x] = getEagle();
			
			if(Sword.d == y && Sword.c < x)
				args[y][x-1] = getEagle();
			
			if(Sword.d == y && Sword.c == x)
				found = true;
		}
	}
}
