package sprint1;

public class MisilZuzenduaHorizontal extends Arma{
	public MisilZuzenduaHorizontal(){
		super.biltegiZenbakia=5;
		super.prezioa=60;
		super.izena="MisilZuzenduaHorizontal";
	}
public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
		
		//aukera=0-> IH vertical, aukera=1-> EM horizontal, aukera=2-> BOOM horizontal+vertical
		
		//Tablero aurkariarenTableroa = pAurkari.getTablero();
		
		int i=0;
		boolean lehenAldia=false;
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
			y=0;
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);

				if(its!=null){
					if(!lehenAldia){
						its.jo(this,kasillaUrperatuta);
						lehenAldia=true;
					}
				}
				else{
					lehenAldia=false;
				}
				aurkariarenTableroa.setBegiratuta(x, y, true);
				y++;
			i++;
			}
			
}	
	
//	public  boolean posizioHorretakoArmaDa(int pos){
//		if(pos==this.biltegiZenbakia){
//			return true;
//		}else{
//			return false;
//		}
//	}
}

