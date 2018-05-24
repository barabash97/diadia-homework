package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class PartitaTest {
	
	private Partita partita;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzo", 1);
	}
	
	@Test
	public void testVinta_nonVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test 
	
	public void testVinta_finitiCfu() {
		this.partita.getGiocatore().setCfu(0);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVinta_stanzeUguali() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaFinale());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testIsFinita_nonFinita() {
		assertFalse(this.partita.isFinita());
	}
	
	@Test
	public void testControlloPresenzaAttrezzoInUnaDelleDueStanze() {
		String nomeAttrezzo = attrezzo.getNome();
		assertTrue(this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo));
		assertFalse(this.partita.controlloPresenzaAttrezzoInUnaDelleDueStanze(nomeAttrezzo));
		this.partita.posaAttrezzo(nomeAttrezzo);
		assertTrue(this.partita.controlloPresenzaAttrezzoInUnaDelleDueStanze(nomeAttrezzo));
		this.partita.prendiAttrezzo(nomeAttrezzo);
		assertFalse(this.partita.controlloPresenzaAttrezzoInUnaDelleDueStanze(nomeAttrezzo));

		
	}

	
}
