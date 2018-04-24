package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {
	
	private String direzione;
	
	@Override
	public void esegui(Partita partita) {
		
		Labirinto labirinto = partita.getLabirinto();
		Giocatore giocatore = partita.getGiocatore();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.direzione == null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
			
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			labirinto.setStanzaCorrente(prossimaStanza);
			giocatore.decrementaCfu();
		}
		System.out.println(stanzaCorrente.getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

}
