package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando implements Comando {
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	private String messaggio;

	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();

		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			s.append(personaggio.agisci(partita));
		} else
			s.append(MESSAGGIO_CON_CHI);
		return s.toString();
	}
}

//END COMANDO