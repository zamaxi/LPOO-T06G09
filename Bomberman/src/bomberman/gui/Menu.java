package bomberman.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Menu extends JFrame {

	JFrame aux;
	
	ImageIcon ii = new ImageIcon("background.png");
	Image menu = ii.getImage();
	JLabel l = new JLabel();
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		//aux.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 25, 1083, 610);
		
		
		//1083*610

		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.add(l);
		/*ImageIcon imageIcon = new ImageIcon("background.png");
		JLabel thumb = new JLabel();
		thumb.setIcon(imageIcon);
		contentPane.add(thumb);*/
		
		
		
		ImageIcon water = new ImageIcon("Exit.png");
		JButton btnSair = new JButton(water);
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		
		 water = new ImageIcon("newGame.png");
		JButton btnNovoJogo = new JButton(water);
		System.out.println(btnNovoJogo.getHeight());
		System.out.println(btnNovoJogo.getWidth());
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.setVisible(false);
				GameFrame jogo = new GameFrame();
				jogo.setVisible(true);
			}
		});
		btnNovoJogo.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		
		water = new ImageIcon("loadGame.png");
		JButton btnCarregarJogo = new JButton(water);
		btnCarregarJogo.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		
		water = new ImageIcon("Instructionsb.png");
		JButton btnInstrues = new JButton(water);
		btnInstrues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Instructions n = new Instructions();
				n.setVisible(true);
			}
		});
		btnInstrues.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNovoJogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInstrues, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCarregarJogo, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))
					.addContainerGap(742, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(308, Short.MAX_VALUE)
					.addComponent(btnNovoJogo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnInstrues, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCarregarJogo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		l.setSize(new Dimension(1083, 610));
		l.setLocation(0, 0);

		l.setIcon(ii);
		setBackground(new Color(255, 255, 255));
		
		/*	this.add(gm);
			int dialogButton = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null,"Deseja Começar um jogo novo?");
			dialogButton  = JOptionPane.showConfirmDialog (null, "Quer começar um novo jogo?","MegaMan vs Shrek: Ultimate Challenge",dialogButton);

			if(dialogButton == JOptionPane.YES_OPTION){


				}


			else{*/



	}
	
	private JPanel loadingPanel() {
	    JPanel panel = new JPanel();
	    BoxLayout layoutMgr = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
	    panel.setLayout(layoutMgr);

	    ClassLoader cldr = this.getClass().getClassLoader();
	    ImageIcon imageIcon = new ImageIcon("background.gif");
	    JLabel iconLabel = new JLabel();
	    iconLabel.setIcon(imageIcon);
	    imageIcon.setImageObserver(iconLabel);

	    JLabel label = new JLabel("Loading...");
	    panel.add(iconLabel);
	    panel.add(label);
	    return panel;
	}
	
	public void SetPane(final JFrame f, final JPanel j){
		//explode = true;
		new java.util.Timer().schedule( 
				new java.util.TimerTask() {
					@Override 
					public void run() {
						f.setContentPane(j);
					}
				},
				1500
				);
	}
	    
}
