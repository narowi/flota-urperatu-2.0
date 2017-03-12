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
			nireArma= new Radar(70, 4);
		}else if(mota=="Bonba"){
			nireArma= new Bonba(50, 0);
		}else if(mota=="Misila"){
			nireArma= new Misila(60, 2);
		}else if(mota=="MisilZuzendua"){
			nireArma= new MisilZuzendua(80, 3);
		}else if(mota=="Ezkutua"){
			nireArma= new Ezkutua(30, 1);
		}
		return nireArma;
	}


}
