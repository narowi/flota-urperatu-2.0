package sprint1;

public class Kasilla {
	private boolean begiratuta=false;
	private Ontzia ontzi=null;
	private boolean ura=true;
	private int x=0;
	private int y=0;
	
	public Kasilla(int px,int py){
		this.x=px;
		this.y=py;
	}
	
	public Ontzia getOntzia() {
		return this.ontzi;
	}

	public void ontziaJarri(Ontzia o) {
		this.ontzi=o;
	}

	public void kenduUra() {
		this.ura=false;
	}

	public char getZerNahiz() {// para que la interfaz mire que es
		if(ontzi!=null){
			return 'U';
		}
		else{
			return 'B';
		}
		
	}

}
