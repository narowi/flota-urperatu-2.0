package sprint1;

public class Kasilla {
	private boolean begiratuta=false;
	//private boolean ezkutua=false;
	private Ontzia ontzi;
	private boolean ura=true;
	private int x=0;
	private int y=0;
	
	//public void setEzkutua(boolean pEzkutua){
		//ezkutua=pEzkutua;
	//}

	public Ontzia getOntzia() {
		return this.ontzi;
	}

	public boolean getUra() {
		return this.ura; // si ura esta a true es que al lado hay un ontzi
	}
	
	public void setUra(){
		this.ura=false;
	}

}
