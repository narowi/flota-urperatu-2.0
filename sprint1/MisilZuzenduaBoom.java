package sprint1;

public class MisilZuzenduaBoom extends Arma{
	public MisilZuzenduaBoom(){
		super.biltegiZenbakia=6;
		super.prezioa=60;
		super.izena="MisilZuzenduaBoom";
	}
public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
			int i=0;
			boolean lehenAldia=false;
			boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
				int lagx=0;
				while(i<10){			
					Ontzia its = aurkariarenTableroa.itsasontzirikDago(lagx,y);//tengo que ir aumentando la x

					if(its!=null){
						if(!lehenAldia){
							its.jo(this,kasillaUrperatuta);
							lehenAldia=true;
						}
						//junit
						//aurkariarenTableroa.aldatuKasillaUkituta(x,y);
					}
					else{
						lehenAldia=false;
					}
					aurkariarenTableroa.setBegiratuta(lagx, y, true);
					lagx++;
					i++;
				}
				i=0;
				lehenAldia=false;
				int lagy=0;
				while(i<10){
					Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,lagy);

					if(its!=null){
						if(!lehenAldia){
							its.jo(this,kasillaUrperatuta);
							lehenAldia=true;
						}
						//junit
						//aurkariarenTableroa.aldatuKasillaUkituta(x,y);
					}
					else{
						lehenAldia=false;
					}
					aurkariarenTableroa.setBegiratuta(x, lagy, true);
					lagy++;
				i++;
				}
//		}	
	}
}

