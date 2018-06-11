package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.stanze.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.enums.Direzioni;

public class ComandoVaiTest {
	
	private ComandoVai comando;
	private Partita partita;
	private Stanza stanzaSenzaDirezioni;
	private Stanza stanza;

	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoVai();
		this.stanzaSenzaDirezioni = new Stanza("stanzaSenzaDirezioni");
		this.stanza = new Stanza("stanza");
	}
	
	@Test
	public void testEsegui_direzioneInesistente() {
		this.partita.getLabirinto().setStanzaCorrente(this.stanzaSenzaDirezioni);
		this.comando.setParametro(Direzioni.NORD.toString().toLowerCase());
		this.comando.esegui(partita);
		assertEquals(this.partita.getLabirinto().getStanzaCorrente(), this.stanzaSenzaDirezioni);
	}
	
	@Test
	public void testEsegui_direzioneNulla() {
		this.partita.getLabirinto().setStanzaCorrente(this.stanza);
		this.comando.setParametro(null);
		this.comando.esegui(this.partita);
		assertEquals(this.stanza, this.partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testEsegui() {
		Stanza stanzaCorrente = this.partita.getLabirinto().getStanzaCorrente();
		this.comando.setParametro(Direzioni.SUD.toString().toLowerCase());
		this.comando.esegui(this.partita);
		assertNotEquals(stanzaCorrente, this.partita.getLabirinto().getStanzaCorrente());
	}
	
}
