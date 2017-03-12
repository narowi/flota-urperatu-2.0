package sprint1;

import java.util.Random;

public class Ordenagailua extends Jokalaria  {
	
	public Ordenagailua(Tablero nireTablero, Tablero etsaiarenTableroa, Flota flota){
		super(nireTablero, etsaiarenTableroa, flota);
	}
	
	public void ontziakKokatu(){
		Ontzia o;
		while(!super.flota.isEmpty()){
			o= super.flota.lortuOntzia();
			ontziaKokatu(o);
		}
	}
	
	
	
	
	public void ontziaKokatu(Ontzia o){
		int x;
		int y;
		char[] horBert;
		char pos;
		int tamaina=0;
		//boolean koordenatuZuzenak;
			//do{
				tamaina=o.getHondoratuGabekoZatiKop();
				x=this.lortuKoordenatua();
				y= this.lortuKoordenatua();
				horBert= super.nireTablero.norabideaAukeratu(x, y, o);
				pos= this.lortuPos(horBert);
				//koordenatuZuzenak = super.kokapenZuzena(x,y,horBert,tamaina); 
	
			//}while(!koordenatuZuzenak);
			super.flota.kenduOntzia(o);
			super.nireTablero.kokatu(x, y, o, pos);	
	}
	
	private int lortuKoordenatua(){
		int pos = (int)(Math.random()*(super.nireTablero.getTamaina()+1));
		return pos;
	}
	
	private char lortuPos(char[] pos){
		int i=0;
		boolean zuzena=false;
		while(!zuzena){
			 i = (int)(Math.random()*3);
			if(pos[i]!=0){
				zuzena=true;
			}
		}
		if(i == 0){
			return 's';
		}else if(i == 1){
			return 'z';
		}else if (i==2){
			return 'g';
		}else{
			return 'b';
		}
		
	}
	
	

	
	
	public void ezkutuaJarri(){
		
		int i= 0;
		while(i!=super.flota.ezkutuKop()){
			int x = (int)(Math.random()*(super.nireTablero.getTamaina()));
			int y = (int)(Math.random()*(super.nireTablero.getTamaina()));
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.ezkutuaDauka(ontzi) && super.flota.urperatuGabekoKop(ontzi)>0) {
					//super.flota.ezkutuaJarri(ontzi); 
					super.flota.egoeraAldatu(ontzi);
					super.flota.ezkutuKopuruaTxikitu();
				}
			}
			i++;			
			
		}
			
		
	}

}
