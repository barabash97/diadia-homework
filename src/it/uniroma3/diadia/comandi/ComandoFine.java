package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando implements Comando {
	
	public ComandoFine() {
		this.setNome("fine");
	}

	@Override
	public void esegui(Partita partita) {
		this.setNome("fine");
		System.out.println("Grazie di aver giocato!"); // si desidera smettere
		System.exit(1);

	}


}
