package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;

public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO = "BAU BAU!";
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().decrementaCfu();
		partita.checkPartitaPersa();
		return MESSAGGIO;
	}

}
