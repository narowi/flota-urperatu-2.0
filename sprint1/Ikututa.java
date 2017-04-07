package sprint1;

public class Ikututa implements Egoera {
	public void jo(Ontzia ontzia, Arma arma){ 
		if(arma instanceof MisilZuzendua || arma instanceof Misila){
			ontzia.egoeraAldatu(new Urperatuta());
			ontzia.zatiGuztiakUrperatu();
			Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
			pAurkari.getListaOntziak().kenduOntzia(ontzia);
		}else{
			if(ontzia.zatirikBizirik()){
				ontzia.egoeraAldatu(new Ikututa());
				ontzia.kenduZatia();
			}else{
				ontzia.egoeraAldatu(new Urperatuta());
				ontzia.zatiGuztiakUrperatu();
				Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
				pAurkari.getListaOntziak().kenduOntzia(ontzia);
			}
		}
	
	}
}
