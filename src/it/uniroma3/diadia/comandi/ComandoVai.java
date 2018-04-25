package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
	
	private String parametro;
	private String nome;
	
	public ComandoVai() {
		this.setNome("vai");
	}
	
	@Override
	public void esegui(Partita partita) {
		
		Labirinto labirinto = partita.getLabirinto();
		Giocatore giocatore = partita.getGiocatore();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.parametro == null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
			
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(parametro);
		
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			labirinto.setStanzaCorrente(prossimaStanza);
			giocatore.decrementaCfu();
		}
		System.out.println(stanzaCorrente.getDescrizione());
	}

	/**
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
