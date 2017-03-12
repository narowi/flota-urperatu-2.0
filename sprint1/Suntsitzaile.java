package sprint1;

public class Suntsitzaile extends Ontzia {
	public Suntsitzaile(int pLuz, String pMot, int pUgz, int pKp, Egoera pE){
		super(pLuz, pMot, pUgz, pKp, pE);
		super.luzera=2;
		super.urperatuGabekoZatiKop=2;
		super.mota="Suntsitzaile";
		super.konponketaPrezioa=40;
		super.egoera= new Osorik();
	}
}
