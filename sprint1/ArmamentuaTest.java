package sprint1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArmamentuaTest {
private ArrayList<Arma>li;
private Arma a;
	@Before
	public void setUp() throws Exception {
		li= new ArrayList<Arma>();
		a = new Arma();
	}

	@After
	public void tearDown() throws Exception {
		li=null;
		a=null;
	}

	@Test
	public void testArmamentua() {
		assertNotNull(li);
	}

//	@Test
//	public void testArmaSortu() {
//		
//	}

	@Test
	public void testArmaKendu() {
		li.add(a);
		assertTrue(li.size()==1);
		li.remove(a);
		assertTrue(li.size()==0);
	}

	@Test
	public void testArmaGehitu() {
		fail("Not yet implemented");
	}

//	@Test
//	public void testGetEzkutuKop() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testEzkutuKoptxikitu() {
		fail("Not yet implemented");
	}

	@Test
	public void testArmaKenduKop() {
		Biltegia.getNireBiltegia().armasaldu(1);
		
	}

	@Test
	public void testArmaGehituZerrendan() {
		a=new Bonba();
		li.add(a);
		assertTrue(li.size()==1);
	}

	@Test
	public void testHasieratu() {
		fail("Not yet implemented");
	}

}
