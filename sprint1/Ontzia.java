package sprint1;

public class Ontzia {

	protected int luzera;

	protected String mota;

	protected int urperatuGabekoZatiKop;

	protected int konponketaPrezioa;
	
	protected Egoera egoera;


	public Ontzia(){
	}

	

	public int getHondoratuGabekoZatiKop() {
		return urperatuGabekoZatiKop;
	}




	public boolean urperatutaDago(){

		boolean emaitza=false;

		if (this.urperatuGabekoZatiKop==0){

			emaitza=true;

		}

		return emaitza;

	}

		

	

	public void kenduZatia(){

		this.urperatuGabekoZatiKop--;

	}

	

	public void konponduOntzia(){

		this.urperatuGabekoZatiKop= this.urperatuGabekoZatiKop+1;

	}
	
	public boolean ezkutuaDu(){ 
		if(this.egoera instanceof EzkutuOsoa || this.egoera instanceof EzkutuBakarra ){
			return true;
		}else{
			return false;
		}
	}


	public void egoeraAldatu(Egoera pEgoera) {
		egoera=pEgoera;
		
	}

	public Egoera getEgoera() {
		return this.egoera;
	}

	public void zatiGuztiakUrperatu() {
		this.urperatuGabekoZatiKop=0;
		
	}




//	public void egoeraBegiratu(Arma arma) {
//		if(arma instanceof Bonba && this.getHondoratuGabekoZatiKop()!=1 && this.getEgoera() instanceof EzkutuOsoa){
//			//si el barco estaba ikututa que siga ikututa y si no ondo
//			this.egoeraAldatu(new Ikututa());
//			this.kenduZatia();
//		}else if(arma instanceof Bonba && this.getHondoratuGabekoZatiKop()==1){
//			this.egoeraAldatu(new Urperatuta());
//			this.zatiGuztiakUrperatu();
//		}else if(arma instanceof Misila){
//			this.egoeraAldatu(new Urperatuta());
//			this.zatiGuztiakUrperatu();
//		}
//		
//	}



	public void jo(Arma arma) {
		this.egoera.jo(this, arma);
		
	}



	public boolean lehenIkututa() {
		if(this.urperatuGabekoZatiKop==this.luzera){
			return false;
		}else{
			return true;
		}
	}



	public boolean zatirikBizirik() {
		if(this.urperatuGabekoZatiKop>1){
			return true;
		}else{
			return false;
		}
	}
	
	//juit
	public String getMota(){
		return this.mota;
	}
	

}
