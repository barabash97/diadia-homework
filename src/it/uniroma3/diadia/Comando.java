package it.uniroma3.diadia;

public interface Comando {
	/**
	 * esecuzione del comando
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * set parametro del comando
	 * @param parametro
	 */
	public void setParametro(String parametro);
}
