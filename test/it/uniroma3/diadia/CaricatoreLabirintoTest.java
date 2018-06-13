package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {

	private CaricatoreLabirinto caricatore;
	private Exception exp;
	private String test1 = new String(
			"Stanze: biblioteca, N10, N11, buia buia, block bloccata\n" + 
			"Inizio:biblioteca\n" + 
			"Vincente:N11\n" + 
			"Uscite:biblioteca nord N10, biblioteca sud N11, N10 nord buia, buia sud block\n" + 
			"Attrezzi:martello 10 biblioteca, pinza 2 N10\n" + 
			"Personaggi:mago biblioteca Fausts Salve, cane N10 Pippo BAUBAU, strega N11 UrsulaKemp Salve\n" + 
			"AttrezziPersonaggi: attrezzoMagico 1 biblioteca, attrezzoCane 1 N10, attrezzoStrega 1 N11\n" + 
			"\n" + 
			"");
	
	private String test2 = new String(
			"Stanze:\n" + 
			"Inizio:\n" + 
			"Vincente:\n" + 
			"Uscite:biblioteca nord N10, biblioteca sud N11, N10 nord buia, buia sud block\n" + 
			"Attrezzi:martello 10 biblioteca, pinza 2 N10\n" + 
			"Personaggi:mago biblioteca Fausts Salve, cane N10 Pippo BAUBAU, strega N11 UrsulaKemp Salve\n" + 
			"AttrezziPersonaggi: attrezzoMagico 1 biblioteca, attrezzoCane 1 N10, attrezzoStrega 1 N11\n" + 
			"\n" + 
			"");
	@Before
	public void setUp() throws Exception {
		this.exp = null;
	}
	
	@Test
	public void testLeggiECreaStanze_stanzePresenti() {
		try {
			this.caricatore = new CaricatoreLabirinto(this.test1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.caricatore.carica();
		} catch (FormatoFileNonValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(this.caricatore.getNome2stanza().size() > 0);
	}
	
	@Test
	public void testLeggiInizialeEvincente_presente() {
		try {
			this.caricatore = new CaricatoreLabirinto(this.test1);
			this.caricatore.carica();
		} catch (FileNotFoundException | FormatoFileNonValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(this.caricatore.getStanzaIniziale());
		assertNotNull(this.caricatore.getStanzaVincente());
	}
	
	
	@Test
	public void testLeggiECreaStanze_stanzeNonPresenti() {
		try {
			this.caricatore = new CaricatoreLabirinto(this.test2);
			this.caricatore.carica();
		} catch (FileNotFoundException | FormatoFileNonValidoException e) {
			// TODO Auto-generated catch block
			this.exp = e;
		}
		
		assertEquals(new FormatoFileNonValidoException("").getClass(), this.exp.getClass());
		
	}
		


}
