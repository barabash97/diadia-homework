package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Memorizza gli oggetti di un giocatore
 * 
 * @author darkness
 *
 */
public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;

	/**
	 * Costruttore senza paramentri
	 */
	public Borsa() {
		/**
		 * Chiama costruttore Passa Peso massimo della borsa di default
		 */
		this(DEFAULT_PESO_MAX_BORSA);
	}

	/**
	 * Peso massimo di una borsa
	 * 
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}

	/**
	 * Aggiungere attrezzi nella borsa del giocatore
	 * 
	 * @param attrezzo
	 * @return ritorna true se attrezzo è stato aggiunto, altrimenti false
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (!this.pesoSufficientePerAggiungereAttrezzo(attrezzo))
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		return true;
	}

	/**
	 * Gettere peso massimo
	 * 
	 * @return
	 */
	public int getPesoMax() {
		return pesoMax;
	}

	/**
	 * Restitiusce il riferimento all'oggetto Attrezzo
	 * 
	 * @param nomeAttrezzo
	 *            stringa nome dell'attrezzo
	 * @return se presente restituisce il riferimento all'oggetto Attrezzo,
	 *         altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	/**
	 * Getter peso della borsa
	 * 
	 * @return intero
	 */
	public int getPeso() {

		int sommaPeso = 0;
		Iterator<String> it = this.attrezzi.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			sommaPeso += this.attrezzi.get(key).getPeso();
		}

		return sommaPeso;
	}

	/**
	 * Controllo se la borsa è vuota
	 * 
	 * @return booleano
	 */
	public boolean isEmpty() {
		return this.getPeso() == 0;
	}

	/**
	 * Controllo se attrezzo è presente nella borsa
	 * 
	 * @param nomeAttrezzo
	 *            nome stringa dell'attrezzo
	 * @return true se la borsa ha questo attrezzo, altrimenti false
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	/**
	 * Rimuovere un attrezzo dalla borsa
	 * 
	 * @param nomeAttrezzo
	 *            nome stringa dell'attrezzo
	 * @return restituisce true se l'attrezzo è stato rimosso, altrimenti false
	 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getAttrezzo(nomeAttrezzo);

		if (a != null) {
			this.attrezzi.remove(nomeAttrezzo);
			return true;
		}

		return false;
	}

	/**
	 * Restituisce la stringa con il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			Iterator<String> it = this.attrezzi.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				s.append(this.attrezzi.get(key).toString() + " ");
			}
		} else
			s.append("Borsa vuota");
		s.append("\nPeso della borsa: " + this.getPeso() + "kg");
		return s.toString();
	}

	/**
	 * Controlla se la borsa è piena
	 * 
	 * @return
	 */
	public boolean isPieno() {
		return (this.getPeso() == this.getPesoMax());
	}

	/**
	 * Il peso rimasto della borsa è sufficiente per aggiungere attrezzo
	 * 
	 * @param attrezzo
	 * @return ritorna true se peso è sufficiente, altrimenti false
	 */
	public boolean pesoSufficientePerAggiungereAttrezzo(Attrezzo attrezzo) {
		return ((this.getPeso() + attrezzo.getPeso()) <= this.getPesoMax());
	}

	/**
	 * Controllo se è possibile aggiungere attrezzo nella borsa
	 * 
	 * @param attrezzo
	 * @return
	 */
	public boolean possibileAggiungereAttrezzo(Attrezzo attrezzo) {

		if (attrezzo == null) {
			return false;
		}

		if (!this.isPieno() && this.pesoSufficientePerAggiungereAttrezzo(attrezzo)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Getter numero attrezzi nella borsa
	 * 
	 * @return
	 */
	public int getNumeroAttrezzi() {
		return this.attrezzi.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrezzi == null) ? 0 : attrezzi.hashCode());
		result = prime * result + pesoMax;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Borsa other = (Borsa) obj;
		if (attrezzi == null) {
			if (other.attrezzi != null)
				return false;
		} else if (!attrezzi.equals(other.attrezzi))
			return false;
		if (pesoMax != other.pesoMax)
			return false;
		return true;
	}

	/**
	 * Contenuto ordinato per peso
	 * 
	 * @return
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> data = new ArrayList<>(this.attrezzi.values());
		ContenutoOrdinatoPerPeso order = new ContenutoOrdinatoPerPeso();
		Collections.sort(data, order);
		return data;
	}

	/**
	 * Contenuto ordinato per nome
	 * 
	 * @return
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		ContenutoOrdinatoPerNome order = new ContenutoOrdinatoPerNome();
		SortedSet<Attrezzo> data = new TreeSet<>(order);
		data.addAll(this.attrezzi.values());
		return data;
	}

	/**
	 * Contenuto raggruppato per peso
	 * 
	 * @return
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, Set<Attrezzo>> out = new HashMap<>();
		Iterator<String> keys = this.attrezzi.keySet().iterator();
		while (keys.hasNext()) {
			Set<Attrezzo> data = new HashSet<>();
			Attrezzo a = this.attrezzi.get(keys.next());
			data.add(a);
			out.put(a.getPeso(), data);
		}
		return out;
	}

	/**
	 * Contenuto raggruppato per nome
	 * 
	 * @return
	 */
	public Map<String, Set<Attrezzo>> getContenutoRaggruppatoPerNome() {
		Map<String, Set<Attrezzo>> out = new HashMap<>();
		Iterator<String> keys = this.attrezzi.keySet().iterator();
		while (keys.hasNext()) {
			Set<Attrezzo> data = new HashSet<>();
			Attrezzo a = this.attrezzi.get(keys.next());
			data.add(a);
			out.put(a.getNome(), data);
		}
		return out;
	}

}