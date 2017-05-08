package sprint1;

public abstract class Arma {
	protected int prezioa;
	protected int biltegiZenbakia;
	protected String izena;
	protected boolean kokatua=false;
	public Arma(){
	}
	public abstract void tiroEgin(int x, int y,int aukera,Jokalaria pAurkari);
	public Boolean ezkutuOsoaKenduBehar() {
		if(this instanceof MisilZuzendua || this instanceof Misila){
			return true;
			
		}else if(this instanceof Bonba){
			return false;
		}else{
			return null;
		}
	}
	public abstract boolean posizioHorretakoArmaDa(int pos);
	
	public int getBiltegiZenbakia() {
		return this.biltegiZenbakia;
	}	
	
	public boolean berdinaNaiz(String arma) {
		return this.izena==arma;
	}
	public boolean bonbaDa() {
		if(this instanceof Bonba){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean misilaDa() {
		if(this instanceof Misila){
			return true;
		}else{
			return false;
		}
	}
	public boolean misilZuzenduaDa() {
		if(this instanceof MisilZuzendua){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean radarraDa() {
		if(this instanceof Radar){
			return true;
		}else{
			return false;
		}
	}
	public boolean ezkutuaDa() {
		if(this instanceof Ezkutua){
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
	public boolean erosiAhalDut(int dirua) {
		if(dirua>=this.prezioa){
		return true;
		}
		else{
			return false;
		}
	}
	public int getPrezioa() {
		return this.prezioa;
	}
}
