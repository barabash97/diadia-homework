package it.uniroma3.diadia.personaggi;

import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_STANZA_MENO_ATTREZZI = "Sarai trasferito nella stanza con meno attrezzi!";
	private static final String MESSAGGIO_STANZA_PIU_ATTREZZI = "Sarai trasferito nella stanza con più attrezzi!";
	
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		Map<String, Stanza> stanze = partita.getStanzaAdiacenteConNumeroAttrezzi();
		if(!this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(stanze.get("min"));
			return MESSAGGIO_STANZA_MENO_ATTREZZI;
		}
		partita.getLabirinto().setStanzaCorrente(stanze.get("max"));
		return MESSAGGIO_STANZA_PIU_ATTREZZI;
	}
	

}
