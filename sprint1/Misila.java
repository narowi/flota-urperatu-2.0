package sprint1;

public class Misila extends Arma {
	
	public Misila(){
		super.biltegiZenbakia=2;
		super.prezioa=80;
		super.izena="Misila";
	}
	

	
	public void tiroEgin(int x, int y, Tablero aurkariarenTableroa){
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
		Ontzia o = aurkariarenTableroa.itsasontzirikDago(x,y);
		
		if(o!=null){ // kasu honetan ontzia osorik deuseztatuko da.
			o.jo(this,kasillaUrperatuta);
		}
		aurkariarenTableroa.setBegiratuta(x, y, true);

	}
}
