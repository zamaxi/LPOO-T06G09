package bomberman.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * 
 * @author Kratos
 *Classe GameFrame
 */
public class GameFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame(null);
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
	public GameFrame(JFrame m) {
		JFrame aux = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 20, 550+15, 550+120);
		GamePanel gm = new GamePanel(m, aux);
		this.add(gm);
	}

}
