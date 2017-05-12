package sprint1;

public class MisilZuzenduaBoom extends Arma{
	public MisilZuzenduaBoom(){
		super.biltegiZenbakia=6;
		super.prezioa=60;
		super.izena="MisilZuzenduaBoom";
	}
public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
		
		//aukera=2-> BOOM horizontal+vertical
		
		aurkariarenTableroa.setBegiratuta(x, y, true);
		int i=0;
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
//		if(aukera==0){
//			//puede haber mas de uno, while que mire todas las posiciones en horizontal y fija, x+1 hasta llegar a la luzera del tablero, y que urperatutako zatiak sean!=0
//			y=0;
//			while(i<10){			
//				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);//tengo que ir aumentando la x
//				y++;
//				if(its!=null){
//				
//					its.jo(this,kasillaUrperatuta);
//					//junit
//					aurkariarenTableroa.aldatuKasillaUkituta(x,y);
//				}
//				i++;
//			}
//		
//		}else if(aukera==1){
//			x=0;
//			while(i<10){
//				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);
//				x++;
//				if(its!=null){
//					its.jo(this,kasillaUrperatuta);
//				}
//				i++;
//			}
//		}else{
			int lagx=0;
			int lagy=0;
			//lehenengo bertikalean begiratu
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(lagx,y);
				lagx++;
				if(its!=null){
					its.jo(this,kasillaUrperatuta);
				}
				i++;
			}
			i=0;
			//horizontalean begiratu
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,lagy);
				lagy++;
				if(its!=null){
					its.jo(this,kasillaUrperatuta);
				}
				i++;
			}
				
//		}	
	}
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
}

