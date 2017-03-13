package sprint1;

public class Jokoa {
	private Ordenagailua ord;
	private Pertsona per;
	private int txanda;
	private static Jokoa nireJokoa = null;
	
	private Jokoa() {
    	this.txanda=0;
    	this.ord= new Ordenagailua();
		this.per= new Pertsona();
	}
	
	public static Jokoa getNireJokoa() {
		if(nireJokoa == null) {
			nireJokoa = new Jokoa();
		}
		return nireJokoa;
	}
	
	public static void main(String[] args) {
		nireJokoa = Jokoa.getNireJokoa();
		nireJokoa.jokoaHasieratu();
	}

	private void jokoaHasieratu() {
		ord.ontziakKokatu();
		per.ontziakKokatu();
		ord.lortuEtsaiarenTableroa(per.lortuNireTableroa());
    	per.lortuEtsaiarenTableroa(ord.lortuNireTableroa());
		
		
	}
}
