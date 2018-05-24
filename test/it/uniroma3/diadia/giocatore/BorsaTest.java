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
	private Attrezzo pesoUno;
	private Attrezzo pesoDue;
	private Attrezzo pesoTre;
	private Attrezzo pesoQuattro;
	private Borsa borsaVuotaPesoMaxElevato;
	private Borsa borsaVuotaPesoPoco;
	private Attrezzo attrezzoPesoElevato;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.borsaVuota = new Borsa(100);
		this.borsaVuotaPesoMaxElevato = new Borsa(100000);
		this.borsaVuotaPesoPoco = new Borsa(1);
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
		this.pesoUno = new Attrezzo("pesoUno", 1);
		this.pesoDue = new Attrezzo("pesoDue", 2);
		this.pesoTre = new Attrezzo("pesoTre", 3);
		this.pesoQuattro = new Attrezzo("pesoQuattro", 4);
		this.attrezzoPesoElevato = new Attrezzo("attrezzo", 100000);
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
	public void testAddAttrezzo_DieciAttrezzi() {
		for(int i = 1; i <= 11; i++) {
			String str = "attrezzo" + i;
			Attrezzo a = new Attrezzo(str, i);
			assertTrue(this.borsaVuota.addAttrezzo(a));
		}
	}
	
	public void testAddAttrezzo_pesoInsufficiente() {
		assertFalse(this.borsaVuotaPesoPoco.addAttrezzo(this.attrezzoPesoMassimo));
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
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso_presente() {
		Borsa b = this.getAttrezziToCompareInBorsaPesoDiverso();
		Map<Integer, Set<Attrezzo>> data = b.getContenutoRaggruppatoPerPeso();
		assertTrue(data.get(this.pesoUno.getPeso()).contains(this.pesoUno));
		assertTrue(data.get(this.pesoDue.getPeso()).contains(this.pesoDue));
		assertTrue(data.get(this.pesoTre.getPeso()).contains(this.pesoTre));
		assertTrue(data.get(this.pesoQuattro.getPeso()).contains(this.pesoQuattro));	
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerNome_presente() {
		Borsa b = this.getAttrezziToCompareInBorsa();
		Map<String, Set<Attrezzo>> data = b.getContenutoRaggruppatoPerNome();
		assertTrue(data.get(this.piuma.getNome()).contains(this.piuma));
		assertTrue(data.get(this.ps.getNome()).contains(this.ps));
		assertTrue(data.get(this.piombo.getNome()).contains(this.piombo));
		assertTrue(data.get(this.libro.getNome()).contains(this.libro));	
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesoDiversoNomeDiverso() {
		Borsa b = this.getAttrezziToCompareInBorsaPesoDiverso();
		SortedSet<Attrezzo> data = b.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = data.iterator();
		assertEquals(this.pesoUno, it.next());
		assertEquals(this.pesoDue, it.next());
		assertEquals(this.pesoTre, it.next());
		assertEquals(this.pesoQuattro, it.next());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesoUgualeNomeDiverso() {
		Borsa b = this.getAttrezziToCompareInBorsaPesoDiversoStessoNome();
		SortedSet<Attrezzo> data = b.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = data.iterator();
		assertEquals(this.chiave, it.next());
		assertEquals(this.osso, it.next());
	}
	@Test
	public void testGetSortedSetOrdinatoPerPeso_borsaVuota() {
		SortedSet<Attrezzo> data = this.borsaVuota.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> it = data.iterator();
		assertFalse(it.hasNext());
	}
	
	public Borsa getAttrezziToCompareInBorsa() {
		Borsa b = new Borsa(100000);
		b.addAttrezzo(this.piuma);
		b.addAttrezzo(this.ps);
		b.addAttrezzo(this.libro);
		b.addAttrezzo(this.piombo);
		return b;
	}
	
	
	public Borsa getAttrezziToCompareInBorsaPesoDiverso() {
		Borsa b = new Borsa(100000);
		b.addAttrezzo(this.pesoUno);
		b.addAttrezzo(this.pesoDue);
		b.addAttrezzo(this.pesoTre);
		b.addAttrezzo(this.pesoQuattro);
		return b;
	}
	
	public Borsa getAttrezziToCompareInBorsaPesoDiversoStessoNome() {
		Borsa b = new Borsa(100000);
		b.addAttrezzo(this.osso);
		b.addAttrezzo(this.chiave);
		return b;
	}
}
