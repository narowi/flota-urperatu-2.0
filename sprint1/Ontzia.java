package sprint1;

public class Ontzia {

	protected int luzera;

	protected String mota;

	protected int urperatuGabekoZatiKop;

	protected int konponketaPrezioa;
	//protected boolean ezkutuaDauka=false;
	protected Egoera egoera;


	

	public Ontzia (int pLuz, String pMot, int pUrGa, int pPrez, boolean ezkut){

		this.luzera=pLuz;

		this.mota=pMot;

		this.urperatuGabekoZatiKop=pUrGa;

		this.konponketaPrezioa=pPrez;

		//this.ezkutuan=ezkut;

	}

	

	public int getHondoratuGabekoZatiKop() {

		return urperatuGabekoZatiKop;

	}

	

//	public boolean getEzkutua(){

//		return this.ezkutuan;

//	}



	public boolean urperatutaDago(){

		boolean emaitza=false;

		if (this.urperatuGabekoZatiKop==0){

			emaitza=true;

		}

		return emaitza;

	}

		

	

	public void kenduZatia(){

		this.urperatuGabekoZatiKop--;

	}

	

	public void konponduOntzia(){

		this.urperatuGabekoZatiKop= this.urperatuGabekoZatiKop+1;

	}
	
	public boolean ezkutuaDu(){ 
		if(this.egoera instanceof EzkutuOsoa || this.egoera instanceof EzkutuBakarra ){
			return true;
		}else{
			return false;
		}
	}



//	public void jarriEzkutua() {
//		this.ezkutuaDauka=true;
//		
//	}



	public void egoeraAldatu(Egoera pEgoera) {
		egoera=pEgoera;
		
	}



	public Egoera getEgoera() {
		// TODO Auto-generated method stub
		return this.egoera;
	}
	

}
