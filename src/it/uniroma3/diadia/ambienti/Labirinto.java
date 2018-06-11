package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;

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
	 * Construttore del labirinto
	 * 
	 * @param start
	 * @param finish
	 */
	public Labirinto(String nomeFile) {
		CaricatoreLabirinto c = null;
		try {
			c = new CaricatoreLabirinto(nomeFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			c.carica();
			this.stanzaCorrente = c.getStanzaIniziale();
			this.stanzaFinale = c.getStanzaVincente();
		} catch (FormatoFileNonValidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Controllo se le due stanze sono uguali
	 * @return
	 */
	public boolean stanzeUguali() {
		return this.getStanzaCorrente().equals(this.getStanzaFinale());
	}
	
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}

	public void setStanzaCorrente(Stanza stanzaIniziale) {
		this.stanzaCorrente = stanzaIniziale;
	}

	public Stanza getStanzaFinale() {
		return this.stanzaFinale;
	}

	public void setStanzaFinale(Stanza stanzaFinale) {
		this.stanzaFinale = stanzaFinale;
	}
	
	@Override
	public boolean equals(Object o) {
		Labirinto l = (Labirinto) o;
		return this.getStanzaCorrente().equals(l.getStanzaCorrente()) && 
				this.getStanzaFinale().equals(l.getStanzaFinale());
	}
	
}
