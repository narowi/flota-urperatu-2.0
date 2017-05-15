package sprint1;

public class MisilZuzenduaBoom extends Arma{
	public MisilZuzenduaBoom(){
		super.biltegiZenbakia=6;
		super.prezioa=60;
		super.izena="MisilZuzenduaBoom";
	}
public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
		
		//aukera=2-> BOOM horizontal+vertical
//		
//		
//		int i=0;
//		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
//			int lagx=0;
//			int lagy=0;
//			//lehenengo bertikalean begiratu
//			while(i<10){
//				Ontzia its = aurkariarenTableroa.itsasontzirikDago(lagx,y);
//				aurkariarenTableroa.setBegiratuta(lagx, y, true);
//				lagx++;
//				if(its!=null){
//					its.jo(this,kasillaUrperatuta);
//				}
//				i++;
//			}
//			i=0;
//			//horizontalean begiratu
//			while(i<10){
//				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,lagy);
//				aurkariarenTableroa.setBegiratuta(x, lagy, true);
//				lagy++;
//				if(its!=null){
//					its.jo(this,kasillaUrperatuta);
//				}
//				i++;
//			}
				
			int i=0;
			boolean lehenAldia=false;
			boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
				int lagx=0;
				while(i<10){			
					Ontzia its = aurkariarenTableroa.itsasontzirikDago(lagx,y);//tengo que ir aumentando la x
					aurkariarenTableroa.setBegiratuta(lagx, y, true);
					lagx++;
					if(its!=null){
						if(!lehenAldia){
							its.jo(this,kasillaUrperatuta);
							lehenAldia=true;
						}
						//junit
						//aurkariarenTableroa.aldatuKasillaUkituta(x,y);
					}
					i++;
				}
				i=0;
				lehenAldia=false;
				int lagy=0;
				while(i<10){
					Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,lagy);
					aurkariarenTableroa.setBegiratuta(x, lagy, true);
					lagy++;
					if(its!=null){
						if(!lehenAldia){
							its.jo(this,kasillaUrperatuta);
							lehenAldia=true;
						}
						//junit
						//aurkariarenTableroa.aldatuKasillaUkituta(x,y);
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

