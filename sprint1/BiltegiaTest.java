package sprint1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BiltegiaTest {
	private Armamentua a;
	private Biltegia b;
	private Arma ar;
	@Before
	public void setUp() throws Exception {
		a = new Armamentua();
		b = Biltegia.getNireBiltegia();
		ar = new Arma();
		
	}

	@After
	public void tearDown() throws Exception {
		a=null;
		b=null;
		ar=null;
	}

	@Test
	public void testGetNireBiltegia() {
		assertNotNull(b);
		assertNotNull(a);
		assertNotNull(ar);
		
	}

	@Test
	public void testArmasaldu() {
		
	}

//	@Test
//	public void testHasieratu() {
//		
//	}

}
