package it.uniroma3.diadia.ambienti.stanze;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.stanze.StanzaMagica;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaTest {

	private StanzaMagica stanzaMagica;
	private Attrezzo attrezzo;
	private String nomeInvertito;

	@Before
	public void setUp() throws Exception {
		this.stanzaMagica = new StanzaMagica("magic");
		this.attrezzo = new Attrezzo("chiave", 1);
		StringBuilder str = new StringBuilder(this.attrezzo.getNome());
		this.nomeInvertito = str.reverse().toString();
	}

	@Test
	public void testAddAttrezzo_attrezzoModificato() {
		this.stanzaMagica.setSogliaMagica(0);
		assertFalse(this.stanzaMagica.hasAttrezzo(this.nomeInvertito));
		assertTrue(this.stanzaMagica.addAttrezzo(attrezzo));
		assertTrue(this.stanzaMagica.hasAttrezzo(this.nomeInvertito));
	}
	
	@Test
	public void testAddAttrezzo_attrezzoNonModificato() {
		assertFalse(this.stanzaMagica.hasAttrezzo(this.attrezzo.getNome()));
		assertTrue(this.stanzaMagica.addAttrezzo(attrezzo));
		assertFalse(this.stanzaMagica.hasAttrezzo(this.nomeInvertito));
		assertTrue(this.stanzaMagica.hasAttrezzo(this.attrezzo.getNome()));
	}

}
