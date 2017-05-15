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
			y=0;
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);
				aurkariarenTableroa.setBegiratuta(x, y, true);
				y++;
				if(its!=null){
					if(!lehenAldia){
						its.jo(this,kasillaUrperatuta);
						lehenAldia=true;
					}
				}
				else{
					lehenAldia=false;
				}
			i++;
			}
			
}	
	
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
}

