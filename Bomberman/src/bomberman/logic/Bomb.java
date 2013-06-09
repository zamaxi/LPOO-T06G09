package bomberman.logic;

import java.awt.Rectangle;

public class Bomb {
	private int x;
	private int y;
	boolean explode;
	int range;
	
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
	
	public void dropBomb(){
		
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override
					public void run() {
						dropped = false;
						explode = false;
					}
				},
				2000
				);
	}
	
	public void explosion(){
		//explode = true;
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override 
					public void run() {
						explode = true;
					}
				},
				1500
				);
	}
}
