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
	
	public void lortuEtsaiarenTableroa(Tablero pTablero){
		super.lortuEtsaiarenTableroa(pTablero);
	}
	
	public Tablero lortuNireTableroa(){
		return super.lortuNireTableroa();
	}	
	
	public void tiroEgin(){
		//Pertsonak ikusgarri izango du geratzen zaizkion armak, beraz ez bazaio gelditzen erosiko du
		
		//pertsonak tiro egiteko orduan bonba, misila, misil zuzendua erabiliko du, ez beste edozein
		Arma pArma=this.aukeratuArma();
		//Pertsonak tableroan klikatuko du zein posiziotan egin nahi duen tiro
		Kasilla posizioan=this.nonTiroEgin();
		int x=posizioan.getX();
		int y=posizioan.getY();
		
		if(pArma!=null){
			this.flota.kenduArmaKopBat(pArma);
			//Arma misil zuzendua bada aukera bat lortuko du, bestela bere balioa null izango da.
			pArma.tiroEgin(x,y,aukera);
			
//		}else{
//			System.out.println("Arma barik gelditu zara");
		}
	}
	private Arma aukeratuArma() {
		//Pertsona interfazeko aukeretatik aukeratuko du erabili nahi duen arma
		Arma a=null;
		
		return a;
	}
	private Kasilla nonTiroEgin() {
	
		return null;
	}
}
