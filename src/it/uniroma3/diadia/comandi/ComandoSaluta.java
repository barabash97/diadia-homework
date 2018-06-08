package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando implements Comando {
	
	public ComandoSaluta() {
		this.setNome("saluta");
	}
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio p = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if(p != null) {
			p.saluta();
		}else {
			System.out.println("Non ci sono personaggi nella stanza");
		}
		
	}

}
