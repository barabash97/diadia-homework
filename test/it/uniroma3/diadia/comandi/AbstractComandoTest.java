package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbstractComandoTest {

	private AbstractComandoAlfa comandoAstratto;
	private String paramEmpty;
	private String param;

	@Before
	public void setUp() throws Exception {
		this.comandoAstratto = new AbstractComandoAlfa();
		this.param = new String("parametro");
		this.paramEmpty = new String("");
	}

	@Test
	public void testSetParametro() {
		this.comandoAstratto.setParametro(this.param);
		assertEquals(this.param, this.comandoAstratto.getParametro());
	}
	
	@Test
	public void testSetParametro_empty() {
		this.comandoAstratto.setParametro(this.paramEmpty);
		assertEquals(0, this.comandoAstratto.getParametro().length());
	}

}
