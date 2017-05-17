package sprint1;

public class EzkutuBakarra implements Egoera {
	public EzkutuBakarra(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){
		
		if(arma instanceof MisilZuzenduaBertikal || arma instanceof MisilZuzenduaHorizontal || arma instanceof MisilZuzenduaBoom || arma instanceof Misila){
			ontzia.egoeraAldatu(new Urperatuta());
		}else{
			if(ontzia.lehenIkututa()){
		
			ontzia.egoeraAldatu(new Ikututa());
			
		}else{
			ontzia.egoeraAldatu(new Osorik());
		}
		}
	}
}
