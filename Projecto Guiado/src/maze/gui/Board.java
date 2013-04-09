package maze.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import maze.logic.Map;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private SpriteH craft;
    Image wall, hero, dragon, sword;
  
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        craft = new SpriteH();

        timer = new Timer(100, this);
        timer.start();
    }

	public char[][] mapa ={{'X','X','X','X','X','X','X','X','X','X'},
			{'X',' ',' ',' ','E',' ',' ',' ',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ',' ',' ',' ',' ','D','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ','X',' ','X',' ','X'},
			{'X',' ','X','X',' ',' ',' ',' ',' ','X'},
			{'X','X','X','X','X','X','X','X','X','X'}};


    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon i1 = new ImageIcon("wall.png");
        ImageIcon i2 = new ImageIcon("dragon.png");
        ImageIcon i3 = new ImageIcon("sword.png");
        wall = i1.getImage();
        dragon = i2.getImage();
        sword = i3.getImage();
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
        int  x=0,y=0;
      
        for(int i= 0; i < mapa.length; i++){
        	x=0;
        	for(int k=0; k <mapa.length; k++){
        		if(mapa[i][k] == 'X')
        		g2d.drawImage(wall, x, y, null);
        		if(mapa[i][k] == 'E')
            		g2d.drawImage(sword, x, y, null);
        		if(mapa[i][k] == 'D')
            		g2d.drawImage(dragon, x, y, null);
        		x+=30;
        	}
        	y+=30;
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
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

}