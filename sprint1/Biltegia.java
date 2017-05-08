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
		this.hasieratu();
	}

	public static Biltegia getNireBiltegia(){
		if(Biltegia.nireBiltegia==null){
			Biltegia.nireBiltegia=new Biltegia();
		}
		return Biltegia.nireBiltegia;
	}

	public int armasaldu(int mota){ //try catch bidez hobeto
		int w=-1;
		if(this.e instanceof Ondo){
			
			
			if(this.armamentua.biltegianArmarikDago(mota)){
				
				Biltegia.nireBiltegia.armamentua.biltegiArmaKenduKop(mota);
				
				w=0;
				if (!this.armamentua.biltegianArmakDaude()){
				
					
					e = new StockGabe();
				}
			}else{
				w=1;
				//new WarningKudeatzailea("Ez dago mota horretako alerik");
			}	
		}else if(e instanceof StockGabe){
			w=2;
			//biltegiari ez bazaio arma bat ere ez gelditzen
		}
		return w;
	}

	public void hasieratu() {
		this.armamentua = new Armamentua();
		armamentua.hasieratu();
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
