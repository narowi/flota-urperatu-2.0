package sprint1;

import java.util.ArrayList;

import ui.WarningKudeatzailea;

import java.util.ArrayList;

public class Biltegia {
	private Armamentua armamentua;
	private static Biltegia nireBiltegia;
//	private ArrayList<Integer> armaKopurua;
	private EgoeraBiltegia e = new Ondo();

	private Biltegia(){
		
	}

	public static Biltegia getNireBiltegia(){
		if(Biltegia.nireBiltegia==null){
			Biltegia.nireBiltegia=new Biltegia();
		}
		return Biltegia.nireBiltegia;
	}

	public void armasaldu(int mota){ //try catch bidez hobeto
		//if(this.armamentua.armakDaude()){
		if(this.e instanceof Ondo){
			//e= new Ondo();
			if(this.armamentua.armarikDago(mota)){
				Biltegia.nireBiltegia.armamentua.armaKenduKop(mota); 
				e.armaSaldu(mota);
				if (!this.armamentua.armakDaude()){
					e = new StockGabe();
				}
			}else{
				new WarningKudeatzailea("Ez dago mota horretako alerik");
			}	
		}else if(e instanceof StockGabe){
			//System.out.println("Biltegia hutsik dago");
			e.armaSaldu(mota);
			//biltegiari ez bazaio arma bat ere ez gelditzen
		}
	}

	public void hasieratu() {
		this.armamentua = new Armamentua();
		this.armamentua.hasieratu(10,6,6,4,4);
		//this.armaKopurua= new ArrayList<Integer>();
	}

	public int luzera() {
		return this.armamentua.luzera();
	}

	public boolean armakDaude() {
		return this.armamentua.armakDaude();
	}

	public void egoeraAldatu(EgoeraBiltegia egoera) {
		this.e=egoera;
	}
}
