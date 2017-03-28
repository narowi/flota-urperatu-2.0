package sprint1;

import java.util.ArrayList;

import java.util.ArrayList;

public class Biltegia {
	private Armamentua armamentua;
	private static Biltegia nireBiltegia;
	private ArrayList<Integer> armaKopurua;
	private EgoeraBiltegia e;

	private Biltegia(){
		
	}

	public static Biltegia getNireBiltegia(){
		if(Biltegia.nireBiltegia==null){
			Biltegia.nireBiltegia=new Biltegia();
		}
		return Biltegia.nireBiltegia;
	}

	public void armasaldu(int mota){
		this.nireBiltegia.armamentua.armaKenduKop(mota);  
	}

	public void hasieratu() {
		// TODO Auto-generated method stub
		this.armamentua.hasieratu(20, 20, 20, 20, 20);
		this.armaKopurua= new ArrayList<Integer>();
	}

	//arma saldu

	//arma erosi

}
