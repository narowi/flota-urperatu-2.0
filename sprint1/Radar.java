package sprint1;

public class Radar extends Arma {
	public Radar(){
		super.biltegiZenbakia=4;
		super.prezioa=70;
		super.izena="Radar";
	}
	public void tiroEgin(int x, int y,int aukera){}
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
}
