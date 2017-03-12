package sprint1;

public class HegazkinOntzi extends Ontzia {
	public HegazkinOntzi(int pLuz, String pMot, int pUgz, int pKp, Egoera pE){
		super(pLuz, pMot, pUgz, pKp, pE);
		super.luzera=4;
		super.urperatuGabekoZatiKop=4;
		super.mota="HegazkinOntzi";
		super.konponketaPrezioa=60; //zati bakoitza
		super.egoera= new Osorik();
	}
}
