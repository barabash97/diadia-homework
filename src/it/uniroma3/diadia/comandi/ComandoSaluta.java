package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando implements Comando {
	
	public ComandoSaluta() {
		this.setNome("saluta");
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();

		AbstractPersonaggio p = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		
		if(p != null) {
			return p.saluta();
		}else {
			s.append("Non ci sono personaggi nella stanza\n");
		}
		
		return s.toString();
	}

}
