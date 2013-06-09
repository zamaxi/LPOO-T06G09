package bomberman.gui;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;




import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;


public class Menu extends JFrame {

	JFrame aux;
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
		aux = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		//final GamePanel gm = new GamePanel();


		JButton btnSair = new JButton("Exit");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		

		JButton btnNovoJogo = new JButton("New Game");
		btnNovoJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				contentPane.setVisible(false);
				GameFrame jogo = new GameFrame();
				jogo.setVisible(true);
			}
		});
		btnNovoJogo.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		

		JButton btnCarregarJogo = new JButton("Load Game");
		btnCarregarJogo.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 11));
		
		
		JButton btnInstrues = new JButton("Instructions");
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
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnInstrues, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnNovoJogo, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(btnCarregarJogo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(129))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(45)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNovoJogo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCarregarJogo, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
					.addGap(26)
					.addComponent(btnInstrues, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(57)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
