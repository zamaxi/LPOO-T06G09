package maze.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import maze.logic.Dragon;
import maze.logic.Eagle;
import maze.logic.Hero;
import maze.logic.Map;
import maze.logic.Sword;

import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu extends JFrame {

	public static void loadGame() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream is = new ObjectInputStream (new FileInputStream ("save.dat"));
		Map.setMapa((char[][]) is.readObject());
		Map.setH((Hero) is.readObject());
		Map.setV((Vector<Dragon>) is.readObject());
		Map.setE((Sword) is.readObject());
		Map.setZ((Eagle) is.readObject());
		Map.setMapSize((int) is.readObject());
	}

	private JPanel contentPane;
	JFrame aux;
	public static boolean create = false;
	/**
	 *  @author Gabriel Borges, Marco Pinto
	 *  Main metodo da parte grafica do jogo
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
	 * Cria o menu
	 *  @author Gabriel Borges, Marco Pinto
	 *  Cria um menu que permite carregar, come�ar um novo jogo (predefenido ou escolhido pelo utilizador), sair e ler as instrucoes 
	 */
	public Menu() {
		aux = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
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

			}
		});

		JButton btnNovoJogo = new JButton("Novo Jogo");
		btnNovoJogo.addMouseListener(new MouseAdapter() {


			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				aux.setVisible(false);

				if(create == false){
					Map.CreateMap(10);
				}
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

		JButton btnCarregarJogo = new JButton("Carregar Jogo");
		btnCarregarJogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					loadGame();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				contentPane.setVisible(false);
				aux.setVisible(false);
				
				Map.mapa = Map.CreateMap(Map.getMapa(), Map.getH(), Map.getV(), Map.getZ(), Map.getE());
				
				GameFrame jogo = new GameFrame();


				jogo.setVisible(true);
			}
		});
		
		JButton btnInstrues = new JButton("Instru\u00E7\u00F5es");
		btnInstrues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Move o teu her�i com os bot�es de direc��o\nManda a tua f�nix com a tecla 'Q'\nGuarda o jogo com o 'Esc'");
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(53)
					.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addGap(64))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(107)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInstrues, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnCarregarJogo, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnNovoJogo, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
					.addGap(129))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addComponent(btnNovoJogo, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCarregarJogo, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInstrues, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

		/*	this.add(gm);
			int dialogButton = JOptionPane.YES_NO_OPTION;
			JOptionPane.showConfirmDialog(null,"Deseja Come�ar um jogo novo?");
			dialogButton  = JOptionPane.showConfirmDialog (null, "Quer come�ar um novo jogo?","MegaMan vs Shrek: Ultimate Challenge",dialogButton);

			if(dialogButton == JOptionPane.YES_OPTION){


				}


			else{*/



	}
}
