package sprint1;

import java.util.ArrayList;

import java.util.ArrayList;



public class Biltegia {

	private Armamentua armamentua;

	private static Biltegia nireBiltegia;

	private ArrayList<Integer> armaKopurua;

	

	private Biltegia(){}



	public static Biltegia getNireBiltegia(){

		if(Biltegia.nireBiltegia==null){

			Biltegia.nireBiltegia=new Biltegia();

		}

		return Biltegia.nireBiltegia;

	}

	

	

	public void armasaldu(){

		//jakin beharko da zein dan saltzen den arma

		this.nireBiltegia.armamentua.armaKendu(mota);  //arma motaren kop == 0 danean

		//saldutako armaren kop-- egin

	}

	//arma saldu

	//arma erosi

	







}
