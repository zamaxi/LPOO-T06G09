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

    Image wall, hero, dragon, sword;
    

  
  
    public Board() {

        addKeyListener(new TAdapter());	
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

      

        timer = new Timer(100, this);
        timer.start();
    }




    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon i1 = new ImageIcon("wall.png");
        ImageIcon i2 = new ImageIcon("dragon.png");
        ImageIcon i3 = new ImageIcon("sword.png");
        ImageIcon i4 = new ImageIcon("megaman.png");
        
        wall = i1.getImage();
        dragon = i2.getImage();
        sword = i3.getImage();
        hero = i4.getImage();
        
        Graphics2D g2d = (Graphics2D)g;
        
        int  x=0,y=0;
       
      //  g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
       
        for(int i= 0; i < Map.mapa.length; i++){
        	x=0;
        	for(int k=0; k <Map.mapa.length; k++){
        		
        		if(Map.mapa[i][k] == 'X')
        		g2d.drawImage(wall, x, y, null);
        	
        		if(Map.mapa[i][k] == 'E')
            		g2d.drawImage(sword, x, y, null);
        		
        		if(Map.mapa[i][k] == 'D')
            		g2d.drawImage(dragon, x, y, null);
        		
        		if(Map.mapa[i][k] == 'H'){
        			g2d.drawImage(hero,x,y,null);
        		}
        		x+=30;
        	}
        	y+=30;
        }
       
        //Toolkit.getDefaultToolkit().sync();
      //  g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
       // craft.move();
        repaint();  
    }

    
    public Object keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            
       //     return 'a';
        }

        if (key == KeyEvent.VK_RIGHT) {
            
        //    return 'd';
        }

        if (key == KeyEvent.VK_UP) {
            
         //   return 'w';
        }

        if (key == KeyEvent.VK_DOWN) {
            
          //  return 's';
        }
        return null;
    }

    public char keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
        	return 'a';
        	//Map.game_logic('a');
        }

        if (key == KeyEvent.VK_RIGHT) {
        	return 'd';
        	//Map.game_logic('d');
        }

        if (key == KeyEvent.VK_UP) {
        	return 'w';
        	//Map.game_logic('w');
        }

        if (key == KeyEvent.VK_DOWN) {
        	return 's';
        	
        }
        return ' ';
    }




	
}

    class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
           keyReleased(e);
           
        }

        public void keyPressed(KeyEvent e) {
            keyPressed(e);
        }
    }
    

