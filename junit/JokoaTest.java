package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Armamentua;
import sprint1.Biltegia;
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

public class JokoaTest {
	
	Jokoa gureJokoa = Jokoa.getNireJokoa();
	
	

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void probaEginJokoaHasieratu() {
		Flota ordF= new Flota();
		ordF.armakEsleitu();
		assertTrue(ordF.size()==10);
		assertTrue(ordF.armamentuarenLuzera()==14);
		Ordenagailua o= new Ordenagailua();
		o.setFlota(ordF);	
		Biltegia b= Biltegia.getNireBiltegia();
		b.hasieratu();
		assertTrue(b.luzera()==18);
			
	}

		
}


