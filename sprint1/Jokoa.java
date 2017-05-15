package sprint1;

import java.io.File;
import ui.*;

public class Jokoa {
	private Ordenagailua ord;
	private Pertsona per;
	private int txanda;
	private static Jokoa nireJokoa = null;
	
	private Jokoa() {
		this.ord= new Ordenagailua();
		this.per= new Pertsona();
    	this.txanda=0;
	}
	
	public static Jokoa getNireJokoa() {
		if(nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public static void main(String[] args) {
		nireJokoa = Jokoa.getNireJokoa();
		nireJokoa.partidaBatJolastu();
	}

	private void partidaBatJolastu() {
		//per.etsaiarenTableroa=ord.nireTablero;
		//ord.etsaiarenTableroa=per.nireTablero;
		//jokoaHasieratu();
		per.setEtsaiarenTablero(ord.getTablero());
		ord.setEtsaiarenTablero(per.getTablero());
		ord.ontziakKokatu();
		ord.ezkutuaJarri();
		new FlotaJokoa().main(null);
		//while(!amaitu){
			//ontziak kokatu
			//depende la txanda hace tiro uno o otro
		//}
		
		
	}
	//JUniterako metodoa
	private void jokoaHasieratu(){
		//per.createTablero();
		//per.etsaiariNireTableroaEsleitu();
		//ord.createTablero();
		//ord.etsaiariNireTableroaEsleitu();
		Flota fPers= new Flota();
		Flota fOrd= new Flota();
		fPers.armakEsleitu();
		fOrd.armakEsleitu();
		per.setFlota(fPers);
		ord.setFlota(fOrd);
		
		Biltegia.getNireBiltegia().hasieratu();
	}
	public Jokalaria aurkariaLortu() {
		if((this.txanda)%2==0){
			return per;
		}else{
			return ord;
		}
	}
	
	public Tablero getTablero(){
		return per.lortuNireTableroa();
	}

	public Jokalaria jokalariaLortu() {
		if((this.txanda)%2==0){
			return ord;
		}else{
			return per;
		}
	}

	public boolean itsaspekoKokatzenJarraituAhal() {
		return per.itsaspekoKokatzenJarraituAhal();
	}

	public boolean fragataKokatzenJarraituAhal() {
		return per.fragataKokatzenJarraituAhal();
	}

	public boolean suntsitzaileKokatzenJarraituAhal() {
		return per.suntsitzaileKokatzenJarraituAhal();
	}

	public boolean hegazkinOntziKokatzenJarraituAhal() {
		return per.hegazkinOntziKokatzenJarraituAhal();
	}
//	public boolean bonbakErabiltzenJarraituAhal(){
//		return per.bobarikJartzenJarraitu();
//	}
//	public boolean misilakErabiltzenJarraituAhal(){
//		return per.misilakJartzenJarraitu();
//	}
//	public boolean misilZuzenduakErabiltzenJarraituAhal(){
//		return per.misilZuzenduakJartzenJarraitu();
//	}
//	public boolean radarrakErabiltzenJarraituAhal(){
//		return per.radarrakJartzenJarraitu();
//	}
//	public boolean ezkutuakErabiltzenJarraituAhal(){
//		return per.ezkutuakJartzenJarraitu();
//	}

	public int kokatu(int x, int y, String aukeratutakoOntzia, char kokapena) {
		return per.OntziaKokatu(x, y, aukeratutakoOntzia, kokapena);
		
	}

	public String zerDaKasillaHau(int x, int y,String norena) {
		String zerDa=" ";
		if(norena.equals("pertsona")){
			zerDa=per.zerDaKasillaHau(x,y);
		}
		else{
			zerDa=ord.zerDaKasillaHau(x, y);
		}
		//System.out.println(zerDa+" jokoan hau da");
		return zerDa;
	}

	public int ezktuaJarri(Integer x, Integer y) {
		return per.ezkutuaJarri(x, y);
		}
	
	//junit
		public Ordenagailua ordLortu() {
			return this.ord; 
		}
		public Pertsona perLortu(){
			return this.per;
		}
		
		public Armamentua ordArmamentuaLortu(){
			return this.ord.armamentuaItzuli();
		}

		public Tablero ordTableroaLortu() {
			return this.ord.lortuNireTableroa();
		}
		
		public Tablero perTableroaLortu() {
			return this.per.lortuNireTableroa();
		}

		public void tiroEgin(String arma, Integer x, Integer y) {
			this.per.tiroEgin(arma,x,y);
			//this.ordTxanda();
		}

		private void ordTxanda() {
			boolean amaitua=false;
			while(!amaitua){
			int aukera= (int)(Math.random()*5);
			if(aukera==0){
				//tiroegin
			 }
			else if(aukera==1){
				//konpondu
			}
			else if(aukera==2){
				//Erosi
			}
			else if(aukera==3){
				//ezkutua jarri
			}
			else if(aukera==4){
				//radarra kontsultatu
			}
			}
		}

		public int armaErosi(String arma) {
			return this.per.armaAukeratuErosteko(arma);
			
		}

		public int ontziaKonpondu(int x, int y) {
			return this.per.ontziaKonpondu(x,y);
			
		}

		public int[] radarraKontsultatu() {
			return this.per.radarraKontsultatu();
			
		}

		public boolean begiratua(int i, int j, String norena) {
			if(norena.equals("ordenagailua")){
				return ord.begiratu(i,j);
			}
			else{
				return true;
			}
		}
}
