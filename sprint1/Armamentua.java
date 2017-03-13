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

	public Armamentua(){
		this.armamentua= new ArrayList<Arma>();	
		this.bonba=4;
		this.ezkutua=3;
		this.misila=2;
		this.misilzuzendua=3;  //bakoitza mota desberdinetakoa
		this.radar=2;
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

	public boolean badagoEzkuturik(){
		boolean badago=false;
		if(this.ezkutua>0){
			badago=true;
		}
		return badago;
	}
	
	public void armaKenduKop(int mota) {
		//Arma a=bilatuMota(mota);
		if(mota==0 && this.bonba>0){
			this.bonba--;
		}else if(mota==1 && this.ezkutua>0){
			this.ezkutua--;
		}else if(mota==2 && this.misila>0){
			this.misila--;
		}else if(mota==3 && this.misilzuzendua>0){
			this.misilzuzendua--;
		}else if(mota==4 && this.radar>0){
			this.radar--;
		}else{
			System.out.println("Arma horren alerik ez da gelditzen");
		}
		
	}

	public int armaMotaKopuru(){
		return armamentua.size();
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

	public void hasieratu(int pBonba, int pEzkutua, int pMisila, int pMisilZuzendua, int pRadar) {
		this.armamentua.clear();
		this.armamentua= new ArrayList<Arma>();
		int i = 0;
		while(i< pBonba){
			this.armaGehitu("Bonba");
			i++;
		}
		i=0;
		while(i< pEzkutua){
			this.armaGehitu("Ezkutua");
			i++;
		}
		i=0;
		while(i < pMisila){
			this.armaGehitu("Misila");
			i++;
		}
		i=0;
		while(i < pMisilZuzendua){
			this.armaGehitu("MisilZuzendua");
			i++;
		}
		i=0;
		while(i < pRadar){
			this.armaGehitu("radar");
			i++;
		}
		
	}

}
