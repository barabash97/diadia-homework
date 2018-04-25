package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private ComandoPosa comando;
	private Attrezzo attrezzo;
	private Partita partita;
	private Attrezzo attrezzoNonInBorsa;

	@Before
	public void setUp() throws Exception {
		this.comando = new ComandoPosa();
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzo", 1);
		this.attrezzoNonInBorsa = new Attrezzo("assente", 1);
		this.partita.getGiocatore().getBorsa().addAttrezzo(this.attrezzo);
	}

	@Test 
	public void testEsegui_posaAttrezzoNonPresenteNellaBorsa() {
		this.comando.setParametro(this.attrezzoNonInBorsa.getNome());
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzoNonInBorsa.getNome()));
	}
	
	@Test
	public void testEsegui_posaAttrezzo() {
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
		this.comando.setParametro(this.attrezzo.getNome());
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
	}

}
