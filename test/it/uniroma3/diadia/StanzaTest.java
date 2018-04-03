package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza aulaN11;
	private Stanza aulaVuota;
	private Attrezzo osso;
	private Attrezzo chiave;
	private Attrezzo bicchiere;

	@Before
	public void setUp() throws Exception {
		this.aulaN11 = new Stanza("N11");
		this.aulaVuota = new Stanza("vuota");
		this.osso = new Attrezzo("osso", 3);
		this.chiave = new Attrezzo("chiave", 5);
		this.bicchiere = new Attrezzo("bicchiere", 10);
		this.aulaN11.addAttrezzo(this.chiave);
		this.aulaN11.addAttrezzo(this.osso);
	}

	@Test
	public void testHasAttrezzo_assente() {
		assertFalse(this.aulaVuota.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzo_presente() {
		assertTrue(this.aulaN11.hasAttrezzo("osso"));
	}
	
	@Test
	public void testHasAttrezzo_nonPresente() {
		assertFalse(this.aulaN11.hasAttrezzo("penna"));
	}
	
	@Test
	public void testGetAttrezzo_presente() {
		assertEquals(this.osso, this.aulaN11.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzo_nonPresente() {
		assertNotEquals(new Attrezzo("oggettoVuoto", 10), this.aulaN11.getAttrezzo("osso"));
	}
	
	
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		//TODO
	}
	
	@Test
	public void testRemoveAttrezzo_presente() {
		assertTrue(this.aulaN11.removeAttrezzo(this.osso));
	}
	
}
