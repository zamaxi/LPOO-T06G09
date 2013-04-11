package maze.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.logic.Hero;
import maze.logic.Map;

public class GamePanel extends JPanel implements KeyListener {



	Image wall, hero, dragon, sword, red_hero, eagle,sleep;

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		Map.add();
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		addKeyListener(this);
		ImageIcon i1 = new ImageIcon("wall.png");
		ImageIcon i2 = new ImageIcon("dragon.png");
		ImageIcon i3 = new ImageIcon("sword.png");
		ImageIcon i4 = new ImageIcon("megaman.png");
		ImageIcon i5 = new ImageIcon("red_megaman.jpg");
		ImageIcon i6 = new ImageIcon("eagle.png");
		ImageIcon i7 = new ImageIcon("sleep.png");
		
		wall = i1.getImage();
		dragon = i2.getImage();
		sword = i3.getImage();
		hero = i4.getImage();
		red_hero = i5.getImage();
		eagle = i6.getImage();
		sleep = i7.getImage();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);



		Graphics2D g2d = (Graphics2D) g;

		int x = 0, y = 0;

		// g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);

		for (int i = 0; i < Map.mapa.length; i++) {
			x = 0;
			for (int k = 0; k < Map.mapa.length; k++) {

				if (Map.mapa[i][k] == 'X')
					g2d.drawImage(wall, x, y, null);

				if (Map.mapa[i][k] == 'E')
					g2d.drawImage(sword, x, y, null);

				if (Map.mapa[i][k] == 'D')
					g2d.drawImage(dragon, x, y, null);

				if (Map.mapa[i][k] == 'H') 
					g2d.drawImage(hero, x, y, null);

				if (Map.mapa[i][k] == 'A') 
					g2d.drawImage(red_hero, x, y, null);

				if (Map.mapa[i][k] == 'V') 
					g2d.drawImage(eagle, x, y, null);
				
				if (Map.mapa[i][k] == 'd') 
					g2d.drawImage(sleep, x, y, null);

				x += 30;
			}
			y += 30;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)  {
		//int key = e.getKeyCode();

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Map.game_logic('a');
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//return 'd';
			Map.game_logic('d');
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			//return 'w';
			Map.game_logic('w');
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Map.game_logic('s');
			}

		if (e.getKeyCode() == KeyEvent.VK_Q) 
			Map.game_logic('q');

		if(Hero.isAlive()== false){
			JOptionPane.showMessageDialog(null, "Morreu!");
			//dispose();
			System.exit(0); 
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

/*
class TAdapter extends KeyAdapter {

	public void keyReleased(KeyEvent e) {
		keyReleased(e);

	}

	public void keyPressed(KeyEvent e) {
		keyPressed(e);
	}
}*/