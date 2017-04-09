package sprint1;


public abstract class Jokalaria {

	protected Tablero nireTablero;
	protected Tablero etsaiarenTableroa;
	protected Flota flota;
	protected int radarKontsultaKop;
	
	public Jokalaria(){
		nireTablero=new Tablero();
		flota=new Flota();
		radarKontsultaKop=2;
	}
	
	public abstract void ontziakKokatu(); 

	public abstract void ezkutuaJarri();
	
	public void lortuEtsaiarenTableroa(Tablero pTablero){
		etsaiarenTableroa=pTablero;
	}
	public Tablero lortuNireTableroa(){
		return nireTablero;
	}
	public Tablero lortuEtsaiarenTableroa2(){
		return this.etsaiarenTableroa;
	}

	public Flota getListaOntziak() {
		return this.flota;
		
	}
	
	public int zenbatOntzi(){
		return this.flota.zenbatOntzi();
	}

	public Arma lortuArma(int biltegiZenbakikoArma) {
		return this.flota.lortuArma(biltegiZenbakikoArma);
	}
	
	public boolean armarikDago(int biltegiZenbakikoArma){
		return this.flota.armarikDago(biltegiZenbakikoArma);
	}

	
}
		
