package sprint1;

public class MisilZuzenduaBertikal extends Arma {
	public MisilZuzenduaBertikal(){
		super.biltegiZenbakia=3;
		super.prezioa=60;
		super.izena="MisilZuzenduaBertikal";
	}
public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
		System.out.println("tiro egin metodoan sartu misilzuz vert klasean");
		//aukera=0-> IH vertical, aukera=1-> EM horizontal, aukera=2-> BOOM horizontal+vertical
		
		int i=0;
		boolean lehenAldia=false;
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
			x=0;
			while(i<10){			
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);//tengo que ir aumentando la x

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
				aurkariarenTableroa.setBegiratuta(x, y, true);
				x++;
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
