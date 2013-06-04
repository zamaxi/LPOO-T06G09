package bomberman.gui;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class monster {

	private Image image;
	int x=0,y=0;
	int width, height;
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

	public monster(){
		ImageIcon ii = new ImageIcon("Monster.png");
		image = ii.getImage();
		Random randomGenerator = new Random();
	//	x = randomGenerator.nextInt(args.length -1)+1;
	//	y = randomGenerator.nextInt(args.length  -1)+1;
		x = 200;
		y = 200;
		width = image.getWidth(null);
		height = image.getHeight(null);
		
		
	}

	public Image getImage() {
		return image;
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
}
