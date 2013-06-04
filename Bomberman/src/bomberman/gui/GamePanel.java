package bomberman.gui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JPanel;
import bomberman.logic.Game;

public class GamePanel extends JPanel implements ActionListener {
	Game game = new Game();
	Image wall, brick, floor, monster, bomberman, bomb;
	Timer timer;
	private int B_WIDTH;
	private int B_HEIGHT;
	private int width;
	private int height;
	private bomberman craft;
	private monster monster1;
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		this.setFocusable(true);
		this.requestFocusInWindow();
		craft = new bomberman();
		addKeyListener(new TAdapter());
		setDoubleBuffered(true);

		ImageIcon i1 = new ImageIcon("wall.jpg");

		ImageIcon i2 = new ImageIcon("floor.jpg");
		ImageIcon i3 = new ImageIcon("brick.jpg");
		ImageIcon i4 = new ImageIcon("Monster.png");
		ImageIcon i5 = new ImageIcon("testbomb.png");
		ImageIcon i6 = new ImageIcon("bomb2.jpg");
		wall = i1.getImage();
		floor = i2.getImage();
		brick = i3.getImage();
		monster = i4.getImage();
		bomberman = i5.getImage();
		bomb = i6.getImage();

		width = wall.getWidth(null);
		height = wall.getHeight(null);

		timer = new Timer(5, this);
		timer.start();

	}

	public void addNotify() {
		super.addNotify();
		B_WIDTH = getWidth();
		B_HEIGHT = getHeight();   
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;


		int x = 0, y = 0;
		char mapa[][] = game.getZ().getMapa();
		for (int i = 0; i < mapa.length; i++) {
			x = 0;
			for (int k = 0; k < mapa.length; k++) {
				if (mapa[i][k] == 'X'){
					g2d.drawImage(wall, x, y, null);
				}

				if (mapa[i][k] == 'b')
					g2d.drawImage(bomberman, x, y, null);
				if (mapa[i][k] == ' ')
					g2d.drawImage(floor, x, y, null);
				if (mapa[i][k] == 'M')
					g2d.drawImage(monster, x, y, null);

				if (mapa[i][k] == 'f')
					g2d.drawImage(bomb, x, y, null);

				if (mapa[i][k] == 'e')
					g2d.drawImage(bomb, x, y, null);
				x += 50;
			}
			y += 50;
		}



		g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
		g2d.drawImage(monster1.getImage(),monster1.getX(), monster1.getY(),this);
		//Toolkit.getDefaultToolkit().sync();
		//   g.dispose();
	}



	public void actionPerformed(ActionEvent e) {
	//	game.getM().moveMonster(game.getZ().getMapa());
		craft.move(game);
		printmap();
		repaint();
	}



	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
	}




	void printmap() {
		for (int i = 0; i < game.getZ().getLength(); i++) {
			System.out.println(game.getZ().getMapa()[i]);
		}
	}


}
/*  public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}*/