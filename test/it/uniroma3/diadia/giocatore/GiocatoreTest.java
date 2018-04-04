package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class GiocatoreTest {
	
	private Giocatore giocatore;
	private Attrezzo osso;
	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore("Vladimir");
		this.osso = new Attrezzo("osso", 3);
	}

	@Test
	public void testGiocatoreIstanziato() {
		assertTrue(this.giocatore != null);
	}

	@Test
	public void testDecrementaCfu() {
		int cfuPrima = this.giocatore.getCfu();
		this.giocatore.decrementaCfu();
		assertNotEquals(cfuPrima, this.giocatore.getCfu());
	}

	@Test
	public void testPrendereAttrezzo() {
		assertTrue(this.giocatore.getBorsa().addAttrezzo(this.osso));
	}
	
}
