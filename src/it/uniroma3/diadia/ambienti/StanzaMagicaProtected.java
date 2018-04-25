package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Una stanza magica ha delle particolarità, che la rendono diversa dalla stanza
 * ordinaria: – dopo N volte che in tale stanza viene posato (aggiunto) un
 * qualsiasi attrezzo da parte del giocatore, la stanza inizierà a comportarsi
 * «magicamente» – quando la stanza si comporta magicamente, ogni volta che
 * posiamo un attrezzo, la stanza "inverte" il nome dell'attrezzo e ne raddoppia
 * il peso. Ad esempio: se posiamo (togliamo dalla borsa e aggiungiamo alla
 * stanza) l'attrezzo con nome 'chiave' e peso 2, la stanza memorizza un
 * attrezzo con nome 'evaihc' e peso 4 – quando la stanza non si comporta
 * magicamente, il comportamento rimane quello usuale
 * 
 * @author darkness
 *
 */

public class StanzaMagicaProtected extends Stanza {

	protected int contatoreAttrezziPosati;
	protected int sogliaMagica;
	final protected static int SOGLIA_MAGICA_DEFAULT = 3;

	/**
	 * Construttore
	 * 
	 * @param nome
	 */
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}

	/**
	 * Costruttore della stanza magica
	 * 
	 * @param nome
	 *            Nome della stanza
	 * @param soglia
	 *            Soglia magica
	 */
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	// METODI

	/**
	 * Inverte il nome dell'attrezzo e raddoppia il peso
	 * 
	 * @param attrezzo
	 * @return Oggetto Attrezzo
	 */
	protected Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder s;
		int pesoRaddoppiato = attrezzo.getPeso() * 2;
		s = new StringBuilder(attrezzo.getNome());
		s = s.reverse(); // Nome invertito
		attrezzo = new Attrezzo(s.toString(), pesoRaddoppiato);
		return attrezzo;
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.incrementaContatoreAttrezziPosati();
		if (this.checkSogliaSuperata()) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}

		return super.addAttrezzo(attrezzo);
	}

	// GETTER&SETTER

	/**
	 * @return the contatoreAttrezziPosati
	 */
	public int getContatoreAttrezziPosati() {
		return contatoreAttrezziPosati;
	}

	/**
	 * @param contatoreAttrezziPosati
	 *            the contatoreAttrezziPosati to set
	 */
	public void setContatoreAttrezziPosati(int contatoreAttrezziPosati) {
		this.contatoreAttrezziPosati = contatoreAttrezziPosati;
	}

	/**
	 * @return the sogliaMagica
	 */
	public int getSogliaMagica() {
		return sogliaMagica;
	}

	/**
	 * @param sogliaMagica
	 *            the sogliaMagica to set
	 */
	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica;
	}

	/**
	 * @return the sogliaMagicaDefault
	 */
	public static int getSogliaMagicaDefault() {
		return SOGLIA_MAGICA_DEFAULT;
	}

	/**
	 * Incrementa numero attrezzi posati
	 * 
	 * @return
	 */
	public void incrementaContatoreAttrezziPosati() {
		this.contatoreAttrezziPosati++;
	}

	/**
	 * Contatore attrezzi posati impostato a zero
	 */
	public void azzeraContatoreAttrezziPosati() {
		this.contatoreAttrezziPosati = 0;
	}

	/**
	 * Controllo se la soglia magica è stata superata
	 * 
	 * @return
	 */
	public boolean checkSogliaSuperata() {
		return (this.contatoreAttrezziPosati > this.sogliaMagica);
	}
}
