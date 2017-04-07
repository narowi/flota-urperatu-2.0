package sprint1;

public class Bonba extends Arma {
	public Bonba(){
		super.biltegiZenbakia=0;
		super.prezioa=30;
	}
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
}
