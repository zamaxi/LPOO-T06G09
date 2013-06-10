package bomberman.logic;

import java.awt.Rectangle;
import java.util.Vector;

public class Bomb {
	private int x;
	private int y;
	boolean explode;
	int range;
	Vector<Rectangle> bombRect = new Vector<Rectangle>();
	Vector<Rectangle> notWallRect;
	Vector<Rectangle> bricksRect;

	public Vector<Rectangle> getBricksRect() {
		return bricksRect;
	}

	public Vector<Rectangle> getNotWallRect() {
		return notWallRect;
	}

	public Vector<Rectangle> getBombRect() {
		return bombRect;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public boolean isExplode() {
		return explode;
	}

	public void setExplode(boolean explode) {
		this.explode = explode;
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

	Rectangle bounds;
	int width, height;
	boolean dropped;

	public boolean getDropped() {
		return dropped;
	}

	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}
	/**
	 * Construtor da Classe Bomb
	 * Cria uma bomba
	 */
	public Bomb() {
		dropped = true;
		range = 1;
	}

	public void setBounds(int x1,int y1){
		bounds = new Rectangle(x1,y1,width,height);
	}

	public Rectangle getBounds(){
		return bounds;
	}

	public void createRect(int ran) {
		Rectangle r1 = new Rectangle(((this.x/50)*50), ((this.y/50)*50), 50, 50);
		Rectangle r2 = new Rectangle(((this.x/50)*50) - 50, ((this.y/50)*50), 50, 50);
		Rectangle r3 = new Rectangle(((this.x/50)*50) + 50, ((this.y/50)*50), 50, 50);
		Rectangle r4 = new Rectangle(((this.x/50)*50), ((this.y/50)*50) - 50, 50, 50);
		Rectangle r5 = new Rectangle(((this.x/50)*50), ((this.y/50)*50) + 50, 50, 50);
		Rectangle r6 = new Rectangle(((this.x/50)*50) - 100, ((this.y/50)*50), 50, 50);
		Rectangle r7 = new Rectangle(((this.x/50)*50) + 100, ((this.y/50)*50), 50, 50);
		Rectangle r8 = new Rectangle(((this.x/50)*50), ((this.y/50)*50) - 100, 50, 50);
		Rectangle r9 = new Rectangle(((this.x/50)*50), ((this.y/50)*50) + 100, 50, 50);

		if(ran == 1){
			if(bombRect.size() == 0){
				bombRect.add(r1);
				bombRect.add(r2);
				bombRect.add(r3);
				bombRect.add(r4);
				bombRect.add(r5);
			}
		}
		else if(ran == 2){
			if(bombRect.size() == 0){
				bombRect.add(r1);
				bombRect.add(r2);
				bombRect.add(r3);
				bombRect.add(r4);
				bombRect.add(r5);
				bombRect.add(r6);
				bombRect.add(r7);
				bombRect.add(r8);
				bombRect.add(r9);
			}
		}
	}

	public void createNotWall(Game g){
		notWallRect = new Vector<Rectangle>();
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;

		if(notWallRect.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == ' ' || mapa[j][k] == 'o'){
						Rectangle rect = new Rectangle(x, y, 50, 50);
						notWallRect.add(rect);
					}						
					x += 50;
				}
				y += 50;
			}
		}
	}

	public void createBricks(Game g){
		bricksRect = new Vector<Rectangle>();
		char mapa[][] = g.getZ().getMapa();
		int x = 0, y = 0;

		if(bricksRect.size() == 0){
			for (int j = 0; j< mapa.length; j++) {
				x=0;
				for (int k = 0; k < mapa.length; k++) {
					if (mapa[j][k] == 'o'){
						Rectangle rect = new Rectangle(x, y, 50, 50);
						bricksRect.add(rect);
					}						
					x += 50;
				}
				y += 50;
			}
		}
	}

	/**
	 * Deixa uma bomba no mapa durante 2 segundos
	 */
	public void dropBomb(){

		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						dropped = false;
						explode = false;

						//						for(int i = 0; i < bombRect.size(); i++)
						//							bombRect.remove(i);
					}
				},
				2000
				);
	}
	/**
	 * Durante os ultimos 0.5 segundos da bomba presente no mapa, esta explode, eliminado dos os blocos destrutiveis e matando os monstros do mapa
	 */
	public void explosion(){
		//explode = true;
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override 
					public void run() {
						explode = true;
						createRect(range);
					}
				},
				1500
				);
	}
}
