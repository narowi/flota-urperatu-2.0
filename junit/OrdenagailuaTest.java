package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sprint1.Armamentua;
import sprint1.Bonba;
import sprint1.Flota;
import sprint1.Itsaspeko;
import sprint1.MisilZuzendua;
import sprint1.Misila;
import sprint1.Ordenagailua;
import sprint1.Pertsona;
import sprint1.Tablero;

public class OrdenagailuaTest {
	private Ordenagailua o;
	private Pertsona p;
	private Flota f; 
	private Flota nireFlota;
	private Itsaspeko o1;
	private Armamentua armak;
	private MisilZuzendua mz;
	private Misila m;
	private Bonba b;

	@Before
	public void setUp() throws Exception {
		o=new Ordenagailua();
		p = new Pertsona();
		f= new Flota();
		nireFlota= new Flota();
		o1=new Itsaspeko();
		armak=new Armamentua();
		mz=new MisilZuzendua();
		m=new Misila();
		b=new Bonba();
	}

	@After
	public void tearDown() throws Exception {
		o=null;
		p=null;
		f= null;
		nireFlota= null;
		o1=null;
		armak=null;
		mz=null;
		m=null;
		b=null;
		p=null;
	}

	@Test
	public void tiroEgin() {
		Ordenagailua o= new Ordenagailua();
		armak=new Armamentua();
		mz=new MisilZuzendua();
		m=new Misila();
		b=new Bonba();
		f= new Flota();
		o1= new Itsaspeko();
		p= new Pertsona();
		//Tablero tablero=p.lortuNireTableroa();
		//assertSame(f.zenbatOntzi(), 0);
		
		p.getListaOntziak().gehituOntzia(o1.getMota()); // PROBLEMA AQUI NO SUMA EL BARCO!!!!!	
		//o.ontziaKokatu(o1);
	
		assertSame(armak.zenbatArma(),0);
		armak.armaGehitu2(b);
		armak.armaGehitu2(m);
		armak.armaGehitu2(mz);
		assertSame(armak.zenbatArma(),3);
		
		o.tiroEgin();
		int lehen= 0;
		int gero= 0;
		Tablero tablero= o.lortuEtsaiarenTableroa2();
		for(int x=0; x < tablero.getTamaina(); x++){
			for(int y=0; y < tablero.getTamaina(); y++){
				lehen= lehen+ tablero.kasillaIkutuGabe(x,y);
				//lehen =zenbatu zenbat parte ikutu gabe ==osoa
			}
		}
		o.tiroEgin();
		for(int x=0; x < tablero.getTamaina(); x++){
			for(int y=0; y < tablero.getTamaina(); y++){
				gero = gero + tablero.kasillaIkutuGabe(x,y);//zenbatu zenbat parte ikutu gabe
			}
		}
		assertTrue(gero<lehen);
		
	}

}
