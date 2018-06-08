package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando implements Comando {
	
	public ComandoVai() {
		this.setNome("vai");
	}
	
	@Override
	public void esegui(Partita partita) {
		
		Labirinto labirinto = partita.getLabirinto();
		Giocatore giocatore = partita.getGiocatore();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.getParametro() == null) {
			System.out.println("Dove vuoi andare ?");
			return;
		}
			
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.getParametro());
		
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			labirinto.setStanzaCorrente(prossimaStanza);
			giocatore.decrementaCfu();
		}
		System.out.println(stanzaCorrente.getDescrizione());
	}

	
}
