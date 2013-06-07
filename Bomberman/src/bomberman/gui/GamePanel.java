package bomberman.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JPanel;

import bomberman.logic.Bomberman;
import bomberman.logic.Game;
import bomberman.logic.Monster;

public class GamePanel extends JPanel implements ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game game = new Game();
	private Thread animator;
	 private final int DELAY = 50;
	Image wall, brick, floor, monster, bomberman, bomb,explosion;
	Timer timer;
	private Bomberman craft;
	private Monster monster1;
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		this.setFocusable(true);
		this.requestFocusInWindow();
		craft = new Bomberman();
		monster1 = new Monster(game.getZ().getMapa());
		addKeyListener(new TAdapter());
		setDoubleBuffered(true);

		ImageIcon i1 = new ImageIcon("wall.jpg");

		ImageIcon i2 = new ImageIcon("floor.jpg");
		ImageIcon i3 = new ImageIcon("brick.jpg");
		ImageIcon i4 = new ImageIcon("Monster.png");
		ImageIcon i5 = new ImageIcon("testbomb.png");
		ImageIcon i6 = new ImageIcon("bomb2.jpg");
		ImageIcon i7 = new ImageIcon("explosion.png");
		wall = i1.getImage();
		floor = i2.getImage();
		brick = i3.getImage();
		monster = i4.getImage();
		bomberman = i5.getImage();
		bomb = i6.getImage();
		explosion = i7.getImage();
		timer = new Timer(5, this);
		timer.start();

	}

	
	 public void addNotify() {
	        super.addNotify();
	        animator = new Thread(this);
	        animator.start();
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
				if (mapa[i][k] == 'o')
					g2d.drawImage(brick, x, y, null);
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
		
		g2d.drawImage(bomberman, craft.getX(), craft.getY(), this);
		g2d.drawImage(monster, monster1.getX(), monster1.getY(),this);
		
		if(craft.getDropped() == true){
			for(int i = 0; i < craft.getBombs().size(); i++){
				if(craft.getBombs().get(i).getDropped() == false){
					craft.getBombs().remove(i);
				}
					
				
				if(craft.getBombs().get(i).isExplode()== true){
					g2d.drawImage(explosion, (craft.getBombs().get(i).getX()/50)*51-50,(craft.getBombs().get(i).getY()/50)*51-50,this);
				}
				if(craft.getBombs().get(i).isExplode()== false)
					g2d.drawImage(bomb, (craft.getBombs().get(i).getX()/50)*51,(craft.getBombs().get(i).getY()/50)*51,this);
			}
			
			
		}
		
		g2d.drawImage(bomberman, craft.getX(), craft.getY(), this);
		g2d.drawImage(monster, monster1.getX(), monster1.getY(),this);
	}



	public void actionPerformed(ActionEvent e) {
		craft.move(game);
		monster1.moveMonster(game);
		repaint();
	}



	private class TAdapter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e, game);
		}
	}




	void printmap() {
		for (int i = 0; i < game.getZ().getLength(); i++) {
			System.out.println(game.getZ().getMapa()[i]);
		}
	}


}