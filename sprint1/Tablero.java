package sprint1;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import ui.WarningKudeatzailea;

public class Tablero extends Observable{
	private Kasilla[][] tablero;
	private static int tamaina;
	
	public Tablero(){
		setTamaina();
		this.tablero = new Kasilla[tamaina][tamaina];
		for(int i=0;i<tamaina;i++){
			for(int j=0;j<tamaina;j++){
				this.tablero[i][j]= new Kasilla(i,j);
			}
		}
	}
	
	public static void setTamaina(){
		tamaina=10;
	}
	 public int getTamaina(){
		 return tamaina;
	 }


////	public void ontziaKokatu(Ontzia o,int x,int y){
//		//miradolo bien por que en fin, mas chapuza que otra cosa.
//		
//		//ONTZIA ESKURATU
//		Ontzia o=null;
//		String aux = OntziMotak.ontziaItzuli();
//		System.out.println(aux);
//		o = OntziFactory.getOntziFactory().createOntzia(aux);
//		
//		
//		//KOORDENATUAK LORTU (aqui es donde la matan)
//		Integer[] aux2 = new Integer[2];
//		aux2 = Proba.koordenatuakItzuli();
//		int x=aux2[0];
//		int y=aux2[1];
//		char[] norabidePosible=this.norabideaAukeratu(x, y, o);
//		//aqui llamo a la interfaz otra vez.
//		char norabidea=KokapenAukerak.kokapena(norabidePosible);
//		this.kokatu(x, y, o, norabidea);
//	}

	
	public Kasilla[][] getNireTableroa(){
		return this.tablero;
	}
	public char getZerNahiz(int x,int y){
		return tablero[x][y].getZerNahiz();
	}

	public Ontzia itsasontzirikDago(int x, int y) {
		return this.tablero[x][y].getOntzia();
	}
	public char[] norabideaAukeratu(int x, int y,Ontzia o){
		char[] ahalDu = new char[4];
		if(eskumaraAhal(x,y,o.luzera)){
			ahalDu[0]='s';
		}
		else{
			ahalDu[0]=' ';
		}
		if(ezkerreraAhal(x,y,o.luzera)){
			ahalDu[1]='z';
		}
		else{
			ahalDu[1]=' ';
		}
		if(goraAhal(x,y,o.luzera)){
			ahalDu[2]='g';
		}
		else{
			ahalDu[2]=' ';
		}
		if(beheraAhal(x,y,o.luzera)){
			ahalDu[3]='b';
		}
		else{
			ahalDu[3]=' ';
		}
		
		return ahalDu;
	}

	  private boolean eskumaraAhal(int x, int y, int luzera) {
	        boolean ahalDu=true;
	        int xOrain=x-1;
	        if(y+(luzera-1)<=9){
	            while(xOrain<=x+1 && ahalDu){
	                int yOrain=y-1;
	                while(yOrain<=y+luzera && ahalDu){
	                    if(xOrain<=9 && yOrain<=9 && xOrain>=0 && yOrain>=0){
	                        if(tablero[xOrain][yOrain].getOntzia()!=null){
	                            ahalDu=false;
	                        }
	                    }
	                        yOrain++;
	                }
	                xOrain++;
	            }
	        }
	        else{
	            ahalDu=false;
	        }
	        return ahalDu;
	    }
	 
	    private boolean ezkerreraAhal(int x, int y, int luzera) {
	        boolean ahalDu=true;
	        int xOrain=x-1;
	        if(y-(luzera-1)>=0){
	            while(xOrain<=x+1 && ahalDu){
	                int yOrain=y+1;
	                while(yOrain>=y-luzera && ahalDu){
	                    if(xOrain<=9 && yOrain<=9 && xOrain>=0 && yOrain>=0){
	                        if(tablero[xOrain][yOrain].getOntzia()!=null){
	                            ahalDu=false;
	                        }
	                    }
	                        yOrain--;
	                }
	                xOrain++;
	            }
	        }
	        else{
	            ahalDu=false;
	        }
	        return ahalDu;
	    }
	 
	    private boolean goraAhal(int x, int y, int luzera) {
	        boolean ahalDu=true;
	        int yOrain=y-1;
	        if(x-(luzera-1)>=0){
	            while(yOrain<=y+1 && ahalDu){
	                int xOrain=x+1;
	                while(xOrain>=x-luzera && ahalDu){
	                    if(xOrain<=9 && yOrain<=9 && xOrain>=0 && yOrain>=0){
	                        if(tablero[xOrain][yOrain].getOntzia()!=null){
	                            ahalDu=false;
	                        }
	                    }
	                        xOrain--;
	                }
	                yOrain++;
	            }
	            
	        }
	        else{
	            ahalDu=false;
	        }
	        return ahalDu;
	    }
	 
