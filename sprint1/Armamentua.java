package sprint1;

import java.util.ArrayList;



public class Armamentua {

	private ArrayList<Arma> armamentua;

	private ArrayList<Integer> armaKopurua;

	private int bonba;

	private int ezkutua;

	private int misila;

	private int misilzuzendua;

	private int radar;

	

	public Armamentua(int pBonba, int pEzkutua, int pMisila, int pMisilZuzendua, int pRadar){

		this.armamentua= new ArrayList<Arma>();	

		this.bonba=pBonba;

		this.ezkutua=pEzkutua;

		this.misila=pMisila;

		this.misilzuzendua=pMisilZuzendua;

		this.radar=pRadar;

	}

	

	public Arma armaSortu(String mota){

		Arma nireArma = ArmaFactory.getArmaFactory().createArma(mota);

		return nireArma;

	}

	

	public void armaKendu(Arma mota) {

		this.armamentua.remove(mota);

	}

	public void armaGehitu(String mota) {

		Arma arma = this.armaSortu(mota);

		this.armamentua.add(arma);

	}



	public int getEzkutuKop() {

		return this.ezkutua;

	}



	public void ezkutuKoptxikitu() {
		this.ezkutua--;
		
	}

}
