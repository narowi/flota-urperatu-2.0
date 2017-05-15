package sprint1;


public class Ordenagailua extends Jokalaria  {
	public Ordenagailua(){
		//super();
	}
	
	public void ontziakKokatu(){
		Ontzia o;
		int i=0;
		while(super.flota.geratzenDaOntzirik()){
			o= super.flota.lortuOntzia(i);
			ontziaKokatu(o);
			i++;
		}
	}
	
//	public boolean ontziaKonpontzekoDirua(Ontzia o){
//			if(super.diruNahikoa(o)){
//				return true;
//			}else{
//				return false;
//			}
//	}
	public void armaHautatu(){
		//TO DO
	}
	public int ontziaKonpondu(int x, int y){
		int bai= (int)(Math.random()*2);
		if(bai==0){
		int oPos = (int)(Math.random()*super.luzera()-1);
		Ontzia on = super.bilatuOntzia(oPos);
		if(!on.dagoOsorik()){
			if(diruNahikoa(on)){ //teniendo en cuenta que solo arregla un cacho en cada txanda
				super.diruaKendu(on); //descontar el dinero que le a costado de su dinero
				on.konponduOntzia(); //sumar urperatuGabekoZatiKop+1
				//if(o.urperatutaDago()){
					//super.gehituOntzia(o); IMPORTANTE! CUANDO HEMOS HUNDIDO UN BARCO NO LO HEMOS QUITADO DE LA LISTA LO QUITAMOS??? SI NO HABRA QUE SABER SI LE QUEDAN BARCOS SI LA EGOERA DE ALGUNO DE ELLOS ES !=URPERATUTA
				//}
				on.egoeraEsleitu();
				
				//cambiar de egoera al barco
			}
		}
		}else{
			System.out.println("random aukeratu du ontzia ez konpontzea");
		}return 0;
	}
	public void ontziaKokatu(Ontzia o){
		int x=0;
		int y=0;
		char[] horBert;
		char pos=' ';
		boolean listo=false;
		while(!listo){
			//System.out.println("entro en el while de ontziaKokatu");
				x=this.lortuKoordenatua();
				y= this.lortuKoordenatua();
				horBert= super.nireTablero.norabideaAukeratu(x, y, o);
				if(horBert[0]=='s'||horBert[1]=='z'||horBert[2]=='g'||horBert[3]=='b'){
				pos= this.lortuPos(horBert);
				listo=true;
				}
		}
				
			//super.flota.kenduOntzia(o);
			int k=super.nireTablero.kokatu(x, y, o, pos);
			//System.out.println("ondo kokatu naiz? "+k);
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
			// System.out.println(pos[i]);
			if(pos[i]=='s'||pos[i]=='z'||pos[i]=='g'||pos[i]=='b'){
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
	
//	public void lortuEtsaiarenTableroa(Tablero pTablero){
//		super.lortuEtsaiarenTableroa(pTablero);
//	}
	
	public Tablero lortuNireTableroa(){
		return super.lortuNireTableroa();
	}	
	public void tiroEgin(){ //random
		int x;
		int y;
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		//System.out.println("ord tableroa"+ super.nireTablero);
		//System.out.println("per tableroa"+ pAurkari.nireTablero);
		//Armamentua armamentua= Jokoa.getNireJokoa().ordArmamentuaLortu();
		//System.out.println("Ordenagailuaren armamentua" + armamentua.luzera());
		Arma arma= this.lortuArma();
		System.out.println(arma); 
		x=this.lortuKoordenatua();
		y=this.lortuKoordenatua();
		pAurkari.markatuIkututa(x,y);
		if(arma!=null){
			this.flota.kenduArmaKopBat(arma);
				//int aukera=this.aukeraLortu();
				arma.tiroEgin(x,y, etsaiarenTableroa);
		}else{
			System.out.println("arma barik gelditu zara");
		}
	}
	
	
//	private int aukeraLortu() {
//		 int i = (int)(Math.random()*3);
//		 return i;
//	}

	private Arma lortuArma(){
		int biltegiZenbakikoArma= (int)(Math.random()*7);
		boolean armaEgokia=false;
		//Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		//if(pAurkari.getListaOntziak()!=null){
			while(!armaEgokia){
				if((biltegiZenbakikoArma!=1 && biltegiZenbakikoArma!=4) && super.armarikDago(biltegiZenbakikoArma)){
					armaEgokia=true;
					//super.armaKopTxikitu(biltegiZenbakikoArma);
				}else{
				 biltegiZenbakikoArma= (int)(Math.random()*5);
				} 
			}
			if(armaEgokia){
				return super.lortuArma(biltegiZenbakikoArma);
			}else{
				return null;
			}
//		//}else{
//			System.out.println("aurkariaren ontzi guztiak urperatu dituzu");
//			return null;
//		}
	}
	
	public int armaAukeratuErosteko(String pArma){
		Arma arma=null;
		int biltegiZenbakikoArma= (int)(Math.random()*5);
		
//		if (biltegiZenbakikoArma==0){
//			//arma= this.flota.armamentuaLortu().armaSortu("Bonba");
//		}else if (biltegiZenbakikoArma==1){
//			//arma= this.flota.armamentuaLortu().armaSortu("Ezkutua");
//		}else if (biltegiZenbakikoArma==2){
//			arma= this.flota.armamentuaLortu().armaSortu("Misila");
//		}else if (biltegiZenbakikoArma==3){
//			arma= this.flota.armamentuaLortu().armaSortu("MisilZuzendua");
//		}else if(biltegiZenbakikoArma==4){
//			arma= this.flota.armamentuaLortu().armaSortu("Radar");
//		}
//		
			this.flota.armaErosi(biltegiZenbakikoArma);
			return 0;
		}	
	


	public int armamentuarenLuzeera() {
		return this.flota.armamentuarenLuzera();
	}

	public boolean begiratu(int i, int j) {
		return super.nireTablero.begiratutaDago(i, j);
	}
	}


