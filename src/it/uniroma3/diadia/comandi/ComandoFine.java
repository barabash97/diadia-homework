package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando {
	
	public ComandoFine() {
		this.setNome("fine");
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
