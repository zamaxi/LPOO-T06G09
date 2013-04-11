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

	private static JPanel contentPane;
	private JPanel jogo;
	JFrame aux;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					
					 
					frame.setName("Megaman vs Shrek");
					frame.setVisible(true);
				
					frame.setContentPane(contentPane);
					
				
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
		setBounds(100, 100, 500, 500);
		GamePanel gm = new GamePanel();
		this.add(gm);
		
	
	}
}