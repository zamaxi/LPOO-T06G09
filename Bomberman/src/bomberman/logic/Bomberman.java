package bomberman.logic;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Vector;

import bomberman.logic.Game;
/**
 * 
 * @author Kratos
 * dimensions
 * 23 x 37
 */
public class Bomberman {

	private int dx;
	private int dy;
	private int x;
	private int y;
	boolean dropped;
	Vector <Bomb > bombs = new Vector <Bomb >();
	Vector<Rectangle> bricks = new Vector<Rectangle>();
	private int nBombs;
	private int Lives;
	private int moveBomberman =0 ;
	
	public Bomberman() {
		x = 51;
		y = 51;
		nBombs = 1;
		Lives = 3;
	}	

	public void setMoveBomberman(int moveBomberman) {
		this.moveBomberman = moveBomberman;
	}

	public int getMoveBomberman() {
		return moveBomberman;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean getDropped() {
		return dropped;
	}
	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}

	public Vector<Bomb> getBombs() {
		return bombs;
	}
	
	public int getnBombs() {
		return nBombs;
	}

	public void setnBombs(int nBombs) {
		this.nBombs = nBombs;
	}

	private int width = 50;
	private int height = 50;
	Vector<Rectangle> r = new Vector<Rectangle>();
	boolean colide = false;

	public void checkCollisions(Game g, int x1, int y1) {
		Rectangle r3 = new Rectangle(x1, y1, 23, 37);
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;
	
		if(r.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'X'){
						Rectangle rect = new Rectangle(x, y, 50, 50);
						r.add(rect);
					}						
					x += 50;
				}
				y += 50;
			}
		}
		
		if(bricks.size() == 0){
			y=0;
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'o') {
						Rectangle rect = new Rectangle(x, y, 50, 50);
						bricks.add(rect);
					}
					x += 50;
				}
				y += 50;
			}
		}

		for(int i =0; i < r.size();i++){

			if(r3.intersects(r.get(i))) {
				colide = true;
			}
		}
	
		for(int i =0; i < bricks.size();i++)
			if (r3.intersects(bricks.get(i))) 
				colide = true;
	
	}
	
	public void clearBricks(int x, int y){
		for(int i = 0; i < bricks.size(); i++){
			if(bricks.get(i).getX() == x && bricks.get(i).getY() == y){
				bricks.remove(i);
			}
		}
	}

	public void move(Game g) {
		checkCollisions(g, (this.x + dx), (this.y + dy));
		if(colide == false){
			x += dx;
			y += dy;
		}
		else{
			colide = false;
		}
	}

	int count = 0;

	public void keyPressed(KeyEvent e, Game g) {
		moveBomberman = 0;
		int key = e.getKeyCode();

		if(key == KeyEvent.KEY_RELEASED) 
			moveBomberman =0;
		
		if (key == KeyEvent.VK_LEFT) {
			dx = -1;
			moveBomberman = 3;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 1;
			moveBomberman = 1;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -1;
			moveBomberman = 4;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 1;
			moveBomberman =2;
		}
		
		
		//System.out.println(moveBomberman);

		if(key == KeyEvent.VK_SPACE){			
			
			if(nBombs > bombs.size()){
				Bomb bomb = new Bomb();
				bomb.setX(this.x);
				bomb.setY(this.y);
				bomb.setBounds(x, y);
				
				bombs.add(bomb);
				bomb.dropBomb();
				
				dropped = true;
				
				bomb.explosion();
				
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
			
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		
		moveBomberman =0;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);

	}
}

