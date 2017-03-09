package sprint1;


public abstract class Jokalaria {

	protected Tablero nireTablero;
	protected Tablero etsaiarenTableroa;
	protected Flota flota;
	protected int radarKontsultaKop=2;
	
	public abstract void ontziakKokatu(); // lo he puesto aqui por si te sirve naroa

	public boolean kokapenZuzena(int x, int y, String posHoriBert, int tamaina){
		boolean egokia = true;
		int i = 0;
		if (posHoriBert == "Bertikal") {
			while (i < tamaina && egokia) { 
				if (this.nireTablero.koordenatuEgokiak(x+i, y)) { // en koordenatuEgokiak miro lo del agua
					if (this.nireTablero.itsasontzirikDago(x+i, y) != null) {
						egokia = false;
					}
					i++;
				} else {
					egokia = false;
				}
			}
		}else { 
			if(posHoriBert=="Horizontal"){
				while (i < tamaina && egokia) {
					if (this.nireTablero.koordenatuEgokiak(x, y+i)) {
						if (this.nireTablero.itsasontzirikDago(x, y+i) != null) {
							egokia = false;
						}
						i++;
					} else {
						egokia = false;
					}
				}
			}
		}
		return egokia;
	}

	public abstract void ezkutuaJarri();
	
	public void armaErosiNahi(){
		this.flota.armaErosi();
	}
}
		
