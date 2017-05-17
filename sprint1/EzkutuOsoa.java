package sprint1;

public class EzkutuOsoa implements Egoera{
	public EzkutuOsoa(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
		if(arma instanceof MisilZuzenduaBertikal || arma instanceof MisilZuzenduaHorizontal || arma instanceof MisilZuzenduaBoom || arma instanceof Misila){
				if(ontzia.lehenIkututa()){
					ontzia.egoeraAldatu(new Ikututa());
				}else{
					ontzia.egoeraAldatu(new Osorik());
				}
			}else{ // bonba
				ontzia.egoeraAldatu(new EzkutuBakarra());
				
			}
	}
}
