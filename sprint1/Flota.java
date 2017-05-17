package sprint1;

import java.util.ArrayList;
import java.util.Iterator;

import ui.WarningKudeatzailea;



public class Flota {
	private ArrayList<Ontzia> f;
	private Armamentua armamentua;
	private int dirua;
	private int hegazkinOntzi;
	private int itsaspeko;
	private int suntsitzaile;
	private int fragata;
	
	public Flota(){
		this.f= new ArrayList<Ontzia>();
		this.dirua=700;
		this.armamentua= new Armamentua();
		this.hegazkinOntzi=1;
		this.itsaspeko=2;
		this.suntsitzaile=3;
		this.fragata=4;
		this.flotaSortu();
		this.armakEsleitu();
	}
	

	private Iterator<Ontzia> getIteradorea(){
		return this.f.iterator();
	}
	public Ontzia ontziaSortu(String mota){//solo creas uno 
		Ontzia nireOntzia = OntziFactory.getOntziFactory().createOntzia(mota);
		return nireOntzia;
	}
	public void gehituOntzia(String mota) {
		Ontzia ontzi=this.ontziaSortu(mota);
		this.f.add(ontzi);
	}

	public void kenduOntzia(Ontzia pOntzia) {
		//this.lortuOntzia().kokatuNaiz();
		pOntzia.kokatuNaiz();
	}
	
	public boolean geratzenDaOntzirik(){
		boolean bai=false;
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia o=null;
		while(!bai && itr.hasNext()){
			o=itr.next();
			if(!o.kokatutaAhalNago()){
				bai=true;
			}
		}
		return bai;
	}


	public boolean barkuakEzkutuaDauka(Ontzia ontzia) {
		Ontzia on=ontzia;
		boolean du=false;
		if(on.ezkutuaDu()){
			du=true;
			//System.out.println("ontziak jadanik badauka ezkutua");
		}
		return du;
	}


	 public boolean badagoEzkuturik(){
		 return armamentua.badagoEzkuturik();
	 }

	public void ezkutuKopuruaTxikitu() {
		armamentua.armaKenduKop(1);;
		
	}

	public Ontzia lortuOntzia(int i) {
		//return f.get(i);
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		boolean ezKokatuta=false;
		while(itr.hasNext() && !ezKokatuta){
			aux=itr.next();
			if(!aux.kokatutaAhalNago()){
				ezKokatuta=true;
			}
		}
		return aux;
	}

	public int urperatuGabekoKop(Ontzia ontzi) {
		if(ontzi.getHondoratuGabekoZatiKop()==0){
			System.out.println("ontzi horretan ezin da ezkuturik jarri urperatua dagoelako");
		}
		return ontzi.getHondoratuGabekoZatiKop();
	}

	public void egoeraAldatu(Ontzia ontzi) {
		ontzi.egoeraAldatu(new EzkutuOsoa());	
	}
	
	public int armaErosi(int biltegiZenbakia){  //try catch bidez tratatu hobeto
		int w=-1;
		Arma a= this.armamentua.lortuArma(biltegiZenbakia);
		if(armamentua.erosiAhalDut(this.dirua,a)){ //arma erostea biltegian gelditzen denean, biltegian ez badago ez da hautatzeko aukerarik egongo
			int k=Biltegia.getNireBiltegia().armasaldu(biltegiZenbakia);
			if(k==0){
			this.armamentua.armaGehituZerrendan(biltegiZenbakia);  //pasatuko diogu armaren biltegizenbakia
			this.dirua=this.dirua-a.getPrezioa();
			w=0;
			}
			else if(k==1){
				w=3;
			}
			else if(k==2){
				w=2;
			}
		}else{
			w=1;
			//System.out.print("Ez duzu dirurik eskatutako arma erosteko");
			//new WarningKudeatzailea("Ez duzu dirurik eskatutako arma erosteko");// new Warning
		}
		return w;
	}

