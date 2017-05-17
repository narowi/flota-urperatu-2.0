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
	

	public int ontziaKonpondu(int x, int y){
		//primero mirar si hay un barco destruido 
		//int bai= (int)(Math.random()*2);
		//if(bai==0){
		boolean listo=false;
		Ontzia on=null;
		if(super.flota.badagoOntzirikSuntsituta()){
			System.out.println("Ordenagailua ontzia konpontzen");
			while(!listo){
				int oPos = (int)(Math.random()*super.luzera()-1);
				int px= lortuKoordenatua();
				int py=lortuKoordenatua();
				on= super.lortuOntzia(px,py);
				if(on!=null && !on.dagoOsorik()){
					listo=true;
					System.out.println(px+"/"+py);
				}
			}
			if(listo){
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
		}
		return 0;
	}
	public void ontziaKokatu(Ontzia o){
		int x=0;
		int y=0;
		char[] horBert;
		char pos=' ';
		boolean listo=false;
		while(!listo){
				x=this.lortuKoordenatua();
				y= this.lortuKoordenatua();
				horBert= super.nireTablero.norabideaAukeratu(x, y, o);
				if(horBert[0]=='s'||horBert[1]=='z'||horBert[2]=='g'||horBert[3]=='b'){
				pos= this.lortuPos(horBert);
				listo=true;
				}
		}
				
			int k=super.nireTablero.kokatu(x, y, o, pos);
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
	
	public void tiroEgin(){ //random
		int x;
		int y;
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		Arma arma= this.lortuArma();
		System.out.println(arma); 
		x=this.lortuKoordenatua();
		y=this.lortuKoordenatua();
		boolean zuzena= false;
		while(!zuzena){
			if(etsaiarenTableroa.begiratutaDago(x, y)){
				x=this.lortuKoordenatua();
				y=this.lortuKoordenatua();
			}else{
				zuzena =true;
			}
		}
		//pAurkari.markatuIkututa(x,y);
		if(arma!=null){
			this.flota.kenduArmaKopBat(arma);
				//int aukera=this.aukeraLortu();
				arma.tiroEgin(x,y, etsaiarenTableroa);
		}else{
			System.out.println("arma barik gelditu zara");
		}
	}
	

	private Arma lortuArma(){
		int biltegiZenbakikoArma= (int)(Math.random()*7);
		boolean armaEgokia=false;
		//Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		
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
	}
	
	public int armaAukeratuErosteko(String pArma){
		int biltegiZenbakikoArma= (int)(Math.random()*5);	
			this.flota.armaErosi(biltegiZenbakikoArma);
			return 0;
		}	
	




	public boolean begiratu(int i, int j) {
		return super.nireTablero.begiratutaDago(i, j);
	}

	public boolean armarikDauka() {
		return flota.armarikDauka();
	}
	
	
	//JUnit
	
	public int armamentuarenLuzeera() {
		return this.flota.armamentuarenLuzera();
	}
}