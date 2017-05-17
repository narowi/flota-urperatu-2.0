package sprint1;

public class Bonba extends Arma {
	
	public Bonba(){
		super.biltegiZenbakia=0;
		super.prezioa=30;
		super.izena="Bonba";
	}
	

	
	public void tiroEgin(int x, int y,Tablero aurkariarenTableroa){
		boolean kasillaUrperatuta = aurkariarenTableroa.getKasillaUrperatuta(x,y);
		Ontzia o = aurkariarenTableroa.itsasontzirikDago(x,y);
		
		if(o!=null){
			o.jo(this,kasillaUrperatuta); // hemen pasatu beharko diot zein posiziotan egin den tiro	
		}
		aurkariarenTableroa.setBegiratuta(x, y, true);

	}
}