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

	public void armasaldu(int mota){ //try catch bidez hobeto
		if(this.armamentua.armarikDago(mota)){
			this.nireBiltegia.armamentua.armaKenduKop(mota); 
		}else{
			System.out.println("Ezin baita saldu, ez dago alerik");
		}
	}

	public void hasieratu() {
		this.armamentua = new Armamentua();
		this.armamentua.hasieratu(10,6,6,4,4);
		this.armaKopurua= new ArrayList<Integer>();
	}

	public int luzera() {
		return this.armamentua.luzera();
	}
}
