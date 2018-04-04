package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {
	
	private Giocatore giocatore;
	
	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore("Vladimir");
	}

	@Test
	public void testGiocatore() {
		fail("Not yet implemented");
	}

	@Test
	public void testDecrementaCfu() {
		//assertNotEquals(this.giocatore.getCfu(), this.giocatore.);
	}

	@Test
	public void testPrendereAttrezzo() {
		fail("Not yet implemented");
	}

}
