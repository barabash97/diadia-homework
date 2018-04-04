package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa;
	Attrezzo osso;
	Attrezzo chiave;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso",5);
		this.chiave = new Attrezzo("chiave", 5);
		this.borsa.addAttrezzo(osso);
		this.borsa.addAttrezzo(chiave);
	}
	/**
	 * Generare borsa piena di attrezzi
	 * @return
	 */
	public Borsa generareBorsaNonPiena() {
		Borsa b = new Borsa();
		Attrezzo a = new Attrezzo("pieno", b.getPesoMax());
		b.addAttrezzo(a);
		return b;
	}
	
	/**
	 * Generare borsa senza attrezzi
	 * @return
	 */
	public Borsa generareBorsaVuota() {
		return new Borsa();
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue(this.borsa.hasAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void testIsPieno() {
		assertTrue(this.generareBorsaNonPiena().isPieno());
	}
	
	@Test
	public void testIsVuoto() {
		assertTrue(this.generareBorsaVuota().isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo() {
		this.borsa.removeAttrezzo(this.osso.getNome());
		assertFalse(this.borsa.hasAttrezzo(this.osso.getNome()));
	}

}
