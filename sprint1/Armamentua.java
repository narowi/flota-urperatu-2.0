package sprint1;

import java.util.ArrayList;

public class Armamentua {

	private ArrayList<Arma> armamentua;
	//private ArrayList<Integer> armaKopurua;

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

	public int getEzkutuKop() {  //Hau ez da beharrezkoa ez?????????????
		return this.ezkutua;
	}

	public void ezkutuKoptxikitu() {
		this.ezkutua--;	
	}
	
	public void armaKenduKop(int mota) {
		//Arma a=bilatuMota(mota);
		if(mota==0){
			this.bonba--;
		}else if(mota==1){
			ezkutuKoptxikitu();
		}else if(mota==2){
			this.misila--;
		}else if(mota==3){
			this.misilzuzendua--;
		}else if(mota==4){
			this.radar--;
		}
		
	}

	public void armaGehituZerrendan(int mota) {
		// Biltegian kop-- egin beharko da mota horretako arman
		if(mota==0){
			this.bonba++;
		}else if(mota==1){
			this.ezkutua++;
		}else if(mota==2){
			this.misila++;
		}else if(mota==3){
			this.misilzuzendua++;
		}else if(mota==4){
			this.radar++;
		}
	}

}
