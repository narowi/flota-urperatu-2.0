package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;

public class Proba {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proba window = new Proba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Proba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton rdbtnA = new JRadioButton("a");
		rdbtnA.setBounds(8, 9, 64, 25);
		panel.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("b");
		rdbtnB.setBounds(76, 9, 64, 25);
		panel.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("c");
		rdbtnC.setBounds(169, 9, 64, 25);
		panel.add(rdbtnC);
		
		JRadioButton rdbtnD = new JRadioButton("d");
		rdbtnD.setBounds(252, 9, 64, 25);
		panel.add(rdbtnD);
	}
}
