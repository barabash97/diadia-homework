package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendiTest {

	private Attrezzo attrezzo;
	private Partita partita;
	private ComandoPrendi comando;
	private Attrezzo attrezzoPesoMassimo;
	private Attrezzo attrezzoNullo;
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.attrezzo = new Attrezzo("attrezzos", 1);
		this.attrezzoPesoMassimo = new Attrezzo("attrezzoMassimo", this.partita.getGiocatore().getBorsa().getPesoMax()+1);
		this.attrezzoNullo = null;
		this.comando = new ComandoPrendi();
	}

	@Test
	public void testEsegui_aggiungiAttrezzoNellaBorsa() {
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
		this.comando.setParametro(this.attrezzo.getNome());
		this.comando.esegui(this.partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo.getNome()));
	}
	
	@Test
	public void testEsegui_aggiungiAttrezzoPesoSuperioreAllaCapacita() {
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzoPesoMassimo);
		this.comando.setParametro(this.attrezzoPesoMassimo.getNome());
		this.comando.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzoPesoMassimo.getNome()));
	}
	
	@Test
	public void testEsegui_aggiungiAttrezzoNullo() {
		assertFalse(this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzoNullo));
	}

}
