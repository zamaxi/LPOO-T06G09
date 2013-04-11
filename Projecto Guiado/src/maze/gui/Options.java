package maze.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import maze.cli.Interface;
import maze.logic.Map;

public class Options extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Options dialog = new Options();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Options() {
		setBounds(100, 100, 500, 500);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						setVisible(false);
					}
				});
				
				JButton btnOk = new JButton("OK");
				btnOk.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(btnOk);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblTamanhoDoLabirinto = new JLabel("Tamanho do Labirinto (>9)");
		
		JSpinner spinner = new JSpinner();
		Map.mapSize = (int) spinner.getValue();
		
		
		JLabel lblNumeroDeDragoes = new JLabel("Numero de Shreks");
		
		JSpinner spinner_1 = new JSpinner();
		
		Interface.setN_dragoes((int) spinner_1.getValue());
		System.out.println(spinner_1.getValue());
		
		JRadioButton rdbtnDragoParado = new JRadioButton("Shrek parado");
		buttonGroup_1.add(rdbtnDragoParado);
		
		JRadioButton rdbtnShrekEmMovimento = new JRadioButton("Shrek em movimento aleat\u00F3rio");
		buttonGroup_1.add(rdbtnShrekEmMovimento);
		
		JRadioButton rdbtnShrekEmMovimento_1 = new JRadioButton("Shrek em Movimento Aleat\u00F3rio intercalado com dormir");
		buttonGroup_1.add(rdbtnShrekEmMovimento_1);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnShrekEmMovimento_1)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(rdbtnShrekEmMovimento)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rdbtnDragoParado)
									.addContainerGap())
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTamanhoDoLabirinto)
										.addComponent(lblNumeroDeDragoes))
									.addGap(211)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(spinner_1)
										.addComponent(spinner, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
									.addContainerGap())))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(contentPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTamanhoDoLabirinto)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeDragoes)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(rdbtnDragoParado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnShrekEmMovimento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnShrekEmMovimento_1)
					.addGap(50)
					.addComponent(buttonPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
