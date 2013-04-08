package maze.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import maze.logic.Map;


public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Wall craft;

    private Parede parede;
    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        craft = new Wall();

        timer = new Timer(100, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
      //  g2d.drawImage(parede.getImage(), parede.getX(), parede.getY(), this);
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
       
      /*  for(int i= 0; i < 10; i++){
        	for(int k=0; k <10; k++){
        		if(Map.mapa[i][k] == 'X'){
        		//	g2d.drawImage(parede.getImage(), parede.getX(), parede.getY(), this);
        		//	parede.setX(parede.getX()+30);
        		}
        	}
        	//parede.setY(parede.getY()+30);
        }*/

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