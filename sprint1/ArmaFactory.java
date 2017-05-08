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
		}else if(mota=="MisilZuzenduaBertikal"){
			nireArma= new MisilZuzenduaBertikal();
		}else if(mota=="Ezkutua"){
			nireArma= new Ezkutua();
		}else if(mota=="MisilZuzenduaHorizontal"){
			nireArma= new MisilZuzenduaHorizontal();
		}else if(mota=="MisilZuzenduaBoom"){
			nireArma= new MisilZuzenduaBoom();
		}	
		return nireArma;
	}


}
