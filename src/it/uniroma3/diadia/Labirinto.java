package it.uniroma3.diadia;

public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaFinale;
	
	/**
	 * Construttore del labirinto
	 * @param start
	 * @param finish
	 */
	public Labirinto(Stanza start, Stanza finish) {
		this.setStanzaCorrente(start);
		this.setStanzaFinale(finish);
	}
	
	/**
	 * Controllo se le due stanze sono uguali
	 * @return
	 */
	public boolean stanzaUguali() {
		return this.getStanzaCorrente().equals(this.getStanzaFinale());
	}
	
	
	public Stanza getStanzaCorrente() {
		return stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaIniziale) {
		this.stanzaCorrente = stanzaIniziale;
	}

	public Stanza getStanzaFinale() {
		return stanzaFinale;
	}

	public void setStanzaFinale(Stanza stanzaFinale) {
		this.stanzaFinale = stanzaFinale;
	}
	
	
}
