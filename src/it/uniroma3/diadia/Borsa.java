package it.uniroma3.diadia;

/**
 * Memorizza gli oggetti di un giocatore
 * 
 * @author darkness
 *
 */
public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi; //Array di attrezzi
	private int numeroAttrezzi; //contatore di attrezzi
	private int pesoMax; // peso massimo della borsa

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
		this.attrezzi = new Attrezzo[10]; // speriamo che bastino...
		this.numeroAttrezzi = 0;
	}

	/**
	 * Aggiungere attrezzi nella borsa del giocatore
	 * 
	 * @param attrezzo
	 * @return ritorna true se attrezzo è stato aggiunto, altrimenti false
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	/**
	 * Gettere peso massimo
	 * @return
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	
	/**
	 * Restitiusce il riferimento all'oggetto Attrezzo
	 * @param nomeAttrezzo stringa nome dell'attrezzo
	 * @return se presente restituisce il riferimento all'oggetto Attrezzo, altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	
	/**
	 * Getter peso della borsa
	 * @return intero
	 */
	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();
		return peso;
	}
	
	/**
	 * Controllo se la borsa è vuota
	 * @return booleano
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Controllo se attrezzo è presente nella borsa
	 * @param nomeAttrezzo nome stringa dell'attrezzo
	 * @return true se la borsa ha questo attrezzo, altrimenti false
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		// ---> TODO (implementare questo metodo) <---
		return a;
	}
	
	/**
	 * Stampa stringa del contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}