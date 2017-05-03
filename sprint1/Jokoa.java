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
		per.etsaiarenTableroa=ord.nireTablero;
		ord.etsaiarenTableroa=per.nireTablero;
		new FlotaJokoa().main(null);
		
		
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
	public boolean bonbakErabiltzenJarraituAhal(){
		return per.bobarikJartzenJarraitu();
	}
	public boolean misilakErabiltzenJarraituAhal(){
		return per.misilakJartzenJarraitu();
	}
	public boolean misilZuzenduakErabiltzenJarraituAhal(){
		return per.misilZuzenduakJartzenJarraitu();
	}
	public boolean radarrakErabiltzenJarraituAhal(){
		return per.radarrakJartzenJarraitu();
	}
	public boolean ezkutuakErabiltzenJarraituAhal(){
		return per.ezkutuakJartzenJarraitu();
	}

	public boolean kokatu(int x, int y, String aukeratutakoOntzia, char kokapena) {
		return per.OntziaKokatu(x, y, aukeratutakoOntzia, kokapena);
		
	}
}
