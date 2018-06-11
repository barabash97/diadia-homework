package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio {
	
	public abstract String agisci(Partita partita);

	private String nome;
	private String presentazione;
	private boolean haSalutato;
	
	private Attrezzo attrezzo;
	
	public AbstractPersonaggio() {
	}
	
	public AbstractPersonaggio(String nome, String presentaz) {
		this.nome = nome;
		this.presentazione = presentaz;
		this.haSalutato = false;
	}

	public String getNome() {
		return this.nome;
	}

	public boolean haSalutato() {
		return this.haSalutato;
	}

	public String saluta() {
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome() + ".");
		if (!haSalutato)
			risposta.append(this.presentazione);
		else
			risposta.append("Ci siamo gia' presentati!");
		this.haSalutato = true;
		return risposta.toString();
	}

	@Override
	public String toString() {
		String result =  this.getNome();
		if(attrezzo != null) {
			result += "\nAttrezzo:" + this.attrezzo.toString();
		}
		
		return result;
	}
	
	/**
	 * Personaggio può ricevere regalo
	 * @param attrezzo
	 * @param partita
	 * @return
	 */
	public abstract String riceviRegalo(Attrezzo attrezzo, Partita partita);

	/**
	 * @return the attrezzo
	 */
	public Attrezzo getAttrezzo() {
		return attrezzo;
	}

	/**
	 * @param attrezzo the attrezzo to set
	 */
	public void setAttrezzo(Attrezzo attrezzo) {
		this.attrezzo = attrezzo;
	}

	/**
	 * @return the presentazione
	 */
	public String getPresentazione() {
		return presentazione;
	}

	/**
	 * @param presentazione the presentazione to set
	 */
	public void setPresentazione(String presentazione) {
		this.presentazione = presentazione;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}
