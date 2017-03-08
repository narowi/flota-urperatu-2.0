package sprint1;

import java.util.ArrayList;
import java.util.Iterator;


public class flota {
	private ArrayList<Ontzia> f;
	private Armamentua armamentua;
	private int dirua; //ELEGIR LA CANTIDAD

	public flota(){
		this.f= new ArrayList<Ontzia>();	
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
//
//		return !(this.armamentua.getEzkutua()<=0);
//
//	}

	public boolean ezkutuaDauka(Ontzia ontzia) {
		Ontzia on=ontzia;
		return on.ezkutuaDu();
	}

	public void ezkutuaJarri(Ontzia ontzi) {
		Ontzia on=ontzi;
		on.jarriEzkutua();
		
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
		return itr.next();
	}
	

}
