package bomberman.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Instructions extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	//Image background;
	/**
	 * Create the dialog.
	 */
	public Instructions() {
		ImageIcon i1 = new ImageIcon("Instructions.png");
		
		setBounds(100, 100, i1.getIconWidth()+15, i1.getIconHeight()+110);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			JLabel thumb = new JLabel();
			thumb.setIcon(i1);
			this.add(thumb);

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				//JButton okButton = new JButton("OK");
		
				/*	try {
				    Image img = ImageIO.read(getClass().getResource("lol.jpg");
				    
				    okButton.setIcon(new ImageIcon(img));
				  } catch (IOException ex) {
				 }*/
				
				ImageIcon water = new ImageIcon("okButton.png");
			    JButton okButton = new JButton(water);
			  //  frame.add(button);
				
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	

}
