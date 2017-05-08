package sprint1;

public class Misila extends Arma {
	
	public Misila(){
		super.biltegiZenbakia=2;
		super.prezioa=80;
		super.izena="Misila";
	}
	
	public  boolean posizioHorretakoArmaDa(int pos){
		if(pos==this.biltegiZenbakia){
			return true;
		}else{
			return false;
		}
	}
	
	public void tiroEgin(int x, int y, Jokalaria pAurkari){
		Tablero aurkariarenTableroa = pAurkari.getTablero();
		aurkariarenTableroa.setBegiratuta(x, y, true);
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
		Ontzia o = aurkariarenTableroa.itsasontzirikDago(x,y);
		
		if(o!=null){ // kasu honetan ontzia osorik deuseztatuko da.
			o.jo(this,kasillaUrperatuta);
		}	
	}
}
