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
		
		if(this.e instanceof Ondo){
			
			
			if(this.armamentua.biltegianArmarikDago(mota)){
				
				Biltegia.nireBiltegia.armamentua.biltegiArmaKenduKop(mota);
				//como cojones esta hecho olatz??
				
				
				if (!this.armamentua.biltegianArmakDaude()){
				
					
					e = new StockGabe();
				}
			}else{
				new WarningKudeatzailea("Ez dago mota horretako alerik");
			}	
		}else if(e instanceof StockGabe){
			e.armaSaldu(mota);
			//biltegiari ez bazaio arma bat ere ez gelditzen
		}
	}

	public void hasieratu() {
		this.armamentua = new Armamentua();
		this.armamentua.hasieratuBiltegi();
		//this.armaKopurua= new ArrayList<Integer>();
	}

	public int luzera() {
		return this.armamentua.armaMotaKopuru();
	}

	public boolean armakDaude() {
		return this.armamentua.biltegianArmakDaude();
	}

	public void egoeraAldatu(EgoeraBiltegia egoera) {
		this.e=egoera;
	}
	
	public boolean motaHorretakoArmarik(int mota){
		return this.armamentua.armarikDago(mota);
		
	}
	
	public EgoeraBiltegia getEgoera(){
		return this.e;
	}
}
