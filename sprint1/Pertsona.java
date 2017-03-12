package sprint1;

public class Pertsona extends Jokalaria {

	public Pertsona(){

	}
	public void ontziakKokatu(){
	//TO DO	
	}
	public void ezkutuaJarri(int x,int y){
			//banaka jarriko ditu ontziak eskutuan
			if(super.flota.ezkutuKop()>0){ 
				Ontzia ontzi=super.nireTablero.itsasontzirikDago(x,y);
				if(ontzi!=null){
					if(!super.flota.ezkutuaDauka(ontzi) && super.flota.urperatuGabekoKop(ontzi)>0) {
						 
						super.flota.egoeraAldatu(ontzi);
						super.flota.ezkutuKopuruaTxikitu();
					}
				}			
			}else{
				System.out.println("Ez duzu ezkutu gehiagorik");
			}
		}	
}
