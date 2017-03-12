package sprint1;

public class Ontzia {

	protected int luzera;

	protected String mota;//falta en las clase de los barcos

	protected int urperatuGabekoZatiKop;

	protected int konponketaPrezioa;//falta en las clases de los barcos
	
	protected Egoera egoera;//falta en las clase de los barcos


	public Ontzia(){
		this.konponketaPrezioa=50; // zati bakoitza
	}

	

	public int getHondoratuGabekoZatiKop() {
		return urperatuGabekoZatiKop;
	}




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


	public void egoeraAldatu(Egoera pEgoera) {
		egoera=pEgoera;
		
	}

	public Egoera getEgoera() {
		// TODO Auto-generated method stub
		return this.egoera;
	}
	

}
