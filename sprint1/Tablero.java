package sprint1;

public class Tablero {
	private Kasilla[][] tablero;
	private static int tamaina;
	
	public Tablero(){
		this.tablero = new Kasilla[tamaina][tamaina];
		for(int i=0;i<tamaina;i++){
			for(int j=0;j<tamaina;j++){
				this.tablero[i][j]= new Kasilla();
			}
		}
	}
	
	public static void setTamaina(){
		tamaina=10;
	}
	 public int getTamaina(){
		 return tamaina;
	 }

	
//	private boolean ontzirikInguruan(int x, int y) {//y que no hya ya un ezkutu, el ezku se pone encima del barco
//		if(tablero[x+1][y].getOntzia()!=null){
//			return true;
//		}else if(tablero[x][y+1].getOntzia()!=null){
//			return true;
//		}else if(tablero[x][y-1].getOntzia()!=null){
//			return true;
//		}else if(tablero[x-1][y].getOntzia()!=null){
//			return true;
//		}else if(tablero[x-1][y-1].getOntzia()!=null){
//			return true;
//		}else if(tablero[x-1][y+1].getOntzia()!=null){
//			return true;
//		}else if(tablero[x+1][y-1].getOntzia()!=null){
//			return true;
//		}else if(tablero[x+1][y+1].getOntzia()!=null){
//			return true;
//		}else{
//			return false;
//		}
//	}

	public void ontziaKokatu(int x, int y, String horBert, Ontzia ontzia){
		//to do
	}

	public boolean koordenatuEgokiak(int x, int y) {
		if(x<0 || x>= tamaina || y<0 || y>= tamaina || this.tablero[x][y].getUra()==true){
			return false;
		}else{
			return true;
		}
	}

	public Ontzia itsasontzirikDago(int x, int y) {
		return this.tablero[x][y].getOntzia();
	}

		
}
