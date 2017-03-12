package sprint1;

public class OntziFactory {
	private static OntziFactory nOntziFactory;
	private OntziFactory(){}
	
	public static OntziFactory getOntziFactory(){
		if(nOntziFactory==null){
			nOntziFactory = new OntziFactory();
		}
		return nOntziFactory;
	}
	
	public Ontzia createOntzia(String mota){ //super(pLuz, pMot, pUgz, pKp, pE);
		Ontzia nireOntzia=null;
		if(mota=="HegazkinOntzi"){
			nireOntzia= new HegazkinOntzi(4, "HegazkinOntzi", 4, 60, new Osorik());
		}else if(mota=="Itsaspeko"){
			nireOntzia= new Itsaspeko(3, "Itsaspeko", 3, 50, new Osorik());
		}else if(mota=="Suntsitzaile"){
			nireOntzia= new Suntsitzaile(2, "Suntsitzaile", 2, 40, new Osorik());
		}else if(mota=="Fragata"){
			nireOntzia= new Fragata(1, "Fragata", 1, 30, new Osorik());
		}
		return nireOntzia;
	}

}
