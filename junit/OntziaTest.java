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
	public void test() {
		o.egoeraAldatu(new Ikututa());
		Arma a= new Misila();
		o.jo(a, false);
		//Egoera e=new Urperatuta();
		//System.out.println(o.getEgoera());
		//System.out.println(o.getEgoera().toString());
		//System.out.println(e);
		//System.out.println(e.toString());
		//assertTrue(o.getEgoera().toString().equals(e.toString()));
		assertTrue(o.getHondoratuGabekoZatiKop()==0);
		o.egoeraAldatu(new Osorik());
		assertTrue(o.getHondoratuGabekoZatiKop()==o.getHondoratuGabekoZatiKop());
		
		o.egoeraAldatu(new Urperatuta());
		assertTrue(o.urperatutaDago());
		assertFalse(o.zatirikBizirik());
		
		o.egoeraAldatu(new Osorik());
		Arma b = new Bonba();
		o.jo(b, false); 
		System.out.println("Egoera Osorik, bonba jo ondoren" + o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		System.out.println("Egoera Ikututa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuOsoa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuBAkarra, bonba jo ondoren"+o.getEgoera());
		//-----------------------------------
		o.jo(a, false); 
		System.out.println(o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		System.out.println("Egoera Ikututa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuOsoa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuBakarra, misila jo ondoren"+o.getEgoera());
		
		o = new HegazkinOntzi();
		System.out.println("HegazkinOntzi"+o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		System.out.println("Egoera Ikututa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuOsoa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuBakarra, bonba jo ondoren"+o.getEgoera());
		
		o.jo(a, false); 
		System.out.println("Arma misila"+o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		System.out.println("Egoera Ikututa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		System.out.println("Egoera EZkutuOsoa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuBakarra, misila jo ondoren"+o.getEgoera());
		
		o = new Itsaspeko();
		System.out.println("Itsaspeko"+o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		System.out.println("Egoera Ikututa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuOsoa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuBakarra, bonba jo ondoren"+o.getEgoera());
		
		o.jo(a, false); 
		System.out.println(o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		System.out.println("Egoera Ikututa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuOsoa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuBakarra, misila jo ondoren"+o.getEgoera());
		
		o = new Suntsitzaile();
		
		System.out.println(o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(b, false); 
		System.out.println("Egoera Ikututa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuOsoa, bonba jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(b, false); 
		System.out.println("Egoera EzkutuBakarra, bonba jo ondoren"+o.getEgoera());
		
		o.jo(a, false); 
		System.out.println(o.getEgoera());
		
		o.egoeraAldatu(new Ikututa());
		o.jo(a, false); 
		System.out.println("Egoera Ikututa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuOsoa());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuOsoa, misila jo ondoren"+o.getEgoera());
		
		o.egoeraAldatu(new EzkutuBakarra());
		o.jo(a, false); 
		System.out.println("Egoera EzkutuBakarra, misila jo ondoren"+o.getEgoera());
	}

}
