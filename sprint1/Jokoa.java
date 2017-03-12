package sprint1;

import java.io.File;

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
		per.nireTablero.ontziaKokatu(x, y, horBert, ontzia);
		ord.nireTablero.ontziaKokatu(x, y, horBert, ontzia);
		per.etsaiarenTableroa=ord.nireTablero;
		ord.etsaiarenTableroa=per.nireTablero;
		
		
	}
}