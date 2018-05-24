package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	private Borsa borsa;
	private Borsa borsaVuota;
	private Attrezzo osso;
	private Attrezzo chiave;
	private Attrezzo attrezzoNonPresente;
	private Attrezzo attrezzoPesoMassimo;
	private Attrezzo piombo;
	private Attrezzo ps;
	private Attrezzo piuma;
	private Attrezzo libro;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.borsaVuota = new Borsa(100);
		this.osso = new Attrezzo("osso",5);
		this.chiave = new Attrezzo("chiave", 5);
		this.attrezzoNonPresente = new Attrezzo("nonPresente", 5);
		this.attrezzoPesoMassimo = new Attrezzo("attrezzoPesoMassimo", this.borsa.getPesoMax());
		this.borsa.addAttrezzo(osso);
		this.borsa.addAttrezzo(chiave);
		//TEST SET, LIST, Comparator, Comparable
		this.piombo = new Attrezzo("piombo", 10);
		this.ps = new Attrezzo("ps", 5);
		this.piuma = new Attrezzo("piuma", 1);
		this.libro = new Attrezzo("libro", 5);
	}
	
	@Test
	public void testHasAttrezzo_presente() {
		assertTrue(this.borsa.hasAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void testHasAttrezzo_nonPresente() {
		assertFalse(this.borsa.hasAttrezzo(this.attrezzoNonPresente.getNome()));
	}
	
	@Test
	public void testIsPieno_pieno() {
		this.borsa.addAttrezzo(this.attrezzoPesoMassimo);
		assertTrue(this.borsa.isPieno());
	}
	
	@Test
	public void testIsPieno_nonPieno() {
		assertFalse(new Borsa().isPieno());
	}
	
	@Test
	public void testIsVuoto_vuoto() {
		assertTrue(new Borsa().isEmpty());
	}
	
	@Test
	public void testIsVuoto_nonVuoto() {
		this.borsa.addAttrezzo(this.attrezzoPesoMassimo);
		assertFalse(this.borsa.isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo_presente() {
		this.borsa.removeAttrezzo(this.osso.getNome());
		assertFalse(this.borsa.hasAttrezzo(this.osso.getNome()));
	}
	
	@Test
	public void testRemoveAttrezzo_nonPresente() {
		this.borsa.removeAttrezzo(this.attrezzoNonPresente.getNome());
		assertFalse(this.borsa.hasAttrezzo(this.attrezzoNonPresente.getNome()));
	}
	
	@Test 
	public void testPesoSufficientePerAggiungereAttrezzo_borsaVuota() {
		assertTrue(this.borsaVuota.addAttrezzo(new Attrezzo("attrezzo", 3)));
	}
	
	@Test 
	public void testPesoSufficientePerAggiungereAttrezzo_borsaPiena() {
		this.borsa.addAttrezzo(this.attrezzoPesoMassimo);
		assertFalse(this.borsa.addAttrezzo(new Attrezzo("attrezzo", 3)));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_presenzaAttrezzi() {
		Borsa b = this.getAttrezziToCompareInBorsa();
		List<Attrezzo> listaAttrezzi = b.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertEquals(this.piuma, it.next());
		assertEquals(this.libro, it.next());
		assertEquals(this.ps, it.next());
		assertEquals(this.piombo, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_vuotoAttrezzi() {
		List<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_presenzaAttrezzi() {
		Borsa b = this.getAttrezziToCompareInBorsa();
		SortedSet<Attrezzo> listaAttrezzi = b.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		System.out.println(listaAttrezzi);
		assertEquals(this.libro, it.next());
		assertEquals(this.piombo, it.next());
		assertEquals(this.piuma, it.next());
		assertEquals(this.ps, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_vuotoAttrezzi() {
		SortedSet<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertFalse(it.hasNext());
	}
	
	//@Test
	public void testGetContenutoRaggruppatoPerPeso_presente() {
		Borsa b = this.getAttrezziToCompareInBorsa();
		Map<Integer, Set<Attrezzo>> data = b.getContenutoRaggruppatoPerPeso();
//		assertTrue(data.get(1).contains(a1));
//		assertTrue(data.get(2).contains(a2));
//		assertTrue(data.get(3).contains(a3));
//		assertTrue(data.get(4).contains(a4));
		
	}
	
	//@Test
	public void testGetContenutoRaggruppatoPerNome_presente() {
//		Attrezzo a1 = new Attrezzo("aaaaaa", 1);
//		Attrezzo a2 = new Attrezzo("bbbbbb", 2);
//		Attrezzo a3 = new Attrezzo("cccccc", 3);
//		Attrezzo a4 = new Attrezzo("dddddd", 4);
//		assertTrue(this.borsaVuota.addAttrezzo(a1));
//		assertTrue(this.borsaVuota.addAttrezzo(a2));
//		assertTrue(this.borsaVuota.addAttrezzo(a3));
//		assertTrue(this.borsaVuota.addAttrezzo(a4));
//		Map<String, Set<Attrezzo>> data = this.borsaVuota.getContenutoRaggruppatoPerNome();
//		assertTrue(data.get(a1.getNome()).contains(a1));
//		assertTrue(data.get(a2.getNome()).contains(a2));
//		assertTrue(data.get(a3.getNome()).contains(a3));
//		assertTrue(data.get(a4.getNome()).contains(a4));
	}
	
	public Borsa getAttrezziToCompareInBorsa() {
		Borsa b = new Borsa(100000);
		b.addAttrezzo(this.piuma);
		b.addAttrezzo(this.ps);
		b.addAttrezzo(this.libro);
		b.addAttrezzo(this.piombo);
		return b;
	}
}
