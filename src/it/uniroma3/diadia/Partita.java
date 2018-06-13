package it.uniroma3.diadia;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.stanze.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.enums.Direzioni;
import it.uniroma3.diadia.enums.Values;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Questa classe modella una partita del gioco
 *
 * @author docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private InterfacciaUtente io;
	private boolean finita; // Flag se la partita è terminata
	private Labirinto labirinto; // oggetto Labirinto
	private Giocatore giocatore; // oggetto Giocatore

	/**
	 * Construttore della classe partita Inizializza le stanze e labirinto
	 * Inizializza: CFU Imposta: partita vinta = false
	 */
	public Partita() {
		this.io = new InterfacciaUtenteConsole();
		//creaStanze(); // Inizializzazione delle stanza e attrezzi
		this.finita = false;
		this.giocatore = new Giocatore("Vladimir");
		this.labirinto = new Labirinto("init.txt");
		System.out.println(this.getLabirinto().getStanzaCorrente().getPersonaggio().getAttrezzo());
	}

	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	private void creaStanze() {
		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna", 3);
		Attrezzo osso = new Attrezzo("osso", 1);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");

		AbstractPersonaggio mago = new Mago("Faust", "Salve...", new Attrezzo("attrezzoMagico", 8));
		AbstractPersonaggio cane = new Cane("Pippo", "BAU BAU...", "carne", new Attrezzo("carne", 1));
		AbstractPersonaggio strega = new Strega("Ursula Kemp", "Salve...");

		/* collega le stanze */
		atrio.impostaStanzaAdiacente(Direzioni.NORD.toString(), biblioteca);
		atrio.impostaStanzaAdiacente(Direzioni.EST.toString(), aulaN11);
		atrio.impostaStanzaAdiacente(Direzioni.SUD.toString(), aulaN10);
		atrio.impostaStanzaAdiacente(Direzioni.OVEST.toString(), laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzioni.EST.toString(), laboratorio);
		aulaN11.impostaStanzaAdiacente(Direzioni.OVEST.toString(), atrio);
		aulaN10.impostaStanzaAdiacente(Direzioni.NORD.toString(), atrio);
		aulaN10.impostaStanzaAdiacente(Direzioni.EST.toString(), aulaN11);
		aulaN10.impostaStanzaAdiacente(Direzioni.OVEST.toString(), laboratorio);
		laboratorio.impostaStanzaAdiacente(Direzioni.EST.toString(), atrio);
		laboratorio.impostaStanzaAdiacente(Direzioni.OVEST.toString(), aulaN11);
		biblioteca.impostaStanzaAdiacente(Direzioni.SUD.toString(), atrio);
		atrio.setPersonaggio(mago);
		laboratorio.setPersonaggio(strega);
		aulaN11.setPersonaggio(cane);
		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		for (int i = 0; i < 10; i++) {
			atrio.addAttrezzo(new Attrezzo("attrezzo" + i, i));
		}

		for (int i = 10; i < 20; i++) {
			laboratorio.addAttrezzo(new Attrezzo("attrezzo" + i, i / 2));
		}

		
		
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getLabirinto().stanzeUguali();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return this.finita || this.vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	/**
	 * Getter oggetto Labirinto
	 * 
	 * @return
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	/**
	 * Getter oggetto Giocatore
	 * 
	 * @return
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}

	/**
	 * Setter oggetto Giocatore
	 * 
	 * @param giocatore
	 */
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	/**
	 * Riferimento ad attrezzo della stanza corrente
	 * 
	 * @param nomeAttrezzo
	 * @return
	 */
	public boolean getAttrezzoStanzaCorrente(String nomeAttrezzo) {
		Attrezzo a = this.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if (a == null) {
			return false;
		}

		return false;
	}

	/**
	 * Prendere attrezzo dalla stanza
	 */
	public void prendiAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		boolean flag = this.getGiocatore().prendereAttrezzo(a);
		if (flag) {
			this.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			this.io.mostraMessaggio("Attrezzo è stato aggiunto nello zaino");
		} else {
			this.io.mostraMessaggio("Non è stato possibile aggiungere attrezzo nello zaino");
		}
	}

	/**
	 * Posare attrezzo dallo zaino
	 * 
	 * @param nomeAttrezzo
	 */
	public void posaAttrezzo(String nomeAttrezzo) {
		Attrezzo a = this.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		boolean flag = false;
		if (!this.controlloPresenzaAttrezzoInUnaDelleDueStanze(nomeAttrezzo) && a != null) {
			flag = true;
		}
		if (flag) {
			if (this.getLabirinto().getStanzaCorrente().addAttrezzo(a)) {
				this.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				this.io.mostraMessaggio("Attrezzo è stato posato nella stanza");
			}

		} else {
			this.io.mostraMessaggio("Non è stato possibile posare attrezzo nella stanza");
		}
	}

	public boolean controlloPresenzaAttrezzoInUnaDelleDueStanze(String nomeAttrezzo) {
		return (this.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo) == true
				|| this.getLabirinto().getStanzaFinale().hasAttrezzo(nomeAttrezzo) == true);
	}

	/**
	 * Controllo se la partita è vinta
	 * 
	 * @return
	 */
	public boolean checkPartitaVinta() {
		if (this.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean checkPartitaPersa() {
		return (this.getGiocatore().getCfu() == 0) ? true : false;
	}

	/**
	 * Stanza ordinata per numero attrezzi
	 * 
	 * @param param
	 * @return
	 */
	public Map<String, Stanza> getStanzaAdiacenteConNumeroAttrezzi() {
		Set<String> direzioniValide = this.getLabirinto().getStanzaCorrente().getDirezioni();
		Map<String, Stanza> map = new HashMap<>();
		Iterator<String> it = direzioniValide.iterator();

		if (it.hasNext() == false) {
			return null;
		}

		Stanza primaStanza = this.getLabirinto().getStanzaCorrente().getStanzaAdiacente(it.next());
		Stanza maxAttrezzi = primaStanza;
		Stanza minAttrezzi = primaStanza;

		while (it.hasNext()) {
			String direzione = it.next();
			Stanza stanza = this.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
			if (maxAttrezzi.getAttrezzi().size() < stanza.getAttrezzi().size()) {
				maxAttrezzi = stanza;
			}
			if (stanza.getAttrezzi().size() < minAttrezzi.getAttrezzi().size()) {
				minAttrezzi = stanza;
			}
		}
		map.put(Values.MAX.toString().toLowerCase(), maxAttrezzi);
		map.put(Values.MIN.toString().toLowerCase(), minAttrezzi);
		return map;
	}

}
