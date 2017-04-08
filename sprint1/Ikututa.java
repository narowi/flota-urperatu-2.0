package sprint1;

public class Ikututa implements Egoera {
	public void jo(Ontzia ontzia, Arma arma){ 
		if(arma instanceof MisilZuzendua || arma instanceof Misila){
			ontzia.egoeraAldatu(new Urperatuta());
			ontzia.zatiGuztiakUrperatu();
			Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
			pAurkari.getListaOntziak().kenduOntzia(ontzia);
		}else{
			if(ontzia.zatirikBizirik()){	//bonba bat gainean jaisten zaionean, 
				//baina bonba jasitean, urperatutako zatian ez da izango pertsonak dakielako posizio horretan urperatuta dagoela
				//zelan adierazi zein den bereziki urperatu berri den bere x y?
				ontzia.kenduZatia();
				ontzia.egoeraAldatu(new Ikututa());
				
			}else{
				ontzia.egoeraAldatu(new Urperatuta());
				ontzia.zatiGuztiakUrperatu();
				Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
				pAurkari.getListaOntziak().kenduOntzia(ontzia);
			}
		}
	
	}
}
