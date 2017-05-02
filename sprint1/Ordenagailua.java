package sprint1;


public class Ordenagailua extends Jokalaria  {
	public Ordenagailua(){
		
	}
	
	public void ontziakKokatu(){
		Ontzia o;
		while(!super.flota.isEmpty()){
			o= super.flota.lortuOntzia();
			ontziaKokatu(o);
		}
	}
	
	public boolean ontziaKonponduNahi(Ontzia o){
		if(super.diruNahikoa(o)){
			return true;
		}else{
			return false;
		}
	}
	public void armaHautatu(){
		//TO DO
	}
	public void ontziaKonpondu(String o){
		int oPos = (int)(Math.random()*super.luzera()-1);
		Ontzia on = super.bilatuOntzia(oPos);
		if(!on.dagoOsorik()){
			if(ontziaKonponduNahi(on)){ //teniendo en cuenta que solo arregla un cacho en cada txanda
				super.diruaKendu(on); //descontar el dinero que le a costado de su dinero
				on.konponduOntzia(); //sumar urperatuGabekoZatiKop+1
				//if(o.urperatutaDago()){
					//super.gehituOntzia(o); IMPORTANTE! CUANDO HEMOS HUNDIDO UN BARCO NO LO HEMOS QUITADO DE LA LISTA LO QUITAMOS??? SI NO HABRA QUE SABER SI LE QUEDAN BARCOS SI LA EGOERA DE ALGUNO DE ELLOS ES !=URPERATUTA
				//}
				on.egoeraEsleitu();
				
				//cambiar de egoera al barco
			}
		}
	}
	public void ontziaKokatu(Ontzia o){
		int x;
		int y;
		char[] horBert;
		char pos;
				x=this.lortuKoordenatua();
				y= this.lortuKoordenatua();
				horBert= super.nireTablero.norabideaAukeratu(x, y, o);
				pos= this.lortuPos(horBert);
				String oIzena= o.getMota();//sumar esto
			super.flota.kenduOntzia(o);
			super.nireTablero.kokatu(x, y, oIzena, pos);	//cambiar la variable
	}
	
	private int lortuKoordenatua(){
		int pos = (int)(Math.random()*(super.nireTablero.getTamaina()));
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
		
		while(super.flota.badagoEzkuturik()){
			int x = (int)(Math.random()*(super.nireTablero.getTamaina()));
			int y = (int)(Math.random()*(super.nireTablero.getTamaina()));
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.barkuakEzkutuaDauka(ontzi) && super.flota.urperatuGabekoKop(ontzi)>0) { 
					super.flota.egoeraAldatu(ontzi);
					super.flota.ezkutuKopuruaTxikitu();
				}
			}			
			
		}
	}
	
	public void lortuEtsaiarenTableroa(Tablero pTablero){
		super.lortuEtsaiarenTableroa(pTablero);
	}
	
	public Tablero lortuNireTableroa(){
		return super.lortuNireTableroa();
	}	
	public void tiroEgin(){ //random
		int x;
		int y;
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		//Tablero aurkariarenTableroa=pAurkari.lortuNireTableroa();
		Arma arma= this.lortuArma();
		System.out.println(arma);
		x=this.lortuKoordenatua();
		y=this.lortuKoordenatua();
		pAurkari.markatuIkututa(x,y);
		if(arma!=null){
			this.flota.kenduArmaKopBat(arma);
				int aukera=this.aukeraLortu();
				arma.tiroEgin(x,y,aukera);
		}else{
			System.out.println("arma barik gelditu zara");
		}
	}
	
	
	private int aukeraLortu() {
		 int i = (int)(Math.random()*3);
		 return i;
	}

	private Arma lortuArma(){
		int biltegiZenbakikoArma= (int)(Math.random()*5);
		boolean armaEgokia=false;
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		if(pAurkari.getListaOntziak()!=null){
			while(!armaEgokia){
				if((biltegiZenbakikoArma!=1 && biltegiZenbakikoArma!=4) && super.armarikDago(biltegiZenbakikoArma)){
					armaEgokia=true;
				}else{
				 biltegiZenbakikoArma= (int)(Math.random()*5);
				} 
			}
			if(armaEgokia){
				return super.lortuArma(biltegiZenbakikoArma);
			}else{
				return null;
			}
		}else{
			System.out.println("aurkariaren ontzi guztiak urperatu dituzu");
			return null;
		}
	}
	
	}


