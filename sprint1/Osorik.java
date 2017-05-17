package sprint1;

public class Osorik implements Egoera{
	public Osorik(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
		if(arma instanceof MisilZuzenduaBertikal || arma instanceof MisilZuzenduaHorizontal || arma instanceof MisilZuzenduaBoom || arma instanceof Misila){
			ontzia.egoeraAldatu(new Urperatuta());
			ontzia.zatiGuztiakUrperatu();
			
		}else{
			ontzia.egoeraAldatu(new Ikututa());
			ontzia.kenduZatia();
		}
	
}
}
