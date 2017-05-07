package sprint1;


public abstract class Jokalaria {

	protected Tablero nireTablero;
	protected Tablero etsaiarenTableroa;
	protected Flota flota;
	protected int radarKontsultaKop;
	
	public Jokalaria(){
		nireTablero=new Tablero();
		flota=new Flota();
		radarKontsultaKop=2;
	}
	
	public abstract void ontziakKokatu(); 
	//public abstract void tiroEgin(Kasilla k, String armaNorabide);
	public abstract void ezkutuaJarri();
	
	public abstract void armaHautatu();
	
	public void lortuEtsaiarenTableroa(Tablero pTablero){
		etsaiarenTableroa=pTablero;
	}
	public Tablero lortuNireTableroa(){
		return nireTablero;
	}
	public Tablero lortuEtsaiarenTableroa2(){
		return this.etsaiarenTableroa;
	}

	public Flota getListaOntziak() {
		return this.flota;
		
	}
	
	public int zenbatOntzi(){
		return this.flota.zenbatOntzi();
	}

	public Arma lortuArma(int biltegiZenbakikoArma) {
		return this.flota.lortuArma(biltegiZenbakikoArma);
	}
	
	public boolean armarikDago(int biltegiZenbakikoArma){
		return this.flota.armarikDago(biltegiZenbakikoArma);
	}
	
	//public abstract boolean ontziaKonpontzekoDirua(Ontzia o);
	public abstract void ontziaKonpondu(int x, int y);
	
	//junit
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
		public void markatuIkututa(int x, int y) {
			this.nireTablero.markatuIkututa(x,y);
			
		}

		public boolean diruNahikoa(Ontzia o) {
			return this.flota.diruNahikoa(o);
		}

		public void diruaKendu(Ontzia o) {
			this.flota.diruaKendu(o);
			
		}

		public void gehituOntzia(Ontzia o) {
			this.flota.gehituOntzi(o);
			
		}

		public int luzera() {
			return this.flota.size();
		}

		public Ontzia bilatuOntzia(int o) {
			return this.flota.bilatuOntzia(o);
		}
		public String zerDaKasillaHau(int x,int y){
			String Da=" ";
			Ontzia o=nireTablero.itsasontzirikDago(x, y);
			int ukituGabe=nireTablero.kasillaIkutuGabe(x, y);//mirar que hace
			System.out.println(ukituGabe+" ukitua nago");
			boolean urperatua=nireTablero.getKasillaUrperatuta(x, y);
			System.out.println(urperatua+" urperatua nago");
			if(o!=null && ukituGabe>0 && !urperatua && !o.ezkutuOsoaDu() &&  !o.ezkutuBakarraDu()){
				Da="ontzia";
				System.out.println(Da+" da");
			}
			else if(o!=null && o.ezkutuOsoaDu()){
				Da="ezkutuOsoa";
			}
			else if(urperatua){
				Da="hondoratua";
			}else if( o.ezkutuBakarraDu()){
				Da="ezkutuBakarra";
			}
			return Da;
		}
		
		public abstract void armaAukeratuErosteko(String arma);
		public void createTablero(){
			nireTablero=this.nireTablero.sortuTableroa();
		}
		
		public void etsaiariNireTableroaEsleitu(){
			this.etsaiarenTableroa=this.nireTablero;
		}
		
		public void flotaSortu(){
			this.flota.flotaSortu();
		}
		public Armamentua armamentuaItzuli() {
			return this.flota.armamentuaLortu();
		}
		public Tablero getTablero(){
			return this.nireTablero;
		}

		public Ontzia lortuOntzia(int x, int y) {
			return this.nireTablero.lortuOntziaKasillatik(x,y);
		}
}
		
