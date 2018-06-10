package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	
	private String ciboFavorito;
	
	private static final String MESSAGGIO = "BAU BAU!";
	
	
	public Cane(String nome, String presentaz, String ciboPreferito, Attrezzo attrezzo) {
		this(nome, presentaz, ciboPreferito);
		this.setAttrezzo(attrezzo);
	}
	
	public Cane(String nome, String presentaz, String ciboPreferito) {
		this(nome, presentaz);
		this.setCiboFavorito(ciboPreferito);
	}
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().decrementaCfu();
		partita.checkPartitaPersa();
		return MESSAGGIO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		if(attrezzo.getNome().equals(this.ciboFavorito)) {
			stanzaCorrente.addAttrezzo(this.getAttrezzo());
		} else {
			stanzaCorrente.addAttrezzo(attrezzo);
		}
		
		return "Grazie per il regalo" + MESSAGGIO;
	}

	/**
	 * @return the ciboFavorito
	 */
	public String getCiboFavorito() {
		return ciboFavorito;
	}

	/**
	 * @param ciboFavorito the ciboFavorito to set
	 */
	public void setCiboFavorito(String ciboFavorito) {
		this.ciboFavorito = ciboFavorito;
	}

}
