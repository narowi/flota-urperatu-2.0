package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Arma;
import sprint1.Bonba;
//import sprint1.Egoera;
import sprint1.EzkutuBakarra;
import sprint1.EzkutuOsoa;
import sprint1.Fragata;
import sprint1.HegazkinOntzi;
import sprint1.Ikututa;
import sprint1.Itsaspeko;
import sprint1.Misila;
import sprint1.Ontzia;
import sprint1.Osorik;
import sprint1.Suntsitzaile;
import sprint1.Urperatuta;

public class OntziaTest {
private Ontzia o;
	
	@Before
	public void setUp() throws Exception {
		o=new Fragata();
	}

	@After
	public void tearDown() throws Exception {
		o=null;
	}

	@Test
	public void jo() {
		//egoeren funtzionanamendua jo metodoarenak
		o.egoeraAldatu(new Ikututa());
		Arma a= new Misila();
		o.jo(a, false);
		assertTrue(o.getHondoratuGabekoZatiKop()==0);
		o.egoeraAldatu(new Osorik());
		assertTrue(o.getHondoratuGabekoZatiKop()==o.getHondoratuGabekoZatiKop());
		
		o.egoeraAldatu(new Urperatuta());
		assertTrue(o.urperatutaDago());
		assertFalse(o.zatirikBizirik());
		
		o.egoeraAldatu(new Osorik());
		Arma b = new Bonba();
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  EzkutuBakarra);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o = new HegazkinOntzi();
		assertTrue(o.getEgoera() instanceof  Osorik);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  EzkutuBakarra);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o = new Itsaspeko();
		assertTrue(o.getEgoera() instanceof  Osorik);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  EzkutuBakarra);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o = new Suntsitzaile();
		assertTrue(o.getEgoera() instanceof  Osorik);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  EzkutuBakarra);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		assertTrue(o.getEgoera() instanceof  Ikututa);
		
		
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		assertTrue(o.getEgoera() instanceof  Urperatuta);
		
	}

}
