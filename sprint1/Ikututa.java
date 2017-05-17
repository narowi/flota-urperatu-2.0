package sprint1;


public class Ikututa implements Egoera {
		public void jo(Ontzia ontzia, Arma arma, boolean kasillaUrperatuta){ 
			if(arma instanceof MisilZuzenduaBertikal || arma instanceof MisilZuzenduaHorizontal || arma instanceof MisilZuzenduaBoom  || arma instanceof Misila){
				ontzia.egoeraAldatu(new Urperatuta());
				ontzia.zatiGuztiakUrperatu();
				
			}else{ // bonba
				if(ontzia.zatirikBizirik()){ //> 1
					ontzia.egoeraAldatu(new Ikututa());
					  
					if(!kasillaUrperatuta){
						ontzia.kenduZatia();
					}
					
				}else{
					ontzia.egoeraAldatu(new Urperatuta());
					ontzia.zatiGuztiakUrperatu();
					
				}
			}
		
		}
	}