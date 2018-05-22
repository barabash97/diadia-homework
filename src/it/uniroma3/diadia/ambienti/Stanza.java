package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Classe Stanza - una stanza in un gioco di ruolo. Una stanza e' un luogo
 * fisico nel gioco. E' collegata ad altre stanze attraverso delle uscite. Ogni
 * uscita e' associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	private String nome;
	protected Set<Attrezzo> attrezzi;
	private Map<String, Stanza> stanzeAdiacenti;
	private Set<String> direzioni;

	/**
	 * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
	 * 
	 * @param nome
	 *            il nome della stanza
	 */
	public Stanza(String nome) {
		this.nome = nome;
		this.direzioni = new HashSet<>();
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashSet<>();
	}

	/**
	 * Imposta una stanza adiacente.
	 *
	 * @param direzione
	 *            direzione in cui sara' posta la stanza adiacente.
	 * @param stanza
	 *            stanza adiacente nella direzione indicata dal primo parametro.
	 */
	public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
		boolean aggiornato = false;

		Iterator<String> it = this.direzioni.iterator();

		while (it.hasNext()) {
			String direzioneSingola = it.next();
			if (direzioneSingola.equals(direzione)) {
				this.stanzeAdiacenti.put(direzione, stanza);
				aggiornato = true;
			}
		}

		if (!aggiornato) {
			this.direzioni.add(direzione);
			this.stanzeAdiacenti.put(direzione, stanza);
		}

	}

	/**
	 * Restituisce la stanza adiacente nella direzione specificata
	 * 
	 * @param direzione
	 */
	public Stanza getStanzaAdiacente(String direzione) {
		return this.stanzeAdiacenti.get(direzione);
	}

	/**
	 * Restituisce la nome della stanza.
	 * 
	 * @return il nome della stanza
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce la descrizione della stanza.
	 * 
	 * @return la descrizione della stanza
	 */
	public String getDescrizione() {
		return this.toString();
	}

	/**
	 * Restituisce la collezione di attrezzi presenti nella stanza.
	 * 
	 * @return la collezione di attrezzi nella stanza.
	 */
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	/**
	 * Mette un attrezzo nella stanza.
	 * 
	 * @param attrezzo
	 *            l'attrezzo da mettere nella stanza.
	 * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {

		if (attrezzo == null) {
			return false;
		}

		return this.attrezzi.add(attrezzo);

	}

	/**
	 * Restituisce una rappresentazione stringa di questa stanza, stampadone la
	 * descrizione, le uscite e gli eventuali attrezzi contenuti
	 * 
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		StringBuilder risultato = new StringBuilder();

		risultato.append(this.nome);
		risultato.append("\nUscite: ");

		for (String direzione : this.direzioni)
			if (direzione != null)
				risultato.append(" " + direzione);

		risultato.append("\n");

		if (this.attrezzi.size() > 0) {
			risultato.append("Attrezzi nella stanza: ");
			for (Attrezzo attrezzo : this.attrezzi) {
				if (attrezzo != null) {
					risultato.append(attrezzo.toString() + " ");
				}
			}
		} else {
			risultato.append("Non ci sono attrezzi nella stanza");
		}

		return risultato.toString();
	}

	/**
	 * Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	 * 
	 * @return true se l'attrezzo esiste nella stanza, false altrimenti.
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {

		Iterator<Attrezzo> it = this.attrezzi.iterator();
		while (it.hasNext()) {
			Attrezzo a = it.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza. null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Iterator<Attrezzo> it = this.attrezzi.iterator();

		while (it.hasNext()) {
			Attrezzo a = it.next();
			if (a.getNome().equals(nomeAttrezzo)) {
				return a;
			}
		}

		return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * 
	 * @param nomeAttrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		return this.attrezzi.remove(attrezzo);
	}

	public Set<String> getDirezioni() {
		return this.direzioni;
	}

	/**
	 * to string attrezzi
	 * 
	 * @return
	 */
	public String toStringAttrezzi() {
		StringBuilder risultato = new StringBuilder();

		risultato.append("\nAttrezzi nella stanza: ");

		if (this.attrezzi.size() == 0) {
			risultato.append("Non ci sono attrezzi nella stanza");
		}

		for (Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) {
				risultato.append(attrezzo.toString() + " ");
			}
		}
		return risultato.toString();
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		Stanza s = (Stanza) o;
		return (this.getNome() == s.getNome());
	}

}