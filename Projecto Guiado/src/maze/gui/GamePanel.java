package maze.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import maze.cli.Interface;
import maze.logic.Hero;
import maze.logic.Map;

public class GamePanel extends JPanel implements KeyListener {

	public void saveGame() throws FileNotFoundException, IOException {
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("save.dat"));

		for (int i = 0; i <= Map.getMapa().length - 1; i++) {
			for (int j = 0; j <= Map.getMapa().length - 1; j++) {
				if (Map.mapa[i][j] != 'X' && Map.mapa[i][j] != 'S') {
					Map.mapa[i][j] = ' ';
				}

			}
		}

		os.writeObject(Map.mapa);
		os.writeObject(Map.getH());
		os.writeObject(Map.getV());
		System.out.print(Map.getV());
		os.writeObject(Map.getE());
		os.writeObject(Map.getZ());
		os.writeObject(Map.getMapSize());
	}



	Image wall, hero, dragon, sword, red_hero, eagle, sleep, exit, thef, floor;

	/**
	 * 
	 * @author Gabriel Borges, Marco Pinto
	 * Faz o load de todas as imagens usadas na parte grafica do jog e guardas em objetos Image
	 */
	 
	public GamePanel() {

		Map.drawDragon(Interface.getN_dragoes());
		this.setFocusable(true);
		this.requestFocusInWindow();

		addKeyListener(this);
		ImageIcon i1 = new ImageIcon("wall.png");
		ImageIcon i2 = new ImageIcon("dragon.png");
		ImageIcon i3 = new ImageIcon("sword.png");
		ImageIcon i4 = new ImageIcon("megaman.png");
		ImageIcon i5 = new ImageIcon("red_megaman.png");
		ImageIcon i6 = new ImageIcon("eagle.png");
		ImageIcon i7 = new ImageIcon("sleep.png");
		ImageIcon i8 = new ImageIcon("rainbow.png");
		ImageIcon i9 = new ImageIcon("shark.png");
		ImageIcon i10 = new ImageIcon("floor.png");

		wall = i1.getImage();
		dragon = i2.getImage();
		sword = i3.getImage();
		hero = i4.getImage();
		red_hero = i5.getImage();
		eagle = i6.getImage();
		sleep = i7.getImage();
		exit = i8.getImage();
		thef = i9.getImage();
		floor = i10.getImage();
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

				if (Map.mapa[i][k] == 'S') 
					g2d.drawImage(exit, x, y, null);
				
				if (Map.mapa[i][k] == 'F') 
					g2d.drawImage(thef, x, y, null);
				
				if (Map.mapa[i][k] == ' ') 
					g2d.drawImage(floor, x, y, null);

				x += 30;
			}
			y += 30;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)  {

		int verify =0;
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			verify = Map.game_logic('a');

			if(verify == 1){
				JOptionPane.showMessageDialog(null, "Venceste!");
				System.exit(0);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			verify = Map.game_logic('d');

			if(verify == 1){
				JOptionPane.showMessageDialog(null, "Venceste!");
				System.exit(0);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			verify = Map.game_logic('w');

			if(verify == 1){
				JOptionPane.showMessageDialog(null, "Venceste!");
				setVisible(false);
				System.exit(0);
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			verify = Map.game_logic('s');

			if(verify == 1){
				JOptionPane.showMessageDialog(null, "Venceste!");
				setVisible(false);
				System.exit(0);
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_Q) 
			verify = Map.game_logic('q');

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			int resposta;
			resposta = JOptionPane.showConfirmDialog(null, "Deseja Guardar?");
			if (resposta == JOptionPane.YES_OPTION) {
				// verifica se o usuário clicou no botão YES
				try {
					saveGame();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.exit(0);
			} else if (resposta == JOptionPane.NO_OPTION){
				System.exit(0);
			} else{}
			//setVisible(false);


		}

		if(Hero.isAlive()== false){
			JOptionPane.showMessageDialog(null, "Morreu!");


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