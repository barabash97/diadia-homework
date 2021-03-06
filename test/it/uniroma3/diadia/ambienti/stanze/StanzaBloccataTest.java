package it.uniroma3.diadia.ambienti.stanze;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.stanze.Stanza;
import it.uniroma3.diadia.ambienti.stanze.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.enums.Direzioni;

public class StanzaBloccataTest {

	private StanzaBloccata stanzaBloccata;
	private Attrezzo attrezzoParticolare;
	private Attrezzo attrezzoNonParticolare;
	private String direzioneBloccata;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		this.attrezzoParticolare = new Attrezzo("particolare", 1);
		this.attrezzoNonParticolare = new Attrezzo("nonParticolare", 1);
		this.direzioneBloccata = Direzioni.SUD.toString().toLowerCase();
		this.stanzaBloccata = new StanzaBloccata("bloccata", this.attrezzoParticolare.getNome(), this.direzioneBloccata);
		this.stanza = new Stanza("stanza");
		this.stanzaBloccata.impostaStanzaAdiacente(Direzioni.NORD.toString().toLowerCase(), this.stanza);
	}

	@Test
	public void testGetDirezioni_nessunNomeParticolare() {
		assertFalse(this.stanzaBloccata.hasAttrezzo(this.attrezzoParticolare.getNome()));
		assertTrue(this.stanzaBloccata.addAttrezzo(this.attrezzoNonParticolare));
		assertTrue(this.stanzaBloccata.hasAttrezzo(this.attrezzoNonParticolare.getNome()));
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(Direzioni.NORD.toString().toLowerCase()));
	}
	
	@Test
	public void testGetDirezioni_presenteNomeParticolare() {
		assertFalse(this.stanzaBloccata.hasAttrezzo(this.attrezzoParticolare.getNome()));
		assertTrue(this.stanzaBloccata.addAttrezzo(this.attrezzoParticolare));
		assertTrue(this.stanzaBloccata.hasAttrezzo(this.attrezzoParticolare.getNome()));
		assertNotEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(Direzioni.NORD.toString().toLowerCase()));
	}
	
	@Test
	public void testGetDescrizione_attrezzoNonParticolare() {
		assertTrue(this.stanzaBloccata.addAttrezzo(this.attrezzoNonParticolare));
		assertEquals(StanzaBloccata.SLOGAN, this.stanzaBloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizione_attrezzoParticolare() {
		assertTrue(this.stanzaBloccata.addAttrezzo(this.attrezzoParticolare));
		assertNotEquals(StanzaBloccata.SLOGAN, this.stanzaBloccata.getDescrizione());
	}

}
