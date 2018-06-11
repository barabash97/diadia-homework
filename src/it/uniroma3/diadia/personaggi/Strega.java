package it.uniroma3.diadia.personaggi;

import java.util.Map;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.enums.Values;

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_STANZA_MENO_ATTREZZI = "Sarai trasferito nella stanza con meno attrezzi!";
	private static final String MESSAGGIO_STANZA_PIU_ATTREZZI = "Sarai trasferito nella stanza con più attrezzi!";
	private static final String RISATA = "HAHAHAH";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		Map<String, Stanza> stanze = partita.getStanzaAdiacenteConNumeroAttrezzi();
		if(!this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(stanze.get(Values.MIN.toString().toLowerCase()));
			return MESSAGGIO_STANZA_MENO_ATTREZZI;
		}
		partita.getLabirinto().setStanzaCorrente(stanze.get(Values.MAX.toString().toLowerCase()));
		return MESSAGGIO_STANZA_PIU_ATTREZZI;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		this.setAttrezzo(attrezzo);
		return RISATA;
	}
	

}
