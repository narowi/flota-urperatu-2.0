package sprint1;

public class ArmaFactory {
	private static ArmaFactory nArmaFactory;
	private ArmaFactory(){}
	
	public static ArmaFactory getArmaFactory(){
		if(nArmaFactory==null){
			nArmaFactory = new ArmaFactory();
		}
		return nArmaFactory;
	}
	
	public Arma createArma(String mota){
		Arma nireArma=null;
		if(mota=="Radar"){
			nireArma= new Radar();
		}else if(mota=="Bonba"){
			nireArma= new Bonba();
		}else if(mota=="Misila"){
			nireArma= new Misila();
		}else if(mota=="MisilZuzendua"){
			nireArma= new MisilZuzendua();
		}else if(mota=="Ezkutua"){
			nireArma= new Ezkutua();
		}
		return nireArma;
	}


}
