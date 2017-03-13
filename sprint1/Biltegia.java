package sprint1;


public class Biltegia {
	private Armamentua armamentua;
	private static Biltegia nireBiltegia;
	private Integer[] armaKopurua;
	private EgoeraBiltegia e;

	private Biltegia(){
		this.armaKopurua= new Integer[armamentua.armaMotaKopuru()-1];
	}

	public static Biltegia getNireBiltegia(){
		if(Biltegia.nireBiltegia==null){
			Biltegia.nireBiltegia=new Biltegia();
		}
		return Biltegia.nireBiltegia;
	}

	public void armasaldu(int mota){
		this.nireBiltegia.armamentua.armaKenduKop(mota);  
	}

	public void hasieratu() {
		this.armamentua.hasieratu(20, 2, 4, 6, 2);
		this.armaKopurua[0]=20;
		this.armaKopurua[1]=2;
		this.armaKopurua[2]=4;
		this.armaKopurua[3]=6;
		this.armaKopurua[4]=2;
		
	}

	//arma saldu

	//arma erosi

}
