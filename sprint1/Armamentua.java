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
	private int misilzuzenduaBertikal;
	private int misilzuzenduaHorizontal;
	private int misilzuzenduaBoom;
	private int radar;

	public Armamentua(){
		this.armamentua= new ArrayList<Arma>();	
		this.bonba=4;
		this.ezkutua=3;
		this.misila=2;
		this.misilzuzenduaBertikal=3;  //bakoitza mota desberdinetakoa
		this.misilzuzenduaHorizontal=3;
		this.misilzuzenduaBoom=3;
		this.radar=2;
		biltegikoArmaKop[0]=10; //bonba
		biltegikoArmaKop[1]=6; //ezkutua
		biltegikoArmaKop[2]=6; //misila
		biltegikoArmaKop[3]=4; //misilzuzenduBertikala
		biltegikoArmaKop[4]=4; //radar
		biltegikoArmaKop[5]=4; //misilzuzenduaHorizontal
		biltegikoArmaKop[5]=4; //boom
		
		//se crean las armas olatz????
		//this.hasieratu(bonba,ezkutua,misila,misilZuzendua,radar)   NO SE SI EN ESE ORDEN
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
			this.misilzuzenduaBertikal=0;
		}else if(mota.biltegiZenbakia==4){
			this.radar=0;
		}else if(mota.biltegiZenbakia==5){
			this.misilzuzenduaHorizontal=0;
		}else if(mota.biltegiZenbakia==6){
			this.misilzuzenduaBoom=0;
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
		}else if(mota==3 && this.misilzuzenduaBertikal>0){
			this.misilzuzenduaBertikal--;
		}else if(mota==4 && this.radar>0){
			this.radar--;
		}else if(mota==3 && this.misilzuzenduaHorizontal>0){
			this.misilzuzenduaHorizontal--;
		}else if(mota==3 && this.misilzuzenduaBoom>0){
			this.misilzuzenduaBoom--;
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
			this.misilzuzenduaBertikal++;
		}else if(mota==4){
			this.radar++;
		}else if(mota==5){
			this.misilzuzenduaHorizontal++;
		}else if(mota==6){
			this.misilzuzenduaBoom++;
		}
	}

	public void hasieratu() {
		this.armamentua.clear();
		this.armamentua= new ArrayList<Arma>();
		int i = 0;
		this.armaGehitu("Bonba");
		this.armaGehitu("Ezkutua");
		this.armaGehitu("Misila");
		this.armaGehitu("MisilZuzenduaBertikal");
		this.armaGehitu("radar");
		this.armaGehitu("MisilZuzenduaHorizontal");
		this.armaGehitu("MisilZuzenduaBoom");
	}


	private Iterator<Arma> getIteradorea(){

		return this.armamentua.iterator();

	}
	public Arma lortuArma(int pos) {
//		boolean aurkitua=false;
//		Iterator<Arma>itr=this.getIteradorea();
//		Arma aux=null;
//		while(itr.hasNext() && !aurkitua){
//			aux=itr.next();
//			if(aux.posizioHorretakoArmaDa(pos)){
//				aurkitua=true;
//			}
//		}
//		return aux;
		return this.armamentua.get(pos);
	}
	
	public boolean armarikDago(int biltegiZenbakikoArma) {
		boolean dago=false;
		if((biltegiZenbakikoArma==0 && this.bonba>0)){
			dago=true;
		}else if((biltegiZenbakikoArma==2 && this.misila>0)){
			dago=true;
		}else if((biltegiZenbakikoArma==3 && this.misilzuzenduaBertikal>0)){
			dago=true;
		}else if((biltegiZenbakikoArma==1 && this.ezkutua>0)) {
			dago=true;
		}else if((biltegiZenbakikoArma==4 && this.radar>0)){
			dago=true;
		}else if((biltegiZenbakikoArma==5 && this.misilzuzenduaHorizontal>0)){
			dago=true;
		}else if((biltegiZenbakikoArma==6 && this.misilzuzenduaBoom>0)){
			dago=true;
		}
		return dago;
	}
	
	public boolean armarikDagoBiltegian(int biltegiZenbakikoArma){
		boolean dago=false;
		if(biltegikoArmaKop[0]>0){
			dago=true;
		}else if(biltegikoArmaKop[2]>0){
			dago=true;
		}else if(biltegikoArmaKop[3]>0){
			dago=true;
		}else if(biltegikoArmaKop[1]>0) {
			dago=true;
		}else if(biltegikoArmaKop[4]>0){
			dago=true;
		}else if(biltegikoArmaKop[5]>0){
				dago=true;
		}else if(biltegikoArmaKop[6]>0){
			dago=true;
		}	
		return dago;
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
	
//	public int luzera() {
//		return this.armamentua.size();
//	}
	
	public void armaGehitu2(Arma a){
		this.armamentua.add(a);
	}
	
	public int bonbaKop(){
		return this.bonba;
	}
	
	public int misilKop(){
		return this.misila;
	}
	
	public int misilZB(){
		return this.misilzuzenduaBertikal;
	}
	
	public int misilZH(){
		return this.misilzuzenduaHorizontal;
	}
	
	public int misilZBoom(){
		return this.misilzuzenduaBoom;
	}
	
	public int ezkutuKop(){
		return this.ezkutua;
	}
	
	public int radarKop(){
		return this.radar;
	}

//	public int zenbatArma() {
//		return this.armamentua.size();
//	}
	
//	public void garbitu(){
//		this.armamentua= new ArrayList<Arma>();	
//		this.bonba=0;
//		this.ezkutua=0;
//		this.misila=0;
//		this.misilzuzenduaBertikal=0;  //bakoitza mota desberdinetakoa
//		this.radar=0;
//		this.armamentua.clear();
//	}

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
		if (this.bonba!=0 || this.ezkutua!=0 || this.misila!=0 || this.misilzuzenduaBertikal!=0 || this.misilzuzenduaHorizontal!=0 || this.misilzuzenduaBoom!=0 || this.radar!=0){
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
		//this.armaKenduKop(mota);
	}

	public boolean biltegianArmakDaude() {
		if(biltegikoArmaKop[0]>0 || biltegikoArmaKop[1]>0|| biltegikoArmaKop[2]>0|| biltegikoArmaKop[3]>0|| biltegikoArmaKop[4]>0 || biltegikoArmaKop[5]>0 || biltegikoArmaKop[6]>0){
			return true;
		}else{
			return false;
		}
	}

	public boolean erosiAhalDut(int dirua, Arma a) {
		return a.erosiAhalDut(dirua);
	}
}
