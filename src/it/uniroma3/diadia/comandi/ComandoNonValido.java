package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando implements Comando {
	
	
	public ComandoNonValido() {
		this.setNome("");
	}
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("Comando non valido.");
		return s.toString();

	}

	

}
