package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private String nome;
	private int cfu;
	private Borsa borsa;
	
	/**
	 * Construtture della classe Giocatore
	 * @param name nome del giocatore
	 */
	public Giocatore(String name) {
		this.nome = name;
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

	public static int getCfuIniziali() {
		return CFU_INIZIALI;
	}
	
	/**
	 * Decremento CFU
	 */
	public void decrementaCfu() {
		if(this.cfu > 0) {
			this.cfu--;
		}
	}
	
	/**
	 * Aggiungere attrezzo nella borsa
	 * @param attrezzo
	 * @return
	 */
	public boolean prendereAttrezzo(Attrezzo attrezzo) {
		
		if(attrezzo == null) {
			return false;
		}
		
		if(this.getBorsa().possibileAggiungereAttrezzo(attrezzo)) {
			return this.getBorsa().addAttrezzo(attrezzo);
		}
		
		return false;
	}
	
	/**
	 * Descrizione del giocatore
	 */
	public String toString() {
		StringBuilder stringa = new StringBuilder("");
		
		stringa.append("Nome del giocatore: " + this.getNome() + "\n");
		stringa.append("CFU: " + this.getCfu() + "\n");
		
		return stringa.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((borsa == null) ? 0 : borsa.hashCode());
		result = prime * result + cfu;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Giocatore other = (Giocatore) obj;
		if (borsa == null) {
			if (other.borsa != null)
				return false;
		} else if (!borsa.equals(other.borsa))
			return false;
		if (cfu != other.cfu)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
