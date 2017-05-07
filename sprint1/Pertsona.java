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
	
	public void tiroEgin(String armaNorabide, int x, int y){
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
		   Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		   a.tiroEgin(x,y,aukera,pAurkari);
		   
		 }
	}
	
	public void armaAukeratuErosteko(String arma){
		//Arma a= this.flota.lortuArmaStringetik(arma);
		Arma a=this.flota.armaSortu(arma);
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
	
	
	public void ontziaKonpondu(int x, int y) {
		Ontzia o= super.lortuOntzia(x,y);
		if(!o.dagoOsorik()){
			if(diruNahikoa(o)){ //teniendo en cuenta que solo arregla un cacho en cada txanda
				super.diruaKendu(o); //descontar el dinero que le a costado de su dinero
				o.konponduOntzia(); //sumar urperatuGabekoZatiKop+1
				o.egoeraEsleitu();
				
			}else{
				new WarningKudeatzailea("ez duzu diru nahikorik");
			}
		}else{
			new ErroreKudeatzailea("ontzia osorik dago");
		}
		
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
	public int armamentuarenLuzera() {
		return this.flota.armamentuarenLuzera();
	}
}
	
	
