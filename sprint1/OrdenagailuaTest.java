package sprint1;

import static org.junit.Assert.*;

import org.junit.Test;

import sprint1.Armamentua;
import sprint1.Bonba;
import sprint1.Flota;
import sprint1.Fragata;
import sprint1.Itsaspeko;
import sprint1.MisilZuzendua;
import sprint1.Misila;
import sprint1.Ordenagailua;
import sprint1.Pertsona;
import sprint1.Tablero;


public class OrdenagailuaTest {
	
	private Ordenagailua o;
	private Pertsona p;
	private Flota flota; 
	private Flota nireFlota;
	private Itsaspeko o1;
	private Armamentua armak;
	private MisilZuzendua mz;
	private Misila m;
	private Bonba b;
	private Fragata o2;
	private Tablero etsaiarenTableroa;
	private Tablero nireTableroa;
	
	public void setUp() throws Exception{
		o=new Ordenagailua();
		p = new Pertsona();
		flota= new Flota();
		nireFlota= new Flota();
		o1=new Itsaspeko();
		o2=new Fragata();
		armak=new Armamentua();
		mz=new MisilZuzendua();
		m=new Misila();
		b=new Bonba();
		etsaiarenTableroa= new Tablero();
		nireTableroa= new Tablero();
		
		
		
	}
	

	public void tearDown() throws Exception {

		o=null;
		p=null;
		flota= null;
		nireFlota= null;
		o1=null;
		o2=null;
		armak=null;
		mz=null;
		m=null;
		b=null;
		p=null;
		etsaiarenTableroa=null;
		nireTableroa=null;

	}

	@Test
	public void tiroEgin() {
		etsaiarenTableroa=new Tablero();
		nireTableroa=new Tablero();
		o1= new Itsaspeko();
		o2 = new Fragata();
		o= new Ordenagailua();
		armak=new Armamentua();
		mz=new MisilZuzendua();
		m=new Misila();
		b=new Bonba();
		flota= new Flota();
		p= new Pertsona();
		flota.gehituOntzi(o1);
		flota.gehituOntzi(o2);
		System.out.println("test:" + flota.zenbatOntzi());
		p.setFlota(flota);
		//System.out.println("pertsona"+ p.flota.zenbatOntzi());
	
		o.setEtsaiarenTablero(etsaiarenTableroa);
		o.setNireTablero(nireTableroa);
		p.setEtsaiarenTablero(nireTableroa);
		p.setNireTablero(etsaiarenTableroa);
		assertSame(armak.zenbatArma(),0);
		armak.armaGehitu2(b);
		armak.armaGehitu2(m);
		armak.armaGehitu2(mz);
		assertSame(armak.zenbatArma(),3);
		o.setArmamentua(armak);
		
		o.tiroEgin();
		
		
		Jokalaria jok= Jokoa.getNireJokoa().aurkariaLortu();
		Tablero aurkariarenTableroa=jok.lortuNireTableroa();
		int lehen= 0;
		int gero= 0;
		for(int x=0; x < etsaiarenTableroa.getTamaina(); x++){
			for(int y=0; y < etsaiarenTableroa.getTamaina(); y++){
				if(aurkariarenTableroa.getIkutua(x, y)){
					lehen++;
				}
			}
		}
		o.tiroEgin();
		for(int x=0; x < etsaiarenTableroa.getTamaina(); x++){
			for(int y=0; y < etsaiarenTableroa.getTamaina(); y++){
				if(aurkariarenTableroa.getIkutua(x, y)){
					gero++;
				}
			}
		}
		assertTrue(gero>=lehen);
		
	}

}
