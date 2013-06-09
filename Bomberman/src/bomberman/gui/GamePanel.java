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

public class GamePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game game = new Game();

	Image wall, brick, floor, monster, bomberman, bomb,explosion;
	Timer timer;
	private Bomberman craft;
	private Monster monster1;
	Image[] bombermanLeft = new Image[3];
	Image[] bombermanRight= new Image[3];
	Image[] bombermanUp = new Image[3];
	Image[] bombermanDown = new Image[3];
	Image[] bomb_a = new Image[3];
	Image[] monster_a = new Image[4];
	
	
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
		ImageIcon temp;
		Image tp;
		
		temp = new ImageIcon("bomberman_right1.png");
		tp = temp.getImage();
		bombermanLeft[0]= tp;
		temp = new ImageIcon("bomberman_right2.png");
		tp = temp.getImage();
		bombermanLeft[1]= tp;
		temp = new ImageIcon("bomberman_right3.png");
		tp = temp.getImage();
		bombermanLeft[2]= tp;
		
		temp = new ImageIcon("bomberman_left1.png");
		tp = temp.getImage();
		bombermanRight[0]= tp;
		temp = new ImageIcon("bomberman_left2.png");
		tp = temp.getImage();
		bombermanRight[1]= tp;
		temp = new ImageIcon("bomberman_left3.png");
		tp = temp.getImage();
		bombermanRight[2]= tp;
		
		temp = new ImageIcon("bomberman_up1.png");
		tp = temp.getImage();
		bombermanUp[0]= tp;
		temp = new ImageIcon("bomberman_up2.png");
		tp = temp.getImage();
		bombermanUp[1]= tp;
		temp = new ImageIcon("bomberman_up3.png");
		tp = temp.getImage();
		bombermanUp[2]= tp;
		
		temp = new ImageIcon("bomberman_down1.png");
		tp = temp.getImage();
		bombermanDown[0]= tp;
		temp = new ImageIcon("bomberman_down2.png");
		tp = temp.getImage();
		bombermanDown[1]= tp;
		temp = new ImageIcon("bomberman_down3.png");
		tp = temp.getImage();
		bombermanDown[2]= tp;
		
		temp = new ImageIcon("bomb1.png");
		tp = temp.getImage();
		bomb_a[0]= tp;
		temp = new ImageIcon("bomb2.png");
		tp = temp.getImage();
		bomb_a[1]= tp;
		temp = new ImageIcon("bomb3.png");
		tp = temp.getImage();
		bomb_a[2]= tp;
		
		
		temp = new ImageIcon("monster1.png");
		tp = temp.getImage();
		monster_a[0]= tp;
		temp = new ImageIcon("monster2.png");
		tp = temp.getImage();
		monster_a[1]= tp;
		temp = new ImageIcon("monster3.png");
		tp = temp.getImage();
		monster_a[2]= tp;
		temp = new ImageIcon("monster4.png");
		tp = temp.getImage();
		monster_a[3]= tp;
		
		
		
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


	
	
	
	int draw =0;
	int drawBomb =0;
	int drawMonster =0;
	int lastMovement =0;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		//g.clearRect(arg0, arg1, arg2, arg3)

		int x = 0, y = 0;
		char mapa[][] = game.getZ().getMapa();
		
		
		if(craft.getMoveBomberman() != 0)
			lastMovement = craft.getMoveBomberman();
		
		
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
		
		//g2d.drawImage(bomberman, craft.getX(), craft.getY(), this);
	//	g2d.drawImage(monster, monster1.getX(), monster1.getY(),this);
		
		if(craft.getDropped() == true){
			for(int i = 0; i < craft.getBombs().size(); i++){
				if(craft.getBombs().get(i).getDropped() == false){
					craft.getBombs().remove(i);
				}
					
				
				if(craft.getBombs().get(i).isExplode()== true){
					g2d.drawImage(explosion, (craft.getBombs().get(i).getX()/50)*51-50,(craft.getBombs().get(i).getY()/50)*51-50,this);
				}
				if(craft.getBombs().get(i).isExplode()== false){
					g2d.drawImage(bomb_a[drawBomb], (craft.getBombs().get(i).getX()/50)*51,(craft.getBombs().get(i).getY()/50)*51,this);
					drawBomb++;
					if(drawBomb == 3)
						drawBomb =0;
				}
					
			}
			
			
		}
		if(craft.getMoveBomberman() == 0 && lastMovement == 0)
			g2d.drawImage(bombermanDown[1], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 0 && lastMovement == 1)
			g2d.drawImage(bombermanRight[1], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 0 && lastMovement == 2)
			g2d.drawImage(bombermanDown[1], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 0 && lastMovement == 3)
			g2d.drawImage(bombermanLeft[1], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 0 && lastMovement == 4)
			g2d.drawImage(bombermanUp[1], craft.getX(), craft.getY(), this);
		
		
		
		if(craft.getMoveBomberman() == 1)
			g2d.drawImage(bombermanRight[draw], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 2)
			g2d.drawImage(bombermanDown[draw], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 3)
			g2d.drawImage(bombermanLeft[draw], craft.getX(), craft.getY(), this);
		if(craft.getMoveBomberman() == 4)
			g2d.drawImage(bombermanUp[draw], craft.getX(), craft.getY(), this);
		draw++;
		if(draw == 3)
			draw=0;
		
		
		g2d.drawImage(monster_a[drawMonster], monster1.getX(), monster1.getY(),this);
		drawMonster++;
		if(drawMonster == 4)
			drawMonster=0;
	}



	public void actionPerformed(ActionEvent e) {
		craft.move(game);
		monster1.moveMonster(game);
		//craft.setMoveBomberman(0);
		
		
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