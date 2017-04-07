package sprint1;

public class Misila extends Arma {
	public Misila(){
		super.biltegiZenbakia=2;
		super.prezioa=80;
	}
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
}
