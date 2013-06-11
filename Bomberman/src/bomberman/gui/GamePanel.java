package bomberman.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.Random;

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

	Image wall, brick, floor, monster, gameover,bomberman,statebar, bomb,explosion1,explosion2,explosion3,explosion4,explosion5, explosion6, explosion7;
	Timer timer;
	private Bomberman craft;
	private Monster monster1;
	boolean brickDestroyed;
	Image[] bombermanLeft = new Image[3];
	Image[] bombermanRight= new Image[3];
	Image[] bombermanUp = new Image[3];
	Image[] bombermanDown = new Image[3];
	Image[] bomb_a = new Image[3];
	Image[] monster_a = new Image[4];
	Image[] powerup = new Image[6];

	
	int time=60000;
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		this.setFocusable(true);
		this.requestFocusInWindow();
		craft = new Bomberman();
		//monster1 = new Monster(game.getZ().getMapa());
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

		temp = new ImageIcon("pwbomb.png");
		tp = temp.getImage();
		powerup[0]= tp;
		temp = new ImageIcon("pwlife.png");
		tp = temp.getImage();
		powerup[1]= tp;
		temp = new ImageIcon("range.png");
		tp = temp.getImage();
		powerup[2]= tp;
		temp = new ImageIcon("pwspeed.png");
		tp = temp.getImage();
		powerup[3]= tp;
		temp = new ImageIcon("pwvest.png");
		tp = temp.getImage();
		powerup[4]= tp;
		temp = new ImageIcon("Pwwall.png");
		tp = temp.getImage();
		powerup[5]= tp;
		
		
		ImageIcon i1 = new ImageIcon("wall.jpg");
		ImageIcon i2 = new ImageIcon("floor.jpg");
		ImageIcon i3 = new ImageIcon("brick.jpg");
		ImageIcon i4 = new ImageIcon("Monster.png");
		ImageIcon i5 = new ImageIcon("testbomb.png");
		ImageIcon i6 = new ImageIcon("bomb2.jpg");
		ImageIcon i7 = new ImageIcon("explosion1.png");
		ImageIcon i8 = new ImageIcon("explosion2.png");
		ImageIcon i9 = new ImageIcon("explosion3.png");
		ImageIcon i10 = new ImageIcon("explosion4.png");
		ImageIcon i11 = new ImageIcon("explosion5.png");
		ImageIcon i12 = new ImageIcon("explosion6.png");
		ImageIcon i13 = new ImageIcon("explosion7.png");
		ImageIcon i14 = new ImageIcon("statebar.png");
		ImageIcon i15 = new ImageIcon("game_over.png");
		gameover = i15.getImage();
		statebar = i14.getImage();
		wall = i1.getImage();
		floor = i2.getImage();
		brick = i3.getImage();
		monster = i4.getImage();
		bomberman = i5.getImage();
		bomb = i6.getImage();
		explosion1 = i7.getImage();
		explosion2 = i8.getImage();
		explosion3 = i9.getImage();
		explosion4 = i10.getImage();
		explosion5 = i11.getImage();
		explosion6 = i12.getImage();
		explosion7 = i13.getImage();
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
		brickDestroyed = false;

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

		if(craft.getDropped() == true){
			for(int i = 0; i < craft.getBombs().size(); i++){
				craft.getBombs().get(i).createNotWall(game);
				craft.getBombs().get(i).createBricks(game);
				
				if(craft.getBombs().get(i).isExplode()== true){
					
					for(int j = 0; j < craft.getBombs().get(i).getBombRect().size(); j++){
						for(int k = 0; k < craft.getBombs().get(i).getNotWallRect().size(); k++){
							if(craft.getBombs().get(i).getBombRect().get(j).intersects(craft.getBombs().get(i).getNotWallRect().get(k))){
								g2d.drawImage(explosion5, (int)(craft.getBombs().get(i).getBombRect().get(j).getX()/50)*50, (int)(craft.getBombs().get(i).getBombRect().get(j).getY()/50)*50, this);
							}
						}
						
						for(int k = 0; k < craft.getBombs().get(i).getBricksRect().size(); k++){
							if(craft.getBombs().get(i).getBombRect().get(j).intersects(craft.getBombs().get(i).getBricksRect().get(k))){
								mapa[(int)(craft.getBombs().get(i).getBombRect().get(j).getY()/50)][(int)(craft.getBombs().get(i).getBombRect().get(j).getX()/50)] = ' ';
							}
						}
					}
				}
				
				if(craft.getBombs().get(i).isExplode()== false){
					g2d.drawImage(bomb_a[drawBomb], (craft.getBombs().get(i).getX()/50)*50,(craft.getBombs().get(i).getY()/50)*50,this);
					drawBomb++;
					if(drawBomb == 3)
						drawBomb =0;
				}

				if(craft.getBombs().get(i).getDropped() == false){
					craft.getBombs().remove(i);
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

		for(int i=0;i < game.getMonstrinhos().size();i++){
			g2d.drawImage(monster_a[drawMonster], game.getMonstrinhos().get(i).getX(), game.getMonstrinhos().get(i).getY(),this);
			
		}
		drawMonster++;
		if(drawMonster == 4)
		drawMonster=0;
		
		g2d.drawImage(statebar, 0,550,this);
		AttributedString attributedString = new AttributedString(""+craft.getLives());
        attributedString.addAttribute(TextAttribute.FOREGROUND, Color.RED, 0, 1/*stringlenght*/);
        attributedString.addAttribute(TextAttribute.SIZE, 30, 0, 1);
        g2d.drawString(attributedString.getIterator(), 125, 603);
       
        if(time > 10000){
        AttributedString attributedString2 = new AttributedString(""+time/1000);
        attributedString2.addAttribute(TextAttribute.FOREGROUND, Color.YELLOW, 0, 2/*stringlenght*/);
        attributedString2.addAttribute(TextAttribute.SIZE, 30, 0, 2);
        g2d.drawString(attributedString2.getIterator(), 400, 603);
        }
		
        if(time < 10000){
            AttributedString attributedString2 = new AttributedString(""+time/1000);
            attributedString2.addAttribute(TextAttribute.FOREGROUND, Color.YELLOW, 0, 1/*stringlenght*/);
            attributedString2.addAttribute(TextAttribute.SIZE, 30, 0, 1);
            g2d.drawString(attributedString2.getIterator(), 400, 603);
            }
        
        if(game_over== true){
        	g2d.drawImage(gameover, 100, 100, this);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        	
	}


	boolean game_over = false;
	
	public void actionPerformed(ActionEvent e) {
		craft.move(game);
		
		
		for(int i =0; i< game.getMonstrinhos().size();i++)
			game.getMonstrinhos().get(i).moveMonster(game);
		//craft.setMoveBomberman(0);
		
//		if(time % 1000 == 0)
//			System.out.println(time/1000);
		time -= 5;
		if(time == 0){
			craft.setLives(craft.getLives()-1);
			time = 60000;
		}
		
		if(craft.getLives() == 0)
			game_over = true;
		
		if(craft.isAlive() == false){
			craft.setAlive(true);
			game.getZ().clearMap();
			game.getZ().randomize();
			
			for(int i =0;i < game.getMonstrinhos().size();i++)
				game.getMonstrinhos().get(i).randomizePositions(game.getZ().getMapa());
		}
		
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