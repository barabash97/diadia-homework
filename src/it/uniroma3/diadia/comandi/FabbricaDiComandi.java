package it.uniroma3.diadia.comandi;

public interface FabbricaDiComandi {
	/**
	 * Construzione del comando
	 * @param istruzione
	 * @return
	 */
	public Comando costruisciComando(String istruzione);
}
