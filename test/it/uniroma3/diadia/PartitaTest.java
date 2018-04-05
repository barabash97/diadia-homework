package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class PartitaTest {
	
	private Partita partita;
	private Attrezzo chiave;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.chiave = new Attrezzo("chiave", 1);
	}
	
	@Test
	public void testVinta_nonVinta() {
		assertFalse(this.partita.vinta());
	}
	
	@Test 
	
	public void testVinta_finitiCfu() {
		assertFalse(oggettoPartitaGiocatoreZeroCfu().vinta());
	}
	
	@Test
	public void testVinta_stanzeUguali() {
		assertTrue(oggettoPartitaStanzeUguali().vinta());
	}

	@Test
	public void testIsFinita_nonFinita() {
		assertFalse(this.partita.isFinita());
	}

	@Test
	public void testPrendiAttrezzo() {
		Attrezzo a = new Attrezzo("attrezzo", 1);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.partita.prendiAttrezzo(a.getNome());
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
	}

	@Test
	public void testPosaAttrezzo() {
		Attrezzo a = new Attrezzo("attrezzo", 1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.posaAttrezzo(a.getNome());
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
	}
	
	public Partita oggettoPartitaStanzeUguali() {
		Partita p = new Partita();
		
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaFinale());
		
		return p;
	}
	
	public Partita oggettoPartitaGiocatoreZeroCfu() {
		Partita p = new Partita();
		
		p.getGiocatore().setCfu(0);
		
		return p;
	}

	
}
