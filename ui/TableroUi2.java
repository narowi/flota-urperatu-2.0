package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TableroUi2 {
	private JButton[][] tablero= null;
	private JPanel contentPane,botoiak;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroUi2 window = new TableroUi2();
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
	public TableroUi2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setBounds(100, 100, 500, 500);
		frame.setContentPane(contentPane);
		botoiak = new JPanel(new GridLayout(10,10));
		botoiak.setBounds(100, 100, 500, 500);
		botoiakJarri();
		contentPane.add(botoiak);
		frame.pack();
	}
	
	private void botoiakJarri(){
		tablero = new JButton[10][10];
		for ( int i=0; i<10; i++){
			for ( int j=0; j<10; j++){
				tablero[i][j] = new JButton();
				tablero[i][j].setText("("+ i + "," + j + ")");
				botoiak.add(tablero[i][j]);
				tablero[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
					}
				});
				tablero[i][j].setBounds(10, 10, 10, 10);
				
			}
		}
		
	}
	
}
