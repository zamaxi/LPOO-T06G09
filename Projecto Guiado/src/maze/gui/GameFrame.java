package maze.gui;

import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import maze.logic.Hero;
import maze.logic.Map;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JTextField;

public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Map.add();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
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
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSair = new JButton("Sair");
		
		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			
			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addComponent(btnNovoJogo, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(129))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(65))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNovoJogo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		contentPane.setLayout(gl_contentPane);
		
		
	//	int dialogButton = JOptionPane.YES_NO_OPTION;
		//JOptionPane.showConfirmDialog(null,"Deseja Começar um jogo novo?");
		//dialogButton  = JOptionPane.showConfirmDialog (null, "Quer começar um novo jogo?","MegaMan vs Shrek: Ultimate Challenge",dialogButton);
		
		/*if(dialogButton == JOptionPane.YES_OPTION){
			
			
			}*/
		
		
	//*	else{
			
		
		
	}
}
