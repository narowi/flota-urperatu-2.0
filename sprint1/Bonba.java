package sprint1;

public class Bonba extends Arma {
	
	public Bonba(){
		super.biltegiZenbakia=0;
		super.prezioa=30;
	}
	
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
	
	public void tiroEgin(int x, int y,int aukera){
		Jokalaria pAurkari= Jokoa.getNireJokoa().aurkariaLortu();
		Tablero aurkariarenTableroa =pAurkari.lortuEtsaiarenTableroa2();
		aurkariarenTableroa.setBegiratuta(x, y, true);
		
		Ontzia o = aurkariarenTableroa.itsasontzirikDago(x,y);
		
		if(o!=null){
			o.jo(this); // hemen pasatu beharko diot zein posiziotan egin den tiro
			//posizio horretan bakarrik izango du eragina
		}
	}
}
