package sprint1;

public class MisilZuzendua extends Arma {
	public MisilZuzendua(){
		super.biltegiZenbakia=3;
		super.prezioa=60;
		super.izena="MisilZuzendua";
	}
public void tiroEgin(int x, int y,int aukera){
		
		//aukera=0-> IH, aukera=1-> EM, aukera=2-> BOOM
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		Tablero aurkariarenTableroa =pAurkari.lortuEtsaiarenTableroa2();
		aurkariarenTableroa.setBegiratuta(x, y, true);
		int i=0;
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
		if(aukera==0){
			//puede haber mas de uno, while que mire todas las posiciones en horizontal y fija, x+1 hasta llegar a la luzera del tablero, y que urperatutako zatiak sean!=0
			x=0;
			while(i<10){			
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);//tengo que ir aumentando la x
				x++;
				if(its!=null){
				
					its.jo(this,kasillaUrperatuta);
					//junit
					aurkariarenTableroa.aldatuKasillaUkituta(x,y);
				}
				i++;
			}
		
		}else if(aukera==1){
			y=0;
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,y);
				y++;
				if(its!=null){
					its.jo(this,kasillaUrperatuta);
				}
			}
		}else{
			int lagx=0;
			int lagy=0;
			//lehenengo horizontalean begiratu
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(lagx,y);
				lagx++;
				if(its!=null){
					its.jo(this,kasillaUrperatuta);
				}
				i++;
			}
			i=0;
			//bertikalean begiratu
			while(i<10){
				Ontzia its = aurkariarenTableroa.itsasontzirikDago(x,lagy);
				lagy++;
				if(its!=null){
					its.jo(this,kasillaUrperatuta);
				}
			}
				
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
