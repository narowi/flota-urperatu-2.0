package sprint1;

import ui.WarningKudeatzailea;

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
	
	public abstract void ontziakKokatu(); 
	//public abstract void tiroEgin(Kasilla k, String armaNorabide);
	public abstract void ezkutuaJarri();
	
	public abstract void armaHautatu();
	
//	public void lortuEtsaiarenTableroa(Tablero pTablero){
//		etsaiarenTableroa=pTablero;
//	}
	public Tablero lortuNireTableroa(){
		return nireTablero;
	}
	public Tablero lortuEtsaiarenTableroa(){
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
	public abstract int ontziaKonpondu(int x, int y);
	
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
				else if(!ontziaOsorik && !ontziaUrperatua && !ezkutuaDu && !ezkutuBakarraDu && tiroEginda){
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
		
		public abstract int armaAukeratuErosteko(String arma);
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
		public int[] radarraKontsultatu() {
			int[] i= new int[3];
			if(this.radarKontsultaKop>0){
				System.out.println("radarra x honetan: "+radarX);
				System.out.println("radarra y honetan: "+radarY);
				int[] k=etsaiarenTableroa.radarraKontsultatu(radarX, radarY);
				if(k[0]==0){
					System.out.println("PIIIIPO");
					System.out.println("x=" + k[1] + " y=" + k[2]);
				}
				this.radarKontsultaKop--;
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

//		public void armaKopTxikitu(int biltegiZenbakikoArma) {
//			this.flota.kenduArmaKopBat(biltegiZenbakikoArma);
//		}
}
		
