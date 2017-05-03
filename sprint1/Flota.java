package sprint1;

import java.util.ArrayList;
import java.util.Iterator;



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
		this.lortuOntzia().kokatuNaiz();
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

	public int zenbatOntzi() {
		return this.f.size();
	}


	public boolean barkuakEzkutuaDauka(Ontzia ontzia) {
		Ontzia on=ontzia;
		return on.ezkutuaDu();
	}


	 public boolean badagoEzkuturik(){
		 return armamentua.badagoEzkuturik();
	 }

	public void ezkutuKopuruaTxikitu() {
		armamentua.armaKenduKop(1);;
		
	}

	public boolean isEmpty() {
		if(this.f.size()==0){
			return true;
		}else{
			return false;
		}
	}

	public Ontzia lortuOntzia() {
		Iterator<Ontzia> itr =this.getIteradorea();
		Ontzia aux=null;
		while(itr.hasNext()){
			aux=itr.next();
		}
		return aux;
	}

	public int urperatuGabekoKop(Ontzia ontzi) {
		return ontzi.getHondoratuGabekoZatiKop();
	}

	public void egoeraAldatu(Ontzia ontzi) {
		ontzi.egoeraAldatu(new EzkutuOsoa());	
	}
	
	public void armaErosi(Arma pArma){  //try catch bidez tratatu hobeto
		if(this.dirua >= pArma.prezioa ){ //arma erostea biltegian gelditzen denean, biltegian ez badago ez da hautatzeko aukerarik egongo
			Biltegia.getNireBiltegia().armasaldu(pArma.biltegiZenbakia);
			this.armamentua.armaGehituZerrendan(pArma.biltegiZenbakia);  //pasatuko diogu armaren biltegizenbakia
			this.dirua=this.dirua-pArma.prezioa;
		}else{
			System.out.print("Ez duzu dirurik eskatutako arma erosteko");
		}
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
		return this.armamentua.luzera();
	}

	

	public Arma lortuArma(int pos) {
		
		return armamentua.lortuArma(pos);
		
	}

	public void kenduArmaKopBat(Arma arma) {
		this.armamentua.armaKenduKop(arma.biltegiZenbakia);
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
	
	//junit
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
			if(o.berdinaDa(izena)){
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
		boolean aurkitua=false;
		Iterator<Ontzia> itr =this.getIteradorea();
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
			if(aux.itsaspekoaDa() && aux.kokatuGabe()){
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
			if(aux.fragataDa() && aux.kokatuGabe()){
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
			if(aux.hegazkinOntziDa() && aux.kokatuGabe()){
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
			if(aux.suntsitzaileaDa() && aux.kokatuGabe()){
				batKokatuGabe=true;
			}
		}
		return batKokatuGabe;
	}
}

