package sprint1;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class main extends JFrame{
	private Tablero mTablero = new Tablero();
	private Biltegia biltegi = Biltegia.getNireBiltegia();
	
	public main(){
		try{
			jbInit();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	private void jbInit() throws Exception{
		this.setLayout ( new BorderLayout());
		this.setSize ( new Dimension(400, 300));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//vamos a agregr el tablero al formulario y que ocupe todo el espacio
		this.add(mTablero, BorderLayout.CENTER);
		
		
		mTablero.hasieratu();
		mTablero.setSize(200,200);
		mTablero.ordenatu();
		biltegi.hasieratu();
		this.setVisible(true);
	}
}
