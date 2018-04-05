package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa borsa;
	Attrezzo osso;
	Attrezzo chiave;
	Attrezzo attrezzoNonPresente;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.osso = new Attrezzo("osso",5);
		this.chiave = new Attrezzo("chiave", 5);
		this.attrezzoNonPresente = new Attrezzo("nonPresente", 5);
		this.borsa.addAttrezzo(osso);
		this.borsa.addAttrezzo(chiave);
	}
	/**
	 * Generare borsa piena di attrezzi
	 * @return
	 */
	public Borsa generareBorsaPiena() {
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
	public void testHasAttrezzo_presente() {
		assertTrue(this.borsa.hasAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void testHasAttrezzo_nonPresente() {
		assertFalse(this.borsa.hasAttrezzo(this.attrezzoNonPresente.getNome()));
	}
	
	@Test
	public void testIsPieno_pieno() {
		assertTrue(this.generareBorsaPiena().isPieno());
	}
	
	@Test
	public void testIsPieno_nonPieno() {
		assertFalse(this.generareBorsaVuota().isPieno());
	}
	
	@Test
	public void testIsVuoto_vuoto() {
		assertTrue(this.generareBorsaVuota().isEmpty());
	}
	
	@Test
	public void testIsVuoto_nonVuoto() {
		assertFalse(this.generareBorsaPiena().isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo_presente() {
		this.borsa.removeAttrezzo(this.osso.getNome());
		assertFalse(this.borsa.hasAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		this.borsa.removeAttrezzo(this.attrezzoNonPresente.getNome());
		assertFalse(this.borsa.hasAttrezzo(this.attrezzoNonPresente.getNome()));
	}
	
	@Test 
	public void testPesoSufficientePerAggiungereAttrezzo_borsaVuota() {
		assertTrue(this.generareBorsaVuota().addAttrezzo(new Attrezzo("attrezzo", 3)));
	}
	
	@Test 
	public void testPesoSufficientePerAggiungereAttrezzo_borsaPiena() {
		assertFalse(this.generareBorsaPiena().addAttrezzo(new Attrezzo("attrezzo", 3)));
	}
}
