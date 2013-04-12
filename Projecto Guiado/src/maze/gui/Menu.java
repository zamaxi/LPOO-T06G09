package maze.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import maze.logic.Map;

public class Menu extends JFrame {

	private JPanel contentPane;
	JFrame aux;
	public static boolean create = false;
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
			aux = this;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			//final GamePanel gm = new GamePanel();
			
			
			JButton btnSair = new JButton("Sair");
			btnSair.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					setVisible(false);
					System.exit(0);
					create = true;
					Map.CreateMap(Map.mapSize);
				}
			});
			
			JButton btnNovoJogo = new JButton("Novo Jogo");
			btnNovoJogo.addMouseListener(new MouseAdapter() {
				
				
				@Override
				public void mouseClicked(MouseEvent e) {
					contentPane.setVisible(false);
					aux.setVisible(false);
					GameFrame jogo = new GameFrame();
					
					
					jogo.setVisible(true);
				}
			});
			
			JButton btnNewButton = new JButton("Op\u00E7\u00F5es");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Options n = new Options();
					n.setVisible(true);
				}
			});
			
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(52)
						.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
						.addGap(65))
					.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
						.addGap(107)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
							.addComponent(btnNovoJogo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
						.addGap(129))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(29)
						.addComponent(btnNovoJogo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGap(53))
			);
			contentPane.setLayout(gl_contentPane);
			
		/*	this.add(gm);
			int dialogButton = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null,"Deseja Começar um jogo novo?");
			dialogButton  = JOptionPane.showConfirmDialog (null, "Quer começar um novo jogo?","MegaMan vs Shrek: Ultimate Challenge",dialogButton);
			
			if(dialogButton == JOptionPane.YES_OPTION){
				
				
				}
			
			
			else{*/
			
			
			
			}

}
