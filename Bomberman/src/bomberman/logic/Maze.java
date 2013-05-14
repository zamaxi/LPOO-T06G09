package bomberman.logic;

public class Maze {
	//11*11
	char[][] mapa ={{'X','X','X','X','X','X','X','X','X','X','X'},
					{'X',' ','b',' ','b','b',' ','b',' ',' ','X'},
					{'X',' ','X','b','X',' ','X',' ','X',' ','X'},
					{'X','b',' ',' ',' ','b',' ',' ',' ',' ','X'},
					{'X','b','X','b','X',' ','X',' ','X','b','X'},
					{'X',' ',' ',' ',' ','b',' ',' ',' ',' ','X'},
					{'X',' ','X',' ','X',' ','X',' ','X',' ','X'},
					{'X',' ',' ',' ',' ',' ',' ',' ','b','b','X'},
					{'X',' ','X',' ','X','b','X',' ','X',' ','X'},
					{'X','b','b',' ',' ','b','b','b',' ',' ','X'},
					{'X','X','X','X','X','X','X','X','X','X','X'}};
	
	public char[][] getMapa() {
		return mapa;
	}

	int length = mapa.length;

	public int getLength() {
		return length;
	}



}
