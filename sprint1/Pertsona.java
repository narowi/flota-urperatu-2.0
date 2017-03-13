package sprint1;

public class Pertsona extends Jokalaria {

	public Pertsona(){
		
	}
	public void ontziakKokatu(){
	//TO DO	
	}
	public void ezkutuaJarri(int x,int y){//mirar como pasar la posicion para el ezkutu
			//banaka jarriko ditu ontziak eskutuan
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
}
