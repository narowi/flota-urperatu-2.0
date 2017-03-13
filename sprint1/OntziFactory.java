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
	
	public Ontzia createOntzia(String mota){ 
		Ontzia nireOntzia=null;
		if(mota=="HegazkinOntzi"){
			nireOntzia= new HegazkinOntzi();
		}else if(mota=="Itsaspeko"){
			nireOntzia= new Itsaspeko();
		}else if(mota=="Suntsitzaile"){
			nireOntzia= new Suntsitzaile();
		}else if(mota=="Fragata"){
			nireOntzia= new Fragata();
		}
		return nireOntzia;
	}

}
