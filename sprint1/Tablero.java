package sprint1;

public class Tablero {
	private Kasilla[][] tablero;
	private static int tamaina;
	
	public Tablero(){
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


	public void ontziaKokatu(){
		Ontzia o=ontzia;
		int x=x;
		int y=y;
		char[] norabidePosible=this.norabideaAukeratu(x, y, o);
		char norabidea=' ';
		this.kokatu(x, y, o, norabidea);
	}

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
		if(ezkerreraAhal(x,y,o.luzera)){
			ahalDu[1]='z';
		}
		if(goraAhal(x,y,o.luzera)){
			ahalDu[2]='g';
		}
		if(beheraAhal(x,y,o.luzera)){
			ahalDu[3]='b';
		}
		
		return ahalDu;
	}

	private boolean beheraAhal(int x, int y, int luzera) {
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
		return ahalDu;
	}

	private boolean goraAhal(int x, int y, int luzera) {
		boolean ahalDu=true;
		int xOrain=x-1;
		if(y-(luzera-1)>=0){
			while(xOrain<=x+1 && ahalDu){
				int yOrain=y+1;
				while(yOrain<=y-luzera && ahalDu){
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
		return ahalDu;
	}

	private boolean ezkerreraAhal(int x, int y, int luzera) {
		boolean ahalDu=true;
		int yOrain=y-1;
		if(x-(luzera-1)>=0){
			while(yOrain<=y+1 && ahalDu){
				int xOrain=x+1;
				while(xOrain<=x-luzera && ahalDu){
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
		return ahalDu;
	}

	private boolean eskumaraAhal(int x, int y, int luzera) {
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
	public void kokatu(int x,int y,Ontzia o,char norabidea){
		int i;
		if(norabidea=='s'){
			for(i=x;i<x+o.luzera;i++){
				tablero[i][y].ontziaJarri(o);
				tablero[i][y].kenduUra();
			}	
		}
		if(norabidea=='z'){
			for(i=x;i<x-o.luzera;i--){
				tablero[i][y].ontziaJarri(o);
				tablero[i][y].kenduUra();
			}
		}
		if(norabidea=='g'){
			for(i=y;i<y-o.luzera;i--){
				tablero[x][i].ontziaJarri(o);
				tablero[x][i].kenduUra();
			}
		}
		if(norabidea=='b'){
			for(i=y;i<y+o.luzera;i++){
				tablero[x][i].ontziaJarri(o);
				tablero[x][i].kenduUra();
			}
		}
	}

		
}
