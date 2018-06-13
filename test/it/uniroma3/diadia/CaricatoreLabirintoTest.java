package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {

	private CaricatoreLabirinto caricatore;
	private LineNumberReader stringPersonaggi;
	private LineNumberReader stringStanze;
	private LineNumberReader stringUscite;
	private LineNumberReader stringAttrezzi;
	private LineNumberReader stringAttrezziPersonaggi;
	private LineNumberReader stringInizioVincente;

	@Before
	public void setUp() throws Exception {
		this.caricatore = new CaricatoreLabirinto("init.txt");
		this.stringPersonaggi = new LineNumberReader(new StringReader("Personaggi:mago biblioteca Fausts Salve"));
		this.stringStanze = new LineNumberReader(new LineNumberReader(new StringReader("Stanze: biblioteca, N10, N11, buia buia, block bloccata")));
		this.stringInizioVincente = new LineNumberReader(new StringReader("biblioteca\nN11"));
		this.stringUscite = new LineNumberReader(new StringReader("Uscite:biblioteca nord N10, biblioteca sud N11"));
		this.stringAttrezzi =new LineNumberReader( new StringReader("Attrezzi:martello 10 biblioteca, pinza 2 N10"));
		this.stringAttrezziPersonaggi = new LineNumberReader(new StringReader("AttrezziPersonaggi: attrezzoMagico 1 biblioteca, attrezzoCane 1 N10, attrezzoStrega 1 N11"));
	}
	
	@Test
	public void testLeggiECreaStanze() throws FormatoFileNonValidoException {
		this.caricatore.setReader(this.stringStanze);
		this.caricatore.leggiECreaStanze();
	}
	
	@Test
	public void testLeggiInizialeEvincente() throws FormatoFileNonValidoException {
//		this.caricatore.setReader(this.stringInizioVincente);
//		this.caricatore
	}

}
