package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {
	
	private String nomeParticolare;
	final public static String SLOGAN = "Qui c'è un buio pesto";
	final private static String ATTREZZO_PARTICOLARE_DEFAULT = "lanterna";
	public StanzaBuia(String nome) {
		this(nome, ATTREZZO_PARTICOLARE_DEFAULT);
	}
	
	public StanzaBuia(String nome, String nomeAttrezzoParticolare) {
		super(nome);
		this.setNomeParticolare(nomeAttrezzoParticolare);
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

	@Override
	public String getDescrizione() {
		String str = "";
		Attrezzo a = this.getAttrezzo(this.nomeParticolare);
		if(a == null) {
			str = SLOGAN;
		} else {
			str = a.toString();
		}
		return str;
	}

	
	
	
}
