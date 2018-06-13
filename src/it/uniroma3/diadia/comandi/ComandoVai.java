package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.stanze.Stanza;
import it.uniroma3.diadia.enums.Comandi;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando implements Comando {
	
	public ComandoVai() {
		this.setNome(Comandi.VAI.toString().toLowerCase());
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();

		Labirinto labirinto = partita.getLabirinto();
		Giocatore giocatore = partita.getGiocatore();
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if (this.getParametro() == null) {
			s.append("Dove vuoi andare ?\n");
			return s.toString();
		}
			
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.getParametro());
		
		if (prossimaStanza == null)
			s.append("Direzione inesistente\n");
		else {
			labirinto.setStanzaCorrente(prossimaStanza);
			giocatore.decrementaCfu();
		}
		s.append(prossimaStanza.getDescrizione() + "\n");
		return s.toString();
	}

	
}
