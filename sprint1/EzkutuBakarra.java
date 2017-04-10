package sprint1;

public class EzkutuBakarra implements Egoera {
	public EzkutuBakarra(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ // en vez de implementar jo en ontzi, depende de la egoera, en cada egoera
		//arma.eskutuOsoaKenduBehar() boolean
		//irsasontzi antesestabastocado() boolran mirar urperatuako zariak y luzera
		if(ontzia.lehenIkututa()){
			ontzia.egoeraAldatu(new Ikututa());
			
		}else{
			ontzia.egoeraAldatu(new Osorik());
		}
		
	}
}
