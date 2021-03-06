package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Armamentua;
import sprint1.Jokoa;
import sprint1.Ordenagailua;
import sprint1.Pertsona;
import sprint1.Tablero;

public class PertsonaTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Jokoa j= Jokoa.getNireJokoa();
		
		Ordenagailua o= new Ordenagailua();
		Pertsona p= new Pertsona();
		Tablero ot= o.getTablero();
		Tablero pt= p.getTablero();
		p.setEtsaiarenTablero(ot);
		o.setEtsaiarenTablero(pt);
		
//		Tablero ot= new Tablero();
//		Tablero pt= new Tablero();
//		o.setNireTablero(ot);
//		System.out.println("ord tableroa" + o.getTablero());
//		p.setNireTablero(pt);
//		System.out.println("per tableroa" + p.getTablero());
//		Armamentua a= new Armamentua();
//		a.hasieratu();
//		System.out.println("armamentu " + a.armaMotaKopuru());
//		p.setArmamentua(a);
//		System.out.println("per amamentu "+ p.armamentuarenLuzera());
		//o.ontziakKokatu();
		//falta da tiro egiterakoan ontzi baten gainean konprobatzea
		
		p.tiroEgin("Bonba", 0, 0);
		int lehen= 0;
		int gero= 0;
		for(int x=0; x < pt.getTamaina(); x++){
			
			for(int y=0; y < pt.getTamaina(); y++){
				
				if(ot.getIkutua(x, y)){
					System.out.println("hemen sartu da");
					lehen++;
				}
			}
		}
		p.tiroEgin("Bonba", 1, 1);
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					System.out.println("hemen sartu da");
					gero++;
				}
			}
		}
		System.out.println("B lehen balio: " + lehen + "gero balio: " + gero);
		assertTrue(gero>=lehen);
		
		
		
		p.tiroEgin("Misila", 9, 9);
		
		lehen= 0;
		gero= 0;
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					lehen++;
				}
			}
		}
		p.tiroEgin("Misila", 9, 9);
		
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					gero++;
				}
			}
		}
		System.out.println("M lehen balio: " + lehen + "gero balio: " + gero);
		assertTrue(gero>=lehen);

		
		p.tiroEgin("misil zuzendua bertikal", 7, 8);
		
		lehen= 0;
		gero= 0;
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					lehen++;
				}
			}
		}
		//p.tiroEgin("misil zuzendua bertikal", 1, 1);
		
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					gero++;
				}
			}
		}
		System.out.println("MB lehen balio: " + lehen + "gero balio: " + gero);
		assertTrue(gero>=lehen);

		
		//hemetik aurrera ez du armarik
		p.tiroEgin("misil zuzendua horizontal", 6, 7);
		
		lehen= 0;
		gero= 0;
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					lehen++;
				}
			}
		}
	//	p.tiroEgin("misil zuzendua horizontal", 1, 1);
		
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					gero++;
				}
			}
		}
		System.out.println("MH lehen balio: " + lehen + "gero balio: " + gero);
		assertTrue(gero>=lehen);
		
		
		p.tiroEgin("misil zuzendua boom", 4, 3);
		
		lehen= 0;
		gero= 0;
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					lehen++;
				}
			}
		}
	//	p.tiroEgin("misil zuzendua", 1, 1);
		
		for(int x=0; x < pt.getTamaina(); x++){
			for(int y=0; y < pt.getTamaina(); y++){
				if(ot.getIkutua(x, y)){
					gero++;
				}
			}
		}
		System.out.println("MZ lehen balio: " + lehen + "gero balio: " + gero);
		assertTrue(gero>=lehen);
	}

}
