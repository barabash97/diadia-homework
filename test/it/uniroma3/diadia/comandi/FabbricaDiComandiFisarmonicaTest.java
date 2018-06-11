package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.enums.Comandi;
import it.uniroma3.diadia.enums.Direzioni;

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
		this.comandoVaiSud.setParametro(Direzioni.SUD.toString().toLowerCase());
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
		String nomeComando = Comandi.VAI.toString().toLowerCase() + " " + Direzioni.SUD.toString().toLowerCase();
		Comando c = this.fabbricaComandi.costruisciComando(nomeComando);
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
		Comando c = this.fabbricaComandi.costruisciComando(Comandi.PRENDI.toString().toLowerCase() + " lampada");
		assertEquals(this.comandoPrendiLampada.getNome(), c.getNome());
		assertEquals(this.comandoPrendiLampada.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_posa() {
		Comando c = this.fabbricaComandi.costruisciComando(Comandi.POSA.toString().toLowerCase() + " lampada");
		assertEquals(this.comandoPosaLampada.getNome(), c.getNome());
		assertEquals(this.comandoPosaLampada.getParametro(), c.getParametro());
	}

	@Test
	public void testCostruisciComando_guarda() {
		Comando c = this.fabbricaComandi.costruisciComando(Comandi.GUARDA.toString().toLowerCase());
		assertEquals(this.comandoGuarda.getNome(), c.getNome());
		assertEquals(this.comandoGuarda.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_fine() {
		Comando c = this.fabbricaComandi.costruisciComando(Comandi.FINE.toString().toLowerCase());
		assertEquals(this.comandoFine.getNome(), c.getNome());
		assertEquals(this.comandoFine.getParametro(), c.getParametro());
	}
	
	@Test
	public void testCostruisciComando_aiuto() {
		Comando c = this.fabbricaComandi.costruisciComando(Comandi.AIUTO.toString().toLowerCase());
		assertEquals(this.comandoAiuto.getNome(), c.getNome());
		assertEquals(this.comandoAiuto.getParametro(), c.getParametro());
	}

}
