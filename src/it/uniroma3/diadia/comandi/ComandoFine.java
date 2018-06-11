package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.enums.Comandi;

public class ComandoFine extends AbstractComando implements Comando {
	
	public ComandoFine() {
		this.setNome(Comandi.FINE.toString().toLowerCase());
	}

	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		this.setNome("fine");
		s.append("Grazie di aver giocato!\n");
		System.exit(1);
		return s.toString();
	}


}
