package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Biltegia;
import sprint1.Ondo;
import sprint1.StockGabe;

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
		//assertTrue(b.armakDaude());
		//System.out.println(b.luzera());
		//b.armasaldu(0);
		b.hasieratu();
		assertEquals(b.luzera(), 7);
		assertTrue(b.armakDaude());
		
		//b.armasaldu(0);
		assertTrue(b.motaHorretakoArmarik(0));
		assertTrue(b.getEgoera() instanceof Ondo);
		b.armasaldu(0);
		b.armasaldu(1);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		b.armasaldu(0);
		assertTrue(b.motaHorretakoArmarik(1));
		b.armasaldu(1);
		b.armasaldu(1);
		b.armasaldu(1);
		b.armasaldu(1);
		b.armasaldu(1);
		//mota honetako alerik ez
		b.armasaldu(1);
		assertTrue(b.motaHorretakoArmarik(2));
		b.armasaldu(2);
		b.armasaldu(2);
		b.armasaldu(2);
		b.armasaldu(2);
		b.armasaldu(2);
		b.armasaldu(2);
		//mota honetako alerik ez
		b.armasaldu(2);
		b.armasaldu(2);
		assertTrue(b.motaHorretakoArmarik(3));
		b.armasaldu(3);
		b.armasaldu(3);
		b.armasaldu(3);
		b.armasaldu(3);
		//mota honetako alerik ez
		b.armasaldu(3);
		assertTrue(b.motaHorretakoArmarik(4));
		b.armasaldu(4);
		b.armasaldu(4);
		b.armasaldu(4);
		b.armasaldu(4);
		//biltegia hutsik dago ya
		b.armasaldu(4);
		//assertTrue(b.getEgoera() instanceof StockGabe);
		b.armasaldu(4);
		
		b.armasaldu(5);
		b.armasaldu(5);
		b.armasaldu(5);
		b.armasaldu(5);
		
		b.armasaldu(6);
		b.armasaldu(6);
		b.armasaldu(6);
		b.armasaldu(6);
		assertTrue(b.getEgoera() instanceof StockGabe);
	}

}