	    private boolean beheraAhal(int x, int y, int luzera) {
	        boolean ahalDu=true;
	        int yOrain=y-1;
	        if(x+(luzera-1)<=9){
	            while(yOrain<=y+1 && ahalDu){
	                int xOrain=x-1;
	                while(xOrain<=x+luzera && ahalDu){
	                    if(xOrain<=9 && yOrain<=9 && xOrain>=0 && yOrain>=0){
	                        if(tablero[xOrain][yOrain].getOntzia()!=null){
	                            ahalDu=false;
	                        }
	                    }
	                        xOrain++;
	                }
	                yOrain++;
	            }
	        }
	        else{
	            ahalDu=false;
	        }
	        return ahalDu;
	    }	
	    
	    
	    public int kokatu(int x,int y,Ontzia o,char norabidea){
			int i;
			int z=-1;
			if(norabidea=='b' && beheraAhal(x, y, o.getHondoratuGabekoZatiKop())){
				for(i=x;i<x+o.luzera;i++){
					tablero[i][y].ontziaJarri(o);
					tablero[i][y].kenduUra();
					o.kokatuNaiz();
				}	
				z=0;
			}
			else if(norabidea=='g' && goraAhal(x, y, o.getHondoratuGabekoZatiKop())){
				for(i=x;i>x-o.luzera;i--){
					tablero[i][y].ontziaJarri(o);
					tablero[i][y].kenduUra();
					o.kokatuNaiz();
				}
				z=0;
			}
			else if(norabidea=='z' && ezkerreraAhal(x, y, o.getHondoratuGabekoZatiKop())){
				for(i=y;i>y-o.luzera;i--){
					tablero[x][i].ontziaJarri(o);
					tablero[x][i].kenduUra();
					o.kokatuNaiz();
				}
				z=0;
			}
			else if(norabidea=='s' && eskumaraAhal(x, y, o.getHondoratuGabekoZatiKop())){
				for(i=y;i<y+o.luzera;i++){
					tablero[x][i].ontziaJarri(o);
					tablero[x][i].kenduUra();
					o.kokatuNaiz();
				}
				z=0;
			}
			else{
				z=1;
					//new WarningKudeatzailea("ezin da gelaxka horretan kokatu");
			}
			return z;
			
	}
		public void setBegiratuta(int x, int y, boolean b) {
			this.tablero[x][y].setBegiratuta(b);
			
		}
		public boolean begiratutaDago(int pX, int pY) {

			return this.tablero[pX][pY].getBegiratuta();

		}

		

		public boolean koordenatuEgokiak(int pX, int pY) {

			if(pX < 0 || pX >= tamaina || pY < 0 || pY >= tamaina ) {

				return false;

			}

			else {

				return true;

			}
		}
//junit
//		public int kasillaIkutuGabe(int x, int y) {
//			return this.tablero[x][y].ikutuGabe();
//		}
//
//		public void aldatuKasillaUkituta(int x, int y) {
//			this.tablero[x][y].setIkutuGabe(false);
//		}

		public void aldatuKasillaUrperatuta(int x, int y) {
			this.tablero[x][y].setUrperatuta(true);
			
		}

		public boolean getKasillaUrperatuta(int x, int y) {
			return tablero[x][y].getUrperatuta();
		}

		public boolean getIkutua(int x, int y) {
			return tablero[x][y].getIkututa();
		}
		public void markatuIkututa(int x, int y) {
			this.tablero[x][y].markatuIkututa(true);			
		}
		public Tablero sortuTableroa() {
			return new Tablero();
			
		}

		public Ontzia lortuOntziaKasillatik(int x, int y) {
			return tablero[x][y].getOntzia();
		}

		public int[] radarraKontsultatu(int x, int y) {
			int o[]= new int[3];
			ArrayList<Kasilla> k= new ArrayList<Kasilla>();
			//boolean begiratuta=false;
			//while(!begiratuta){
				for(int j=x-1;j<x+1;j++){
					for(int l=y-1;l<y+1;l++){
						if(j<=9 && j>=0 && l<=9 && l>=0){
							if(tablero[j][l].getOntzia()!=null){
								k.add(tablero[j][l]);
							}
						}
					}
				}
//				if(this.tablero[x][y].getOntzia()!=null){
//					k.add(tablero[x][y]);
//				}
//				if(this.tablero[x+1][y].getOntzia()!=null){
//					k.add(tablero[x+1][y]);
//				}
//				if(this.tablero[x-1][y].getOntzia()!=null){
//					k.add(tablero[x-1][y]);
//				}
//				if(this.tablero[x][y-1].getOntzia()!=null){
//					k.add(tablero[x][y-1]);
//				}
//				if(this.tablero[x][y+1].getOntzia()!=null){
//					k.add(tablero[x][y+1]);
//				}
				//begiratuta=true;
			//}
			if(k.isEmpty()){
				//new WarningKudeatzailea("Radarraren eremuan ez dago ontzirik.");
				o[0]=2;
			}
			else{
				int i=((int)(Math.random()*(k.size())));
				//new WarningKudeatzailea(k.get(i).getX()+".errenkadan eta "+k.get(i).getY()+".zutabean ontzi bat dago.");
				o[0]=0;
				o[1]=k.get(i).getX();
				o[2]=k.get(i).getY();
			}
			return o;
		}

		
}
