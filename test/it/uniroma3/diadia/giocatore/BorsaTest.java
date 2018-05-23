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
		Attrezzo a1 = new Attrezzo("aaaaaa", 1);
		Attrezzo a2 = new Attrezzo("bbbbbb", 2);
		Attrezzo a3 = new Attrezzo("cccccc", 3);
		Attrezzo a4 = new Attrezzo("dddddd", 4);
		this.borsaVuota.addAttrezzo(a1);
		this.borsaVuota.addAttrezzo(a2);
		this.borsaVuota.addAttrezzo(a3);
		this.borsaVuota.addAttrezzo(a4);
		List<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertEquals(a1, it.next());
		assertEquals(a2, it.next());
		assertEquals(a3, it.next());
		assertEquals(a4, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_vuotoAttrezzi() {
		List<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerPeso();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_presenzaAttrezzi() {
		Attrezzo a1 = new Attrezzo("aaaaaa", 1);
		Attrezzo a2 = new Attrezzo("bbbbbb", 2);
		Attrezzo a3 = new Attrezzo("cccccc", 3);
		Attrezzo a4 = new Attrezzo("dddddd", 4);
		this.borsaVuota.addAttrezzo(a1);
		this.borsaVuota.addAttrezzo(a2);
		this.borsaVuota.addAttrezzo(a3);
		this.borsaVuota.addAttrezzo(a4);
		SortedSet<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertEquals(a1, it.next());
		assertEquals(a2, it.next());
		assertEquals(a3, it.next());
		assertEquals(a4, it.next());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome_vuotoAttrezzi() {
		SortedSet<Attrezzo> listaAttrezzi = this.borsaVuota.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> it = listaAttrezzi.iterator();
		assertFalse(it.hasNext());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		Attrezzo a1 = new Attrezzo("aaaaaa", 1);
		Attrezzo a2 = new Attrezzo("bbbbbb", 2);
		Attrezzo a3 = new Attrezzo("cccccc", 3);
		Attrezzo a4 = new Attrezzo("dddddd", 4);
		assertTrue(this.borsaVuota.addAttrezzo(a1));
		assertTrue(this.borsaVuota.addAttrezzo(a2));
		assertTrue(this.borsaVuota.addAttrezzo(a3));
		assertTrue(this.borsaVuota.addAttrezzo(a4));
		Map<Integer, Set<Attrezzo>> data = this.borsaVuota.getContenutoRaggruppatoPerPeso();
		System.out.println(data);
		assertTrue(data.get(1).contains(a1));
		assertTrue(data.get(2).contains(a2));
		assertTrue(data.get(3).contains(a3));
		assertTrue(data.get(4).contains(a4));
		
	}
}
