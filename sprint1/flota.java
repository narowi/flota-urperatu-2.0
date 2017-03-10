package sprint1;

import java.util.ArrayList;
import java.util.Iterator;


public class Flota {
	private ArrayList<Ontzia> f;
	private Armamentua armamentua;
	private int dirua; 

	public Flota(int pDirua){
		this.f= new ArrayList<Ontzia>();
		this.dirua=pDirua;
		this.armamentua= new Armamentua();
	}
	
	private Iterator<Ontzia> getIteradorea(){
		return this.f.iterator();
	}
	public Ontzia flotaSortu(String mota){
		Ontzia nireOntzia = OntziFactory.getOntziFactory().createOntzia(mota);
		return nireOntzia;
	}
	public void gehituOntzia(String mota) {
		Ontzia ontzi=this.flotaSortu(mota);
		this.f.add(ontzi);
	}

	public void kenduOntzia(Ontzia pOntzia) {
		this.f.remove(pOntzia);
	}

	public int zenbatOntzi() {
		return this.f.size();
}
//	public boolean ezkutuakDitu(){
//		return !(this.armamentua.getEzkutua()<=0);
//	}

	public boolean ezkutuaDauka(Ontzia ontzia) {
		Ontzia on=ontzia;
		return on.ezkutuaDu();
	}


	 public int ezkutuKop(){
		 return armamentua.getEzkutuKop();
	 }

	public void ezkutuKopuruaTxikitu() {
		armamentua.ezkutuKoptxikitu();
		
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

	public void hasieratu(int zenb) {
		// TODO Auto-generated method stub
		this.f=new ArrayList<Ontzia>();
		this.armamentua= new Armamentua();
		this.dirua=zenb;
	}
	
}
