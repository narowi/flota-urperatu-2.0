package sprint1;

import java.util.ArrayList;
import java.util.Iterator;


public class Armamentua {

	private ArrayList<Arma> armamentua;
	//private ArrayList<Integer> armaKopurua;
	private int[] biltegikoArmaKop= new int[5];

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
		biltegikoArmaKop[0]=10;
		biltegikoArmaKop[1]=6;
		biltegikoArmaKop[2]=6;
		biltegikoArmaKop[3]=4;
		biltegikoArmaKop[4]=4;
	}

	public Arma armaSortu(String mota){
		Arma nireArma = ArmaFactory.getArmaFactory().createArma(mota);
		return nireArma;
	}

	public void armaKendu(Arma mota) {
		
		if(mota.biltegiZenbakia==0){
			this.bonba=0;
		}else if(mota.biltegiZenbakia==1){
			this.ezkutua=0;
		}else if(mota.biltegiZenbakia==2){
			this.misila=0;
		}else if(mota.biltegiZenbakia==3){
			this.misilzuzendua=0;
		}else{
			this.radar=0;
		}
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


	private Iterator<Arma> getIteradorea(){

		return this.armamentua.iterator();

	}
	public Arma lortuArma(int pos) {
		boolean aurkitua=false;
		Iterator<Arma>itr=this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext() && !aurkitua){
			aux=itr.next();
			if(aux.posizioHorretakoArmaDa(pos)){
				aurkitua=true;
			}
		}
		return aux;
	}
	
	public boolean armarikDago(int biltegiZenbakikoArma) {
		if(biltegiZenbakikoArma==0 && this.bonba>0){
			return true;
		}else if(biltegiZenbakikoArma==2 && this.misila>0){
			return true;
		}else if(biltegiZenbakikoArma==3 && this.misilzuzendua>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public Arma bilatu(String arma) {
		Iterator<Arma> itr= this.getIteradorea();
		Arma a=null;
		boolean amaitu=false;
		
		while (itr.hasNext() && !amaitu){
			a=itr.next();
			if(a.berdinaNaiz(arma)){
				amaitu=true;
			}
			
		}
		return a;
	}
	
	//junit
	
	public int luzera() {
		return this.armamentua.size();
	}
	
	public void armaGehitu2(Arma a){
		this.armamentua.add(a);
	}
	
	public int bonbaKop(){
		return this.bonba;
	}
	
	public int misilKop(){
		return this.misila;
	}
	
	public int misilZ(){
		return this.misilzuzendua;
	}
	
	public int ezkutuKop(){
		return this.ezkutua;
	}
	
	public int radarKop(){
		return this.radar;
	}

	public int zenbatArma() {
		return this.armamentua.size();
	}
	
	public void garbitu(){
		this.armamentua= new ArrayList<Arma>();	
		this.bonba=0;
		this.ezkutua=0;
		this.misila=0;
		this.misilzuzendua=0;  //bakoitza mota desberdinetakoa
		this.radar=0;
		this.armamentua.clear();
	}

	public boolean bobarikJartzenJarraitu() {
		boolean batKokatuGabe=false;
		Iterator<Arma> itr =this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.bonbaDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public boolean misilakJartzenJarraitu() {
		boolean batKokatuGabe=false;
		Iterator<Arma> itr =this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.misilaDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}

	public boolean misilZuzenduakJartzenJarraitu() {
		boolean batKokatuGabe=false;
		Iterator<Arma> itr =this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.misilZuzenduaDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}

	public boolean radarrakJartzenJarraitu() {
		boolean batKokatuGabe=false;
		Iterator<Arma> itr =this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.radarraDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}

	public boolean ezkutuakJartzenJarraitu() {
		boolean batKokatuGabe=false;
		Iterator<Arma> itr =this.getIteradorea();
		Arma aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.ezkutuaDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public boolean armakDaude() {
		if (this.bonba!=0 || this.ezkutua!=0 || this.misila!=0 || this.misilzuzendua!=0 || this.radar!=0){
			return true;
		}else{
			return false;
		}
	}

	public boolean biltegianArmarikDago(int mota) {
		if(biltegikoArmaKop[mota]>0){
			return true;
		}else{
			return false;
		}
	}

	public void biltegiArmaKenduKop(int mota) {
		biltegikoArmaKop[mota]--;
		
	}

	public boolean biltegianArmakDaude() {
		if(biltegikoArmaKop[0]>0 || biltegikoArmaKop[1]>0|| biltegikoArmaKop[2]>0|| biltegikoArmaKop[3]>0|| biltegikoArmaKop[4]>0){
			return true;
		}else{
			return false;
		}
	}
	

}
