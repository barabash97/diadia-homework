package it.uniroma3.diadia.ambienti.stanze;

import it.uniroma3.diadia.enums.Direzioni;

public class StanzaBloccata extends Stanza {
	
	private String nomeParticolare;
	private String direzioneBloccata;
	
	final public static String SLOGAN = "Stanza bloccata";
	final private static String NOME_ATTREZZO_PARTICOLARE_DEFAULT = "lanterna";
	final private static String DIREZIONE_PARTICOLARE_DEFAULT = Direzioni.NORD.toString().toLowerCase();
	
	public StanzaBloccata() {
		super();
	}
	public StanzaBloccata(String nome) {
		this(nome, NOME_ATTREZZO_PARTICOLARE_DEFAULT, DIREZIONE_PARTICOLARE_DEFAULT);
	}
	
	public StanzaBloccata(String nome, String nomeParticolare) {
		this(nome, nomeParticolare , DIREZIONE_PARTICOLARE_DEFAULT);
	}
	
	public StanzaBloccata(String nome, String nomeParticolare, String direzioneBloccata) {
		super(nome);
		this.setNomeParticolare(nomeParticolare);
		this.setDirezioneBloccata(direzioneBloccata);
	}
	
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(this.getNomeParticolare())) {
			return this;
		} else {
			return super.getStanzaAdiacente(direzione);
		}
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(this.getNomeParticolare())) {
			return SLOGAN;
		} else {
			return super.getDescrizione();
		}
	}
	/**
	 * @return the nomeParticolare
	 */
	public String getNomeParticolare() {
		return nomeParticolare;
	}

	/**
	 * @param nomeParticolare the nomeParticolare to set
	 */
	public void setNomeParticolare(String nomeParticolare) {
		this.nomeParticolare = nomeParticolare;
	}

	/**
	 * @return the direzioneBloccata
	 */
	public String getDirezioneBloccata() {
		return direzioneBloccata;
	}

	/**
	 * @param direzioneBloccata the direzioneBloccata to set
	 */
	public void setDirezioneBloccata(String direzioneBloccata) {
		this.direzioneBloccata = direzioneBloccata;
	}

	/**
	 * @return the slogan
	 */
	public static String getSlogan() {
		return SLOGAN;
	}

	/**
	 * @return the attrezzoParticolareDefault
	 */
	public static String getAttrezzoParticolareDefault() {
		return NOME_ATTREZZO_PARTICOLARE_DEFAULT;
	}

	/**
	 * @return the direzioneParticolareDefault
	 */
	public static String getDirezioneParticolareDefault() {
		return DIREZIONE_PARTICOLARE_DEFAULT;
	}
	
	
}
