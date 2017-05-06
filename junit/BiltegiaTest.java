package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Biltegia;

public class BiltegiaTest {
Biltegia b;
	@Before
	public void setUp() throws Exception {
		b= Biltegia.getNireBiltegia();
	}

	@After
	public void tearDown() throws Exception {
		b=null;
	}

	@Test
	public void test() {
		assertTrue(b.armakDaude());
		System.out.println(b.luzera());
		//b.armasaldu(0);
	}

}
