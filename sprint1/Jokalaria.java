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
	
	public abstract boolean ontziaKonponduNahi(Ontzia o);
	public abstract void ontziaKonpondu(String o);
	
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
		
		public abstract void armaAukeratuErosteko(String arma);
	
}
		
