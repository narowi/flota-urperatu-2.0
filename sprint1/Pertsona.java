package sprint1;

import javax.swing.JOptionPane;

import ui.ErroreKudeatzailea;
import ui.WarningKudeatzailea;


public class Pertsona extends Jokalaria {
	
	public Pertsona(){
		//super();
		
	}
	public void ontziakKokatu(){ 
		
	}
	public int ezkutuaJarri(int x,int y){
			
		int w=-1;
		if(super.flota.badagoEzkuturik()){ 
			Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
			if(ontzi!=null){
				if(!super.flota.barkuakEzkutuaDauka(ontzi)){
						if(super.flota.urperatuGabekoKop(ontzi)>0) {
							w=0;
							super.flota.egoeraAldatu(ontzi);
							super.flota.ezkutuKopuruaTxikitu();
						}
						else{
							w=4;
						}
				}else{
					//ontziak ezkutua du(Warning)
					w=2;
				}
			}
			else{
				
				//new WarningKudeatzailea("ez dago ontzirik gelaxka horretan");
				w=1;
			}
		}else{
			
			//new ErroreKudeatzailea("ezkuturik ez");
			w=3;
		}
		return w;
	}
	
//	public void lortuEtsaiarenTableroa(Tablero pTablero){
//		super.lortuEtsaiarenTableroa(pTablero);
//	}
	
//	public Tablero lortuNireTableroa(){
//		return super.lortuNireTableroa();
//	}	
	
	public boolean tiroEgin(String armaNorabide, int x, int y){

		  Arma a;
		 boolean ahal=false;
		 a=this.flota.geratzenZaitArmaHau(armaNorabide);
		 System.out.println("arma honekin tiro"+a);
		 if(a!=null ){ 
		   
			 if(this.flota.kenduArmaKopBat(a)){
		   //Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();//JUNIT
		   a.tiroEgin(x,y,etsaiarenTableroa);
		   System.out.println("pertsonak tiro egin du");
		   ahal=true;
			 }
		 }
		 return ahal;
	}
	
	public int armaAukeratuErosteko(String arma){
		int i=-1;
		if(arma.equals("Bonba")){
			i=0;
		}
		else if(arma.equals("Ezkutua")){
			i=1;
		}
		else if(arma.equals("Misila")){
			i=2;
		}else if(arma.equals("MisilZuzenduaBertikal")){
			i=3;
		}else if(arma.equals("Radar")){
			i=4;
		}else if(arma.equals("MisilZuzenduaHorizontal")){
			i=5;
		}else if(arma.equals("MisilZuzenduaBoom")){
			i=6;
		}	
		
		return this.flota.armaErosi(i);
		
	}
	public int OntziaKokatu(int x,int y,String ontziMota,char norabide){
		int i=-1;
		Ontzia o=this.flota.lortuOntziaStringetik(ontziMota);
		if(o!=null){
			int n=nireTablero.kokatu(x, y, o, norabide);
			if(n==1){
				i=2;
			}
			else{
				i=0;
			}
		}
		else{
			i=1;

//			new ErroreKudeatzailea("ez dago mota horretako ontzirik");
//			//JOptionPane.showMessageDialog(null, "hdsj", "jshf", JOptionPane.ERROR_MESSAGE);
		}
		return i;
	}
	
	
	public int ontziaKonpondu(int x, int y) {
		int k=-1;
		Ontzia o= super.lortuOntzia(x,y);
		if(!o.dagoOsorik()){
			if(diruNahikoa(o)){ //teniendo en cuenta que solo arregla un cacho en cada txanda
				super.diruaKendu(o); //descontar el dinero que le a costado de su dinero
				o.konponduOntzia(); //sumar urperatuGabekoZatiKop+1
				o.egoeraEsleitu();
				nireTablero.setBegiratuta(x, y, false);
				k=0;
				
			}else{
				//new WarningKudeatzailea("ez duzu diru nahikorik");
				k=1;
			}
		}else{
			//new ErroreKudeatzailea("ontzia osorik dago");
			k=2;
		}
		return k;
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
	
	//JUnit
	
	public int armamentuarenLuzera() {
		return this.flota.armamentuarenLuzera();
	}
	
	
}
	
	
