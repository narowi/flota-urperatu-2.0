package sprint1;

public class Osorik implements Egoera{
	public Osorik(){}
	public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
		if(arma instanceof MisilZuzendua || arma instanceof Misila){
			ontzia.egoeraAldatu(new Urperatuta());
			ontzia.zatiGuztiakUrperatu();
			Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
			pAurkari.getListaOntziak().kenduOntzia(ontzia);
		}else{
			ontzia.egoeraAldatu(new Ikututa());
			ontzia.kenduZatia();
		}
	
}
}
