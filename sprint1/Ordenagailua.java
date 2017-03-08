package sprint1;

public class Ordenagailua extends Jokalaria  {
	
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
		String horBert;
		int tamaina=0;
		boolean koordenatuZuzenak;
			do{
				tamaina=o.getHondoratuGabekoZatiKop();
				x=this.lortuKoordenatua();
				y= this.lortuKoordenatua();
				horBert= this.lortuPos();
				koordenatuZuzenak = super.kokapenZuzena(x,y,horBert,tamaina); 
			
			}while(!koordenatuZuzenak);
			super.flota.kenduOntzia(o);
			super.nireTablero.ontziaKokatu(x,y,horBert,o);
		
	}
	
	private int lortuKoordenatua(){
		int pos = (int)(Math.random()*(super.nireTablero.getTamaina()+1));
		return pos;
	}
	
	private String lortuPos(){
		int pos = (int)(Math.random()*2);
		if(pos==0){
			return ("Bertikal");
		} else{
			return ("Horizontal");
		}
	}
	
	

	
	
	public void ezkutuaJarri(){
		int i= 0;
		while(i!=super.flota.ezkutuKop()){
			int x = (int)(Math.random()*(super.nireTablero.getTamaina()));
			int y = (int)(Math.random()*(super.nireTablero.getTamaina()));
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.ezkutuaDauka(ontzi)) {
					super.flota.ezkutuaJarri(ontzi);
					super.flota.ezkutuKopuruaTxikitu();
				}
			}
			i++;			
			
		}
			
		
	}

}
