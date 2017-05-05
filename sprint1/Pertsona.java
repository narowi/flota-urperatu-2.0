package sprint1;

import javax.swing.JOptionPane;

import ui.ErroreKudeatzailea;
import ui.WarningKudeatzailea;


public class Pertsona extends Jokalaria {
	
	public Pertsona(){
		//super();
		//super.nireTablero=new Tablero();
		//super.flota=new Flota();
	}
	public void ontziakKokatu(){ //miralo naroa
		
	}
	public boolean ezkutuaJarri(int x,int y){
			//banaka jarriko ditu ontziak eskutuan
		boolean jarri=false;
		if(super.flota.badagoEzkuturik()){ 
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.barkuakEzkutuaDauka(ontzi) && super.flota.urperatuGabekoKop(ontzi)>0) {
					 jarri=true;
					super.flota.egoeraAldatu(ontzi);
					super.flota.ezkutuKopuruaTxikitu();
				}
			}
			else{
				//System.out.println("gelaxka horretan ez dago ontzirik");
				new WarningKudeatzailea("ez dago ontzirik gelaxka horretan");
				
			}
		}else{
			//System.out.println("Ez duzu ezkutu gehiagorik");
			new ErroreKudeatzailea("ezkuturik ez");
		}
		return jarri;
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
		   Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		   a.tiroEgin(x,y,aukera,pAurkari);
		   
		  }
		 }
	
	public void armaAukeratuErosteko(String arma){
		
		Arma a=this.flota.armamentuaLortu().armaSortu(arma);
		this.flota.armaErosi(a);
		
	}
	public boolean OntziaKokatu(int x,int y,String ontziMota,char norabide){
		boolean kokatuDa=false;
		Ontzia o=this.flota.lortuOntziaStringetik(ontziMota);
		if(o!=null){
		nireTablero.kokatu(x, y, o, norabide);
		kokatuDa=true;
		}
		else{
			//System.out.println("no te quedan barcos de es tipo");
			new ErroreKudeatzailea("ez dago mota horretako ontzirik");
			//JOptionPane.showMessageDialog(null, "hdsj", "jshf", JOptionPane.ERROR_MESSAGE);
		}
		return kokatuDa;
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
	
	public boolean bobarikJartzenJarraitu(){
		return this.flota.bobarikJartzenJarraitu();
	}
	public boolean misilakJartzenJarraitu() {
		return this.flota.misilakJartzenJarraitu();
	}
	public boolean misilZuzenduakJartzenJarraitu() {
		return this.flota.misilZuzenduakJartzenJarraitu();
	}
	public boolean radarrakJartzenJarraitu() {
		return this.flota.radarraJartzenJarraitu();
	}
	public boolean ezkutuakJartzenJarraitu() {
		return this.flota.ezkutuakJartzenJarraitu();
	}
}
	
	
