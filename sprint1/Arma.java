package sprint1;

public abstract class Arma {
	protected int prezioa;
	protected int biltegiZenbakia;
	protected String izena;
	protected boolean kokatua=false;
	public Arma(){
	}
	public abstract void tiroEgin(int x, int y,Tablero t);
	public Boolean ezkutuOsoaKenduBehar() {
		if(this instanceof MisilZuzenduaBertikal || this instanceof MisilZuzenduaHorizontal ||  this instanceof MisilZuzenduaBoom || this instanceof Misila){
			return true;
			
		}else if(this instanceof Bonba){
			return false;
		}else{
			return null;
		}
	}
	
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
	
	public int getBiltegiZenbakia() {
		return this.biltegiZenbakia;
	}	
	
	public boolean berdinaNaiz(String arma) {
		return this.izena==arma;
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
