package sprint1;


public abstract class Jokalaria {

	protected Tablero nireTablero;
	protected Tablero etsaiarenTableroa;
	protected Flota flota;
	protected int radarKontsultaKop;
	
	public Jokalaria(Tablero nireT, Tablero etsaiaT, Flota f){
		nireTablero=nireT;
		etsaiarenTableroa=etsaiaT;
		flota=f;
		radarKontsultaKop=2;
	}
	
	public abstract void ontziakKokatu(); 

	public abstract void ezkutuaJarri();
	
}
		
