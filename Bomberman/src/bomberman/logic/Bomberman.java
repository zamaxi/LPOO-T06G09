package bomberman.logic;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	boolean speedUp = false;
	boolean Alive = true;
	boolean exit = false;
	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}

	public boolean isAlive() {
		return Alive;
	}

	public void setAlive(boolean alive) {
		Alive = alive;
	}

	Vector <Bomb > bombs = new Vector <Bomb >();
	Vector<Rectangle> bricks;
	Vector<Rectangle> pw;
	private int nBombs;
	private int Lives;
	private int moveBomberman =0 ;

	/**
	 * Construtor da classe bomberman
	 * Este objecto será controlado pelo utilizador e será capaz de largar bombas
	 * de maneira a matar os monstros
	 * @author Gabriel Borges, Marco Pinto
	 */
	public Bomberman() {
		x = 51;
		y = 51;
		nBombs = 1;
		Lives = 3;
	}	

	public int getLives() {
		return Lives;
	}

	public void setLives(int lives) {
		Lives = lives;
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
	public Vector<Rectangle> getR() {
		return r;
	}

	boolean colide = false;
	boolean vestUp = false;
	boolean wallUp = false;

	/**
	 * 
	 * @param g - jogo no qual vai verificar se houve colisoes
	 * @param x1 - corrdenada x que ira criar o Rectangle à volta do objecto para verificar a colisão
	 * @param y1 - corrdenada y que ira criar o Rectangle à volta do objecto para verificar a colisão
	 */
	public void checkCollisions(Game g, int x1, int y1) {
		Rectangle r3 = new Rectangle(x1, y1, 23, 37);
		char mapa[][] = g.getZ().getMapa();
		int x2 = 0, y2 = 0;

		if(r.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x2=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'X'){
						Rectangle rect = new Rectangle(x2, y2, 50, 50);
						r.add(rect);
					}						
					x2 += 50;
				}
				y2 += 50;
			}
		}

		bricks = new Vector<Rectangle>();
		if(bricks.size() == 0){
			y2=0;
			for (int j = 0; j< mapa.length; j++) {
				x2=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'o') {
						Rectangle rect = new Rectangle(x2, y2, 50, 50);
						bricks.add(rect);
					}
					x2 += 50;
				}
				y2 += 50;
			}
		}


		for(int i =0; i < r.size();i++){

			if(r3.intersects(r.get(i))) {
				colide = true;
			}
		}


		if(wallUp == false){
			for(int i =0; i < bricks.size();i++)
				if (r3.intersects(bricks.get(i))) 
					colide = true;
		}

		if(vestUp == false){
			for(int i =0; i < g.getMonstrinhos().size();i++){
				Rectangle rm = new Rectangle(g.getMonstrinhos().get(i).getX(),g.getMonstrinhos().get(i).getY(),23,37);
				if(r3.intersects(rm)){
					Lives--;
					Alive = false;
					x = 51;
					y = 51;
				}
			}
		}

		for (int i = 0; i < bombs.size(); i++) {
			for (int j = 0; j < bombs.get(i).getBombRect().size(); j++) {
	
				if (bombs.get(i).isExplode() == true) {
					if (r3.intersects(bombs.get(i).getBombRect().get(j))) {
						Lives--;
						Alive = false;
						x = 51;
						y = 51;
						System.out.println("DROPOU");
					}
				}
			}
		}

		y2 = 0;
		for (int j = 0; j< mapa.length; j++) {
			x2=0;
			for (int k = 0; k < mapa.length; k++) {
				if (mapa[j][k] == '1'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						nBombs = 2;
						mapa[j][k] = ' ';
					}
				}
				else if(mapa[j][k] == '2'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						Lives++;
						mapa[j][k] = ' ';
					}
				}
				else if(mapa[j][k] == '3'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						Bomb.setRange(2);
						System.out.println(Bomb.getRange());
						mapa[j][k] = ' ';
					}
				}
				else if(mapa[j][k] == '4'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						speedUp = true;
						mapa[j][k] = ' ';
					}
				}
				else if(mapa[j][k] == '5'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						vestUp = true;
						mapa[j][k] = ' ';
					}
				}
				else if(mapa[j][k] == '6'){
					Rectangle pw = new Rectangle(x2, y2, 50, 50);
					if(r3.intersects(pw)){
						wallUp = true;
						mapa[j][k] = ' ';
					}
				}

				x2 += 50;
			}
			y2 += 50;
		}
		
		
		for(int i =0; i < g.getMonstrinhos().size();i++){
			boolean elimina = false;
			
			for(int j =0; j < bombs.size();j++){
				Rectangle rm = new Rectangle(g.getMonstrinhos().get(i).getX(),g.getMonstrinhos().get(i).getY(),23,37);
				
				for(int k =0; k < bombs.get(j).getBombRect().size();k++){
					
					if(rm.intersects(bombs.get(j).getBombRect().get(k))){
						g.getMonstrinhos().remove(i);
						elimina = true;
					}
					if(elimina == true)
						break;
					
				}
				if(elimina == true)
					break;
				
			}
		}

	}

	/**
	 * 
	 * @param x - coordenada x do tijolo destrutivel que sera eliminado do vector
	 * @param y - coordenada y do tijolo destrutivel que sera eliminado do vector
	 */
	public void clearBricks(int x, int y){

		for(int i = 0; i < bricks.size(); i++){
			if(bricks.get(i).getX() == x && bricks.get(i).getY() == y){
				bricks.remove(i);

			}
		}

	}

	/**
	 * Metodo para calcular a probabilidade de aparecer um powerup, caso um bloco seja destruido
	 * 
	 * @return a, inteiro que toma valores 1,2,3,4 ou 5 caso a seja igual a esses numeros, ou 0 caso não
	 */
	public int pwprobability(){
		Random randomGenerator = new Random();
		int a;
		a=	randomGenerator.nextInt(25)+1;

		if(a == 1)
			return a;
		if(a == 2)
			return a;
		if(a == 3)
			return a;
		if(a == 4)
			return a;
		if(a == 5)
			return a;
		else
			return 0;
	}
	/**
	 * Movimenta o bomberman caso não seja detectada nenhuma colisão
	 * @param g jogo
	 * 
	 */
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
	private JFrame frame;

	public void keyPressed(KeyEvent e, Game g) {
		moveBomberman = 0;
		int key = e.getKeyCode();

		if(key == KeyEvent.KEY_RELEASED) 
			moveBomberman =0;

		if (key == KeyEvent.VK_LEFT) {
			if(speedUp == false)
				dx = -1;
			else
				dx = -2;

			moveBomberman = 3;
		}

		if (key == KeyEvent.VK_RIGHT) {
			if(speedUp == false)
				dx = 1;
			else
				dx = 2;

			moveBomberman = 1;
		}

		if (key == KeyEvent.VK_UP) {
			if(speedUp == false)
				dy = -1;
			else
				dy = -2;

			moveBomberman = 4;
		}

		if (key == KeyEvent.VK_DOWN) {
			if(speedUp == false)
				dy = 1;
			else
				dy = 2;

			moveBomberman =2;
		}

		if (key == KeyEvent.VK_ESCAPE) {
			//JOptionPane.showConfirmDialog(frame, arg1)
			int v = JOptionPane.showConfirmDialog(null,
					"Deseja Sair do jogo?",null, JOptionPane.YES_NO_OPTION);
			if(v == 0)
				exit = true;
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

		if (key == KeyEvent.VK_ESCAPE) {

		}
		moveBomberman =0;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);

	}
}

