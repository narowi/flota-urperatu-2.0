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
		aurkariarenTableroa.setBegiratuta(x, y, true);
		int i=0;
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
			y=0;
			while(i<10){			
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);//tengo que ir aumentando la x
				y++;
				if(its!=null){
				
					its.jo(this,kasillaUrperatuta);
					//junit
					aurkariarenTableroa.aldatuKasillaUkituta(x,y);
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
