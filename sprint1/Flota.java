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
		this.f.remove(pOntzia);
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
	
	public void armaErosi(Arma pArma){
		if(this.dirua >= pArma.prezioa ){
			this.armamentua.armaGehituZerrendan(pArma.biltegiZenbakia);  //pasatuko diogu armaren biltegizenbakia
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
	
	//junit
	public void gehituOntzi(Ontzia o){
		this.f.add(o);
	}
	public void setArmamentua(Armamentua a) {
		this.armamentua=a;
		
	}
}

