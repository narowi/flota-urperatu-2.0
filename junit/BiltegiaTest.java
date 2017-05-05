package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Armamentua;
import sprint1.Biltegia;

public class BiltegiaTest {
Biltegia a ;
Armamentua ar;
	@Before
	public void setUp() throws Exception {
		a= Biltegia.getNireBiltegia();
		ar= new Armamentua();
	}

	@After
	public void tearDown() throws Exception {
		a=null;
		ar=null;
	}

	@Test
	public void test() {
		a.hasieratu();
		assertTrue(a.luzera()==30);
		
		a.armasaldu(1);
		System.out.println(a.luzera());
		
	}

}
