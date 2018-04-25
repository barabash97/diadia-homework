package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	
	private String nomeParticolare;
	
	public StanzaBloccata(String nome) {
		super(nome);
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
	
	
	
}
