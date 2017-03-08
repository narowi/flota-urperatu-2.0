package sprint1;

public class Pertsona extends Jokalaria {

	public Pertsona(){

		

	}

		public void ontziakKokatu(Ontzia pOntzia, int x, int y, String posHoriBert){

			int tamaina = pOntzia.getHondoratuGabekoZatiKop();

			boolean kokapenZuzena;

	

		do{

		

			kokapenZuzena=super.kokapenZuzena(x,y,posHoriBert, tamaina);

			if(!kokapenZuzena){

//				//pantallita: sartu dituzun koordenatuaetan ezin da	

			}

		}while(!kokapenZuzena);	

		

		super.nireTablero.ontziaJarri(x,y,tamaina,posHoriBert,pOntzia);

		super.nireTablero.ontziInguruanUraJarri(x,y,tamaina,posHoriBert);

		super.flota.kenduOntzia(pOntzia);// PERO SI HAGO ESTO LO QUITO DE LA ZERRENDA Y LO QUIERO QUITAR DE LA ZERRENDA MIA 

		}

	

		public void ezkutuaJarri(){

			//lortu x y tableroan egongo da, ontzia dagoen toki gainean jarribeharko da

			//al barco o a la casilla para saber si tiene ezkutuu

			

		}

		

		



}
