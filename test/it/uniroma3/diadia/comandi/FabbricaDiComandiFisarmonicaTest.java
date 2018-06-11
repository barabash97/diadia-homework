package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiRiflessiva fabbricaComandi;
	private ComandoVai comandoVaiSud;
	private ComandoPrendi comandoPrendiLampada;
	private ComandoPosa comandoPosaLampada;
	private ComandoGuarda comandoGuarda;
	private ComandoFine comandoFine;
	private ComandoAiuto comandoAiuto;
	private ComandoNonValido comandoNonValido;
	@Before
	public void setUp() throws Exception {
		this.fabbricaComandi = new FabbricaDiComandiRiflessiva();
		this.comandoVaiSud = new ComandoVai();
		this.comandoVaiSud.setParametro("sud");
		this.comandoPrendiLampada = new ComandoPrendi();
		this.comandoPrendiLampada.setParametro("lampada");
		this.comandoPosaLampada = new ComandoPosa();
		this.comandoPosaLampada.setParametro("lampada");
		this.comandoGuarda = new ComandoGuarda();
		this.comandoFine = new ComandoFine();
		this.comandoAiuto = new ComandoAiuto();
		this.comandoNonValido = new ComandoNonValido();
	}

	@Test
	public void testCostruisciComando_vai() {
		Comando c = this.fabbricaComandi.costruisciComando("vai sud");
		assertEquals(this.comandoVaiSud.getNome(), c.getNome());
		assertEquals(this.comandoVaiSud.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_nonValido() {
		Comando c = this.fabbricaComandi.costruisciComando("nulla");
		assertEquals(this.comandoNonValido.getNome(), c.getNome());
	}
	
	
	@Test
	public void testCostruisciComando_prendi() {
		Comando c = this.fabbricaComandi.costruisciComando("prendi lampada");
		assertEquals(this.comandoPrendiLampada.getNome(), c.getNome());
		assertEquals(this.comandoPrendiLampada.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_posa() {
		Comando c = this.fabbricaComandi.costruisciComando("posa lampada");
		assertEquals(this.comandoPosaLampada.getNome(), c.getNome());
		assertEquals(this.comandoPosaLampada.getParametro(), c.getParametro());
	}

	@Test
	public void testCostruisciComando_guarda() {
		Comando c = this.fabbricaComandi.costruisciComando("guarda");
		assertEquals(this.comandoGuarda.getNome(), c.getNome());
		assertEquals(this.comandoGuarda.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_fine() {
		Comando c = this.fabbricaComandi.costruisciComando("fine");
		assertEquals(this.comandoFine.getNome(), c.getNome());
		assertEquals(this.comandoFine.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_aiuto() {
		Comando c = this.fabbricaComandi.costruisciComando("aiuto");
		assertEquals(this.comandoAiuto.getNome(), c.getNome());
		assertEquals(this.comandoAiuto.getParametro(), c.getParametro());
	}

}
