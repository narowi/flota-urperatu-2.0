package sprint1;

public abstract class Arma {
	protected int prezioa;
	protected int biltegiZenbakia;
	protected String izena;
	public Arma(){
	}
	public abstract void tiroEgin(int x, int y,int aukera);
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
}
