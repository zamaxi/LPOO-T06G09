package bomberman.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.ImageIcon;
import javax.swing.Timer;

import javax.swing.JPanel;

import bomberman.logic.Game;





public class GamePanel extends JPanel implements ActionListener{

	Game game = new Game();
	Image wall,brick,floor,monster;
	Timer timer;
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
		ImageIcon i4 = new ImageIcon("Monster.png");

		wall = i1.getImage();
		floor = i2.getImage();
		brick = i3.getImage();
		monster = i4.getImage();

		timer = new Timer(200,this);
		timer.start();
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

				if (mapa[i][k] == 'M') 
					g2d.drawImage(monster, x, y, null);

				x += 50;
			}
			y += 50;
		}
	}

	public void keyPressed(KeyEvent e)  {
		Game.initializeObjects();

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Game.gameLogic('a');
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Game.gameLogic('d');
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			Game.gameLogic('w');
		}


		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Game.gameLogic('s');
		}

		repaint();
	}





	public void keyReleased(KeyEvent e) {

	}


	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		game.getM().moveMonster(game.getZ().getMapa());
		printmap();
		repaint(); 	
	}


	void printmap(){
		for(int i = 0; i < game.getZ().getLength(); i++){
			System.out.println(game.getZ().getMapa()[i]);
		}

	}

}


