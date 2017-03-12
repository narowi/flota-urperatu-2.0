package sprint1;

public class Itsaspeko extends Ontzia {
	public Itsaspeko(int pLuz, String pMot, int pUgz, int pKp, Egoera pE){
		super(pLuz, pMot, pUgz, pKp, pE);
		super.luzera=3;
		super.urperatuGabekoZatiKop=3;
		super.mota="Itsaspeko";
		super.konponketaPrezioa=50;
		super.egoera= new Osorik();
	}
}
