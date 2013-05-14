package bomberman.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;

import javax.swing.JPanel;

import bomberman.logic.Game;





public class GamePanel extends JPanel {

	Game game = new Game();
	Image wall,brick,floor;
	/**
	 * Create the panel.
	 */
	
	public GamePanel() {
		
		this.setFocusable(true);
		this.requestFocusInWindow();

	//	addKeyListener((KeyListener) this);
		ImageIcon i1 = new ImageIcon("wall.jpg");
		ImageIcon i2 = new ImageIcon("floor.jpg");
		ImageIcon i3 = new ImageIcon("brick.jpg");
		
		wall = i1.getImage();
		floor = i2.getImage();
		brick = i3.getImage();
		
	}

	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		
		Graphics2D g2d = (Graphics2D) g;

		int x = 0, y = 0;
		
		
		char mapa[][] = game.getZ().getMapa();
		
		for (int i = 0; i < mapa.length; i++) {
			x = 0;
			for (int k = 0; k < mapa.length; k++) {

				if (mapa[i][k] == 'X')
					g2d.drawImage(wall, x, y, null);

				if (mapa[i][k] == 'b')
					g2d.drawImage(brick, x, y, null);

				if (mapa[i][k] == ' ') 
					g2d.drawImage(floor, x, y, null);

				x += 50;
			}
			y += 50;
		}
	}
	
	public void keyPressed(KeyEvent e)  {

		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {


		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {


			}
		

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			}
	
		repaint();
	}


	

	
	public void keyReleased(KeyEvent e) {

	}

	
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}


