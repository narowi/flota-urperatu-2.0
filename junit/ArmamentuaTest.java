package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import sprint1.Arma;
import sprint1.Armamentua;
import sprint1.Bonba;
import sprint1.Misila;

public class ArmamentuaTest {
Armamentua listaArmak;
Arma a1,a2;

	@Before
	public void setUp() throws Exception {
		listaArmak = new Armamentua();
		a1= new Bonba();
		a2= new Misila();
	}

	@After
	public void tearDown() throws Exception {
		listaArmak=null;
		a1=null;
		a2=null;
	}

	@Test
	public void armaSortuTest() {
		assertNotNull(a1);
		assertNotNull(a2);
	}
	
	@Test
	public void armaKenduTest() {
		//listaArmak.hasieratu(1, 1, 1, 1, 1);
		listaArmak.armaGehitu2(a1);
		listaArmak.armaGehitu2(a2);
		listaArmak.armaKendu(a1);
		assertFalse(listaArmak.armarikDago(a1.getBiltegiZenbakia()));
		assertTrue(listaArmak.armarikDago(a2.getBiltegiZenbakia()));
		
		listaArmak.armaKendu(a2);
		assertFalse(listaArmak.armarikDago(a2.getBiltegiZenbakia()));
		
	
		
	}
	
	@Test
	public void armaGehituTest() {
		listaArmak.hasieratuTesta(1, 1, 1, 1, 1);
		listaArmak.armaGehituZerrendan(2);
		assertEquals(listaArmak.misilKop(), 2);
		
		//arma gehitu zerrendaren berdina egiten deu
	}
	
	@Test
	public void badagoEzkuturikTest() {
		listaArmak.hasieratu(1, 1, 1, 1, 1);
		assertTrue(listaArmak.badagoEzkuturik());
	}
	
	@Test
	public void armaKenduKopTest() {
		listaArmak.hasieratu(1, 1, 1, 1, 1);
		listaArmak.armaKendu(a2);
		assertFalse(listaArmak.armarikDago(a2.getBiltegiZenbakia()));
		
	}
	
//	@Test
//	public void armaMotaKopuruaTest() {
//		listaArmak.hasieratu(1, 1, 1, 1, 1);
//		
//	}
	
	@Test
	public void armaGehituZerrendanTest() {
		listaArmak.garbitu();
		//listaArmak.hasieratu(0, 0, 0, 0, 0);
		listaArmak.hasieratuTesta(1, 1, 1, 1, 1);
		assertTrue(listaArmak.armaMotaKopuru()==5);
		listaArmak.armaGehituZerrendan(2);
		assertEquals(listaArmak.misilKop(), 2);
		listaArmak.armaGehituZerrendan(1);
		assertEquals(listaArmak.ezkutuKop(), 2);
		listaArmak.armaGehituZerrendan(0);
		assertEquals(listaArmak.bonbaKop(), 2);
		
		listaArmak.armaGehituZerrendan(3);
		assertEquals(listaArmak.misilZ(), 2);
		
		listaArmak.armaGehituZerrendan(4);
		assertEquals(listaArmak.radarKop(), 2);
		
		
	}
	
//	@Test
//	public void lortuArmaTest() {
//		listaArmak.hasieratu(1, 0, 1, 1, 0);
//	}
//	
	@Test
	public void armarikDagoTest() {
		listaArmak.hasieratu(1, 1, 1, 1, 1);
		assertTrue(listaArmak.armarikDago(0));
		assertTrue(listaArmak.armarikDago(2));
		assertTrue(listaArmak.armarikDago(3));
		
	}

}
