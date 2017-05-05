package sprint1;

public class Ondo implements EgoeraBiltegia{
	public Ondo(){}
	public void armaSaldu(int mota){
		Biltegia.getNireBiltegia().armasaldu(mota);
		
		if (!Biltegia.getNireBiltegia().armakDaude()){
			Biltegia.getNireBiltegia().egoeraAldatu(new StockGabe());
		}
	}

	

}
