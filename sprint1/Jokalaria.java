package sprint1;


public abstract class Jokalaria {

	protected Tablero nireTablero;
	protected Tablero etsaiarenTableroa;
	protected Flota flota;
	protected int radarKontsultaKop;
	protected int radarX;
	protected int radarY;
	
	public Jokalaria(){
		nireTablero=new Tablero();
		flota=new Flota();
		radarKontsultaKop=2;
		radarX=(int)(Math.random()*(nireTablero.getTamaina()));
		radarY=(int)(Math.random()*(nireTablero.getTamaina()));
	}
	
	protected abstract void ontziakKokatu(); 
	
	public Tablero lortuNireTableroa(){
		return nireTablero;
	}
	public Tablero lortuEtsaiarenTableroa(){
		return this.etsaiarenTableroa;
	}


	
	public Arma lortuArma(int biltegiZenbakikoArma) {
		return this.flota.lortuArma(biltegiZenbakikoArma);
	}
	
	public boolean armarikDago(int biltegiZenbakikoArma){
		return this.flota.armarikDago(biltegiZenbakikoArma);
	}
	
	protected abstract int ontziaKonpondu(int x, int y);
	
	public boolean diruNahikoa(Ontzia o) {
		return this.flota.diruNahikoa(o);
	}
	
	public void diruaKendu(Ontzia o) {
		this.flota.diruaKendu(o);
		
	}
	
	public int luzera() {
		return this.flota.size();
	}
	
	
	public String zerDaKasillaHau(int x,int y){
		String da="";
		Ontzia o= nireTablero.itsasontzirikDago(x, y);
		boolean tiroEginda = nireTablero.begiratutaDago(x, y);
		if(o==null){
			if(!tiroEginda){
				da="Ura";
			}
			else if(tiroEginda){
				da="UrIkutua";
			}
		}
		else{
			boolean ezkutuaDu= o.ezkutuOsoaDu();
			boolean ezkutuBakarraDu= o.ezkutuBakarraDu();
			boolean ontziaOsorik=o.dagoOsorik();
			boolean ontziaUrperatua=o.urperatutaDago();
			if(ontziaOsorik && !ezkutuaDu && !ezkutuBakarraDu){
				da="Osorik";
			}
			else if(!ontziaOsorik && !ontziaUrperatua && !ezkutuaDu && !ezkutuBakarraDu ){
				da="OIkutua";
			}
			else if(ontziaUrperatua){
				da="OUrperatua";
			}
			else if(ezkutuaDu){
				da="EzkutuOsoa";
			}
			else if(ezkutuBakarraDu){
				da="EzkutuBakarra";
			}
		}
		return da;
	}
	
	protected abstract int armaAukeratuErosteko(String arma);
	
	public Ontzia lortuOntzia(int x, int y) {
		return this.nireTablero.lortuOntziaKasillatik(x,y);
	}
	
	public Tablero getTablero(){
		return this.nireTablero;
	}
	
	
	
	public int[] radarraKontsultatu() {
		int[] i= new int[3];
		if(flota.armamentuaLortu().armarikDago(4)){
			System.out.println("radarra x honetan: "+radarX);
			System.out.println("radarra y honetan: "+radarY);
			int[] k=etsaiarenTableroa.radarraKontsultatu(radarX, radarY);
			if(k[0]==0){
				System.out.println("PIIIIPO");
				System.out.println("x=" + k[1] + " y=" + k[2]);
			}
			flota.armamentuaLortu().armaKenduKop(4);
			radarX=(int)(Math.random()*(nireTablero.getTamaina()));
			radarY=(int)(Math.random()*(nireTablero.getTamaina()));
			i=k;
		}
		else{
			i[0]=1;
			//new WarningKudeatzailea("Ez zaizu kontsultarik geratzen,beste radar bat erosi");
		}
		return i;
	}
	
	public boolean itsasontziBizirik(){
		return flota.itsasontziBizirik();
	}
	
	
	//junit
		public Flota getListaOntziak() {
			return this.flota;
		}
		public void setFlota(Flota pFlota){
			this.flota=pFlota;
		}
		public void setArmamentua(Armamentua a){
			this.flota.setArmamentua(a);
		}
		public void setEtsaiarenTablero(Tablero t){
			this.etsaiarenTableroa=t;
		}
		public void setNireTablero(Tablero t){
			this.nireTablero=t;
		}
//		public void markatuIkututa(int x, int y) {
//			this.nireTablero.markatuIkututa(x,y);
//			
//		}

//		public Ontzia bilatuOntzia(int o) {
//			return this.flota.bilatuOntzia(o);
//		}
//		public void createTablero(){
//			nireTablero=this.nireTablero.sortuTableroa();
//		}
		public void etsaiariNireTableroaEsleitu(){
			this.etsaiarenTableroa=this.nireTablero;
		}
//		public void flotaSortu(){
//			this.flota.flotaSortu();
//		}
		public Armamentua armamentuaItzuli() {
			return this.flota.armamentuaLortu();
		}

}
		
