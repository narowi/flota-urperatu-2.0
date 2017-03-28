package sprint1;

import ui.Proba;

public class Pertsona extends Jokalaria {
	
	public Pertsona(){
	}
	public void ontziakKokatu(){
		while(!super.flota.isEmpty()){
			super.nireTablero.kokatu(x,y,o,norabide);
		}
	}
	public void ezkutuaJarri(){
			//banaka jarriko ditu ontziak eskutuan
		Integer[] aux2 = new Integer[2];
		aux2 = Proba.koordenatuakItzuli();
		int x=aux2[0];
		int y=aux2[1];
		if(super.flota.badagoEzkuturik()){ 
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.barkuakEzkutuaDauka(ontzi) && super.flota.urperatuGabekoKop(ontzi)>0) {
					 
					super.flota.egoeraAldatu(ontzi);
					super.flota.ezkutuKopuruaTxikitu();
				}
			}			
		}else{
			System.out.println("Ez duzu ezkutu gehiagorik");
		}
	}	
}
