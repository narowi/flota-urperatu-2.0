package sprint1;



public class Pertsona extends Jokalaria {
	
	public Pertsona(){
	}
	public void ontziakKokatu(){ //miralo naroa
//		while(!super.flota.isEmpty()){
//			super.nireTablero.kokatu(x,y,o,norabide);
//		}
	}
	public void ezkutuaJarri(int x,int y){
			//banaka jarriko ditu ontziak eskutuan
		
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
	
	public void lortuEtsaiarenTableroa(Tablero pTablero){
		super.lortuEtsaiarenTableroa(pTablero);
	}
	
	public Tablero lortuNireTableroa(){
		return super.lortuNireTableroa();
	}	
	
	public void tiroEgin(Kasilla k, String armaNorabide){
		  int aukera=-1;
		  String arma;
		  Arma a;
		  if (armaNorabide=="misil zuzendua bertikal"){
		   arma="MisilZuzendua";
		   aukera=0;
		   
		  }else if(armaNorabide=="misil zuzendua horizontal"){
		   arma="MisilZuzendua"; 
		   aukera=1;
		   
		  }else if(armaNorabide=="misil zuzendua"){
		   arma="MisilZuzendua"; 
		   aukera=2;  
		   
		  }else{
		   arma=armaNorabide;
		  }
		  
		 a=this.flota.geratzenZaitArmaHau(arma);
		 if(a!=null){
			 
		   this.flota.kenduArmaKopBat(a);
		   int x=k.getX();
		   int y=k.getY();
		   a.tiroEgin(x,y,aukera);
		   
		  }
		 }
	
	public void armaAukeratuErosteko(String arma){
		
		Arma a=this.flota.armamentuaLortu().armaSortu(arma);
		this.flota.armaErosi(a);
		
	}
	
	
	
	
	
	@Override
	public void ezkutuaJarri() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void armaHautatu() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean ontziaKonponduNahi(Ontzia o) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void ontziaKonpondu(String o) {
		// TODO Auto-generated method stub
		
	}
	public boolean itsaspekoKokatzenJarraituAhal() {
		return this.flota.itsaspekoakDaude();
	}
	public boolean fragataKokatzenJarraituAhal() {
		return this.flota.fragatakDaude();
	}
	public boolean suntsitzaileKokatzenJarraituAhal() {
		return this.flota.suntsitzaileDaude();
	}
	public boolean hegazkinOntziKokatzenJarraituAhal() {
		return this.flota.hegazkinOntziDaude();
	}
}
	
	
