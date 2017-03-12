package sprint1;

public class Fragata extends Ontzia {
	public Fragata(int pLuz, String pMot, int pUgz, int pKp, Egoera pE){
		super(pLuz, pMot, pUgz, pKp, pE);
		super.luzera=1;
		super.urperatuGabekoZatiKop=1;
		super.mota="Fragata";
		super.konponketaPrezioa=30;
		super.egoera= new Osorik();
	}	
}
