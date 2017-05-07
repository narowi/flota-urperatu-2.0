
package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import sprint1.*;


import sprint1.Armamentua;
import sprint1.Bonba;
import sprint1.Flota;
import sprint1.Fragata;
import sprint1.Itsaspeko;
import sprint1.Jokoa;
import sprint1.MisilZuzendua;
import sprint1.Misila;
import sprint1.Ordenagailua;
import sprint1.Pertsona;
import sprint1.Tablero;


public class OrdenagailuaTest {
	
		
	public void setUp() throws Exception{
		Jokoa j= Jokoa.getNireJokoa();
		
		
		
	}
	

	public void tearDown() throws Exception {

	

	}
	

		

	@Test
	public void tiroEgin() {
		Jokoa j= Jokoa.getNireJokoa();
	
		Ordenagailua o= j.ordLortu();
		Pertsona p= j.perLortu();
		Tablero ot= new Tablero();
		Tablero pt= new Tablero();
		o.setNireTablero(ot);
		System.out.println("ord tableroa" + o.getTablero());
		p.setNireTablero(pt);
		System.out.println("per tableroa" + p.getTablero());
		Armamentua a= j.ordArmamentuaLortu();
		a.hasieratu(1,1,1,1,1);
		System.out.println("armamentu" + a.armaMotaKopuru());
		o.setArmamentua(a);
		System.out.println("ord amamentu junit"+ o.armamentuarenLuzeera());
		
		o.tiroEgin();
//		Ordenagailua ord= Jokoa.getNireJokoa().ordLortu();
//		Pertsona p=Jokoa.getNireJokoa().perLortu();
//		Armamentua a= Jokoa.getNireJokoa().ordArmamentuaLortu();
//
//		Tablero nireTablero= ord.lortuNireTableroa();
//		Tablero etsaiarenTableroa= p.lortuNireTableroa();
		int lehen= 0;
		int gero= 0;
		for(int x=0; x < ot.getTamaina(); x++){
			for(int y=0; y < ot.getTamaina(); y++){
				if(pt.getIkutua(x, y)){
					lehen++;
				}
			}
		}
		o.tiroEgin();
		for(int x=0; x < ot.getTamaina(); x++){
			for(int y=0; y < ot.getTamaina(); y++){
				if(pt.getIkutua(x, y)){
					gero++;
				}
			}
		}
		assertTrue(gero>lehen);
		
	}
	
	
	@Test
	public void ontziakKokatuTest(){
		Jokoa j= Jokoa.getNireJokoa();
//		Flota ordf=new Flota();
//		Flota pf= new Flota();
		Ordenagailua o= j.ordLortu();
		Pertsona p= j.perLortu();
		Tablero ot= new Tablero();
		Tablero pt= new Tablero();
		int x = -1;
		int y = -1;
		o.setNireTablero(ot);
		System.out.println("ord tableroa" + o.getTablero());
		p.setNireTablero(pt);
		System.out.println("per tableroa" + p.getTablero());
		Armamentua a= j.ordArmamentuaLortu();
		a.hasieratu(1,1,1,1,1);
		System.out.println("armamentu" + a.armaMotaKopuru());
		o.setArmamentua(a);
		System.out.println("ord amamentu junit"+ o.armamentuarenLuzeera());
		
		System.out.println(o.getListaOntziak().size());
		System.out.println(ot.getTamaina()+ " tableroaren tamaina");
//		p.setFlota(pf);
//		o.setFlota(ordf);
		o.ontziakKokatu();
		
		
		
		
//		Ordenagailua ord= Jokoa.getNireJokoa().ordLortu();
//	
	}

}