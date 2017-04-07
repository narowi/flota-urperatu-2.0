package sprint1;

public class Kasilla {
	private boolean begiratuta=false;
	//private boolean ezkutua=false;
	private Ontzia ontzi;
	private boolean ura=true;
	private int x=0;
	private int y=0;
	//junit
		private boolean ikutuGabe=true;
	
	//public void setEzkutua(boolean pEzkutua){
		//ezkutua=pEzkutua;
	//}
	public Kasilla(int i, int j){
		x = i;
		y = j;
	}

	public Ontzia getOntzia() {
		return this.ontzi;
	}

	public boolean getUra() {
		return this.ura; // si ura esta a true es que al lado hay un ontzi
	}
	
	public void setUra(){
		this.ura=false;
	}

	public void ontziaJarri(Ontzia o) {
		this.ontzi=o;
	}

	public void kenduUra() {
		this.ura=false;
	}

	public char getZerNahiz() {
		if(ontzi!=null){
			return 'U';
		}
		else{
			return 'B';
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public void setBegiratuta(boolean b) {
		begiratuta=b;
		
	}

	public boolean getBegiratuta() {
		return begiratuta;
	}

	//junit
	public int ikutuGabe() {
		if(this.ikutuGabe){
			return 1;
		}else{
			return 0;
		}
		
	}

	public void setIkutuGabe(boolean b) {
		this.ikutuGabe=b;
		
	}

}
