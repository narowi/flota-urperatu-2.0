package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Proba {
	static Integer[] koordenatuak = new Integer[2];
	static boolean listo = false;
	private JPanel contentPane;
	private JPanel tableroa;
	private JPanel menua;
	private JButton[][] botoiak = new JButton[10][10];
	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu, menu_1;
	private JMenuItem menuItem_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proba window = new Proba();
					listo = false;
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
		frame.setBounds(300, 50, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Flota urperatu 2.0");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Proba.class.getResource("/argaziak/logo2.jpg")));
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menu = new JMenu("Archivo");
		menuBar.add(menu);
		
		menu_1 = new JMenu("Options");
		menu.add(menu_1);
		menuItem_1 = new JMenuItem("Cerrar");
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		menu_1.add(menuItem_1);
		
		this.contentPane = new JPanel(new BorderLayout());
		this.contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		frame.setContentPane(contentPane);
		
		this.tableroa = new JPanel(new GridLayout(10, 10));
		botoiakJarri();
		this.contentPane.add(tableroa,BorderLayout.CENTER);

		
	}

	private void botoiakJarri() {
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				botoiak[i][j] = new JButton();
				//botoiak[i][j].setText("("+ i + "," + j + ")");
				botoiak[i][j].setIcon(new ImageIcon(this.getClass().getResource("/argaziak/ura.jpg")));
				botoiak[i][j].setBackground(new Color(0,255,255));
				
		//AQUI LE METO AL BOTON QUE BUSQUE SUS KOORDENADAS Y RONPO EL WHILE CON LISTO
				
				botoiak[i][j].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<10;i++){
							for(int j=0;j<10;j++){
								if (e.getSource().equals(botoiak[i][j])){
									koordenatuak[0]= i;
									koordenatuak[1]= j;
									listo = true;
									frame.dispose();
								}
							}
						}
					}
				});
				tableroa.add(botoiak[i][j], BorderLayout.CENTER);
			}
		}
		
	}
	
//ESTE METODO PLS MIRADLO
	public static Integer[] koordenatuakItzuli(){
		main(null);
		while(!listo){
			System.out.println("2.-"+listo);
		}
		return koordenatuak;
	}

}
