package sprint1;

public class EzkutuOsoa implements Egoera{
	public EzkutuOsoa(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
		//if(arma instanceof MisilZuzendua || arma instanceof Misila){
			//arma.eskutuOsoaKenduBehar() boolean
			//irsasontzi antesestabastocado() boolran mirar urperatuako zariak y luzera
			if(arma.ezkutuOsoaKenduBehar()){ // si le a caido un misil
				if(ontzia.lehenIkututa()){
					ontzia.egoeraAldatu(new Ikututa());
				}else{
					ontzia.egoeraAldatu(new Osorik());
				}
			}else{ //una bonba
				ontzia.egoeraAldatu(new EzkutuBakarra());
				
			}
	}
}
