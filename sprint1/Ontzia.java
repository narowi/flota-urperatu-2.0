package sprint1;

public class Ontzia {

	protected int luzera;

	protected String mota;

	protected int urperatuGabekoZatiKop;

	protected int konponketaPrezioa;
	
	protected Egoera egoera = new Osorik();
	
	protected boolean kokatua=false;


	public Ontzia(){
	}

	

	public int getHondoratuGabekoZatiKop() {
		return urperatuGabekoZatiKop;
	}

	public void kokatuNaiz(){
		this.kokatua=true;
		
	}
	public boolean kokatutaAhalNago(){
		return this.kokatua;
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
	
	public boolean ezkutuOsoaDu(){ 
		
		if(this.egoera instanceof EzkutuOsoa){
		
			return true;
		
		}else{
		
			return false;
		}
	}
	
	
	public boolean ezkutuBakarraDu(){
		
		if(this.egoera instanceof EzkutuBakarra){
		
			return true;
		
		}else{
		
			return false;
		}
	}


	public void egoeraAldatu(Egoera pEgoera) {
		
		egoera=pEgoera;
		
	}



	public void zatiGuztiakUrperatu() {
		
		this.urperatuGabekoZatiKop=0;
		
	}


//	public int getLuzera(){
//		return this.luzera;
//	}

	public void jo(Arma arma, boolean kasillaUrperatuta) {
		
		this.egoera.jo(this, arma, kasillaUrperatuta);
		
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
	
	public boolean berdinaDa(String izena) {
		
		return this.mota.equals(izena);
	}
	
	public boolean ezkutuaDu() {
		
		if(this.egoera instanceof EzkutuBakarra || this.egoera instanceof EzkutuOsoa){
		
			return true;
		
		}else{
		
			return false;
		}
	}
	
	public boolean konponduAhal(int dirua) {
		
		if(this.konponketaPrezioa<=dirua){
		
			return true;
		
		}else{
		
			return false;
		}
	}



	public void egoeraEsleitu() {
		
		if(this.egoera instanceof Urperatuta){
		
			if(this.luzera==1){
			
				this.egoera = new Osorik();
			
			}else{
			
				this.egoera=new Ikututa();
			
			}	
		
		}else if(this.egoera instanceof Ikututa){
		
			if(this.luzera==this.urperatuGabekoZatiKop){
			
				this.egoera = new Osorik();
			}
		}
	}



	public boolean dagoOsorik() {
		
		if(this.egoera instanceof Osorik || (this.egoera instanceof EzkutuOsoa && this.luzera == this.urperatuGabekoZatiKop) || (this.egoera instanceof EzkutuBakarra && this.luzera == this.urperatuGabekoZatiKop)  ){
		
			return true;

		}else{
		
			return false;
		}
	}



	public boolean itsaspekoaDa() {
		
		if(this instanceof Itsaspeko){
		
			return true;

		}else{
		
			return false;
		}
	}



	public boolean kokatuGabe() {
		
		if(this.kokatua == false){
		
			return true;
		
		}else{
		
			return false;
		}
	}



	public boolean fragataDa() {
		
		if(this instanceof Fragata){
		
			return true;
		
		}else{
		
			return false;
		}
	}



	public boolean hegazkinOntziDa() {
		
		if(this instanceof HegazkinOntzi){
		
			return true;
		
		}else{
		
			return false;
		}
	}
	
	public boolean suntsitzaileaDa() {
		
		if(this instanceof Suntsitzaile){
		
			return true;
		
		}else{
		
			return false;
		}
	}
	
	
	
	//juit
	
	public Egoera getEgoera() {
		
		return this.egoera;
	}

	









}
