package maze.logic;

public class Celula {

	int x;
	int y;

	Celula(int cx,int cy){
		x=cx;
		y=cy;
	}

	public boolean CelulasNV(char [][] args) {

		if(x+2<args.length)
			if(args[y][x+2]=='V')
				return true;
		if(x-2>0)
			if(args[y][x-2]=='V')
				return true;
		if(y+2<args.length)
			if(args[y+2][x]=='V')
				return true;
		if(y-2>0)
			if(args[y-2][x]=='V')
				return true;

		return false;
	}

}