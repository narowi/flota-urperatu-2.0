package sprint1;

public class Ezkutua extends Arma {
	public Ezkutua(){
		super.biltegiZenbakia=1;
		super.prezioa=50; //porcada casilla 
		super.izena="Ezkutua";
	}
	public void tiroEgin(int x, int y,Tablero t){}
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
	
}
