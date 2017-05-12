package sprint1;


public class Ikututa implements Egoera {
		public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
			if(arma instanceof MisilZuzenduaBertikal || arma instanceof MisilZuzenduaHorizontal || arma instanceof MisilZuzenduaBoom  || arma instanceof Misila){
				ontzia.egoeraAldatu(new Urperatuta());
				ontzia.zatiGuztiakUrperatu();
				//Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
				//pAurkari.getListaOntziak().kenduOntzia(ontzia);
			}else{ //si en una bonba
				if(ontzia.zatirikBizirik()){ //> 1
					ontzia.egoeraAldatu(new Ikututa());
					//si la x y y no esta urperatuta  
					if(!kasillaUrperatuta){
						ontzia.kenduZatia();
					}
				}else{
					ontzia.egoeraAldatu(new Urperatuta());
					ontzia.zatiGuztiakUrperatu();
					//Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
					//pAurkari.getListaOntziak().kenduOntzia(ontzia);
				}
			}
		
		}
	}