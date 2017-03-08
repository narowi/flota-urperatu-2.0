package ui;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TableroUi extends JPanel implements ActionListener {
	private JButton[][] tablero= null;

	private int nFilaKop = 10;
	private int nZutabeKop = 10;
	
	public TableroUi(){
		try{
			jbInit();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

	private void jbInit() throws Exception {
		//solo como prueba para verificar que funciona el metodo inicializar
		this.setLayout(null);
		this.setBackground(Color.BLUE);
	}
	
	public void hasieratu(){
		tablero = new JButton[nFilaKop][nZutabeKop];
		for ( int i=0; i<nFilaKop; i++){
			for ( int j=0; i<nZutabeKop; j++){
				JButton temp = new JButton();
				//para probar como escribir algo dentro
				temp.setText("("+ i + "," + j + ")");
				
				temp.addActionListener(this);
				//agregar el boton al panel
				this.add(temp);
				//agregar el boton a la colecion de casillas --> tablero
				tablero[i][j]=temp;
			}
		}
	}
	
	public void ordenatu(){
		int zabaleraTot = this.getWidth();
		int luzeraTot = this.getHeight();
		int kasillaZab = zabaleraTot/ nZutabeKop;
		int kasillaLuz = luzeraTot / nFilaKop;
		
		for ( int i=0; i<nFilaKop; i++){
			for ( int j=0; i<nZutabeKop; j++){
				JButton temp = tablero[i][j];
				
				temp.setBounds(j * kasillaZab , i * kasillaLuz, kasillaZab, kasillaLuz);
		
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		//aqui vamos a recibir la notificacion de que alguno de los botones a sido presionado
		
		//verificar que el causante de este evento es de tipo JButton
		if (arg0.getSource() instanceof JButton){
			//obtener referencia al objeto causante
			JButton temp = (JButton) arg0.getSource();
			
			//realizar cambio(adb:para saber que ha colocado el barco)
			temp.setBackground(Color.ORANGE);
		}
		
	}
	

	
}