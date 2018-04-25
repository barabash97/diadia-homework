package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanzaBuia;
	private Attrezzo attrezzoParticolare;
	private Attrezzo attrezzoNonParticolare;

	@Before
	public void setUp() throws Exception {
		this.attrezzoParticolare = new Attrezzo("particolare", 1);
		this.attrezzoNonParticolare = new Attrezzo("nonParticolare", 1);
		this.stanzaBuia = new StanzaBuia("buia", this.attrezzoParticolare.getNome());
	}

	@Test
	public void testGetDescrizione_attrezzoNonParticolare() {
		assertTrue(this.stanzaBuia.addAttrezzo(this.attrezzoNonParticolare));
		assertEquals(StanzaBuia.SLOGAN, this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_attrezzoParticolare() {
		assertTrue(this.stanzaBuia.addAttrezzo(this.attrezzoParticolare));
		assertNotEquals(StanzaBuia.SLOGAN, this.stanzaBuia.getDescrizione());
	}

}