	public void flotaSortu() {
		int i=0;
		boolean guztiak=false;
		while(!guztiak){
			while(i<this.hegazkinOntzi){
				this.gehituOntzia("HegazkinOntzi");
				i++;
			}
			i=0;
			while(i<this.itsaspeko){
				this.gehituOntzia("Itsaspeko");
				i++;
			}
			i=0;
			while(i<this.suntsitzaile){
				this.gehituOntzia("Suntsitzaile");
				i++;
			}
			i=0;
			while(i<this.fragata){
				this.gehituOntzia("Fragata");
				i++;
			}
			guztiak=true;
		}	
	}
	public int armamentuarenLuzera() {
		return this.armamentua.armaMotaKopuru();
	}

	

	public Arma lortuArma(int pos) {
		
		return armamentua.lortuArma(pos);
		
	}

	public boolean kenduArmaKopBat(Arma a) {
		return this.armamentua.armaKenduKop(a.getBiltegiZenbakia());
	}
	public boolean armarikDago(int biltegiZenbakikoArma) {
		return this.armamentua.armarikDago(biltegiZenbakikoArma);
	}
	
	public boolean armaErosiDezake(Arma arma){
		if(arma.prezioa> this.dirua){
			return false;
		}else{
			return true;
		}
	}
	
	public void gehituOntzi(Ontzia o){
		this.f.add(o);
	}
	
	public void setArmamentua(Armamentua a) {
		this.armamentua=a;
	}
	
	public Ontzia lortuOntziaStringetik(String izena){
		boolean aurkitua=false;
		Ontzia o=null;
		Iterator<Ontzia> itr =this.getIteradorea();
		while(itr.hasNext() && !aurkitua){
			o=itr.next();
			if(o.berdinaDa(izena)&& !o.kokatutaAhalNago()){
				aurkitua=true;
			}
		}
		if(aurkitua){
			return o;
		}
		else{
			return null;
		}
	}
	
	public boolean diruNahikoa(Ontzia o) {
		if(o.konponduAhal(this.dirua)){
			return true;
		}else{
			return false;
		}
	}
	
	public void diruaKendu(Ontzia o) {
		this.dirua=this.dirua- o.konponketaPrezioa;
	}
	
	public int size() {
		return this.f.size();
	}
	
	public Ontzia bilatuOntzia(int o) {
		Ontzia on= this.f.get(o);
		return on;	
	}
	
	public Arma geratzenZaitArmaHau(String arma) {
		Arma a=null;
		a=this.armamentua.bilatu(arma);
		return a;
	}
	
	public Armamentua armamentuaLortu(){
		return this.armamentua;
	}
	
	public boolean itsaspekoakDaude() {
		boolean batKokatuGabe=false;
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.itsaspekoaDa() && !aux.kokatutaAhalNago()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public boolean fragatakDaude() {
		boolean batKokatuGabe=false;
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.fragataDa() && !aux.kokatutaAhalNago()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public boolean hegazkinOntziDaude() {
		boolean batKokatuGabe=false;
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.hegazkinOntziDa() && !aux.kokatutaAhalNago()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	public boolean suntsitzaileDaude() {
		boolean batKokatuGabe=false;
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext()&& !batKokatuGabe){
			aux=itr.next();
			if(aux.suntsitzaileaDa() && !aux.kokatutaAhalNago()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public void armakEsleitu() {
		this.armamentua.hasieratu();	
	}

	public Arma armaSortu(String arma) {
		return this.armamentua.armaSortu(arma);
	}
	
	
	public boolean ontziGuztiakKokatuta() {
		boolean batKokatuGabe=false;
		Iterator<Ontzia> itr= this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext() && !batKokatuGabe){
			aux=itr.next();
			if(!aux.kokatutaAhalNago()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
	
	public boolean badagoOntzirikSuntsituta() {
		boolean badago=false;
		Iterator<Ontzia> itr= this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext() && !badago){
			aux=itr.next();
			if(!aux.dagoOsorik()){
				badago=true;
			}
		}
		return badago;
	}
	
	public boolean itsasontziBizirik() {
		boolean bizirik = false;
		Iterator<Ontzia> itr = this.getIteradorea();
		while(!bizirik && itr.hasNext() ){
			if(!itr.next().urperatutaDago()){
				bizirik = true;
			}
		}
		return bizirik;
	}
	

	public boolean armarikDauka() {
		return armamentua.armakDaude();
	}
	
	//junit
	
	


	



}

