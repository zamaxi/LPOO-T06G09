package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bomb {

	Rectangle bounds;
	Image image;
	int width, height;
	boolean dropped;
	
	public boolean getDropped() {
		return dropped;
	}
	public void setDropped(boolean dropped) {
		this.dropped = dropped;
	}
	public Image getImage() {
		return image;
	}
	public Bomb() {
		ImageIcon ii = new ImageIcon("bomb2.png");
		image = ii.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public void setBounds(int x1,int y1){
		bounds = new Rectangle(x1,y1,width,height);
	}
	
	public Rectangle getBounds(){
		return bounds;}
	

}
