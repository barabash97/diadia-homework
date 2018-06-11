package it.uniroma3.diadia;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author docente di POO (da un'idea di Michael Kolling and David J. Barnes)
 * 
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""
			+ "Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n"
			+ "Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"
			+ "I locali sono popolati da strani personaggi, " + "alcuni amici, altri... chissa!\n"
			+ "Ci sono attrezzi che potrebbero servirti nell'impresa:\n"
			+ "puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n"
			+ "o regalarli se pensi che possano ingraziarti qualcuno.\n\n"
			+ "Per conoscere le istruzioni usa il comando 'aiuto'.";

	

	private Partita partita;
	private InterfacciaUtente io;
	
	public DiaDia() {
		this.partita = new Partita();
		this.io = new InterfacciaUtenteConsole();
	}

	public void gioca() {
		String istruzione;

		System.out.println(MESSAGGIO_BENVENUTO);

		do
			istruzione = this.io.prendiIstruzione();
		while (!processaIstruzione(istruzione));
	}

	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false
	 *         altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva();
		
		comandoDaEseguire = factory.costruisciComando(istruzione);
		String result = comandoDaEseguire.esegui(this.partita);
		
		if(this.partita.checkPartitaPersa()) {
			System.out.println("Hai perso!");
			comandoDaEseguire = factory.costruisciComando("fine");
			result = comandoDaEseguire.esegui(this.partita);
		}
		
		System.out.println(result);
		return this.partita.checkPartitaVinta();
	}
	
	/**
	 * Funzione main per esecuzione iniziale del programma
	 * 
	 * @param argc
	 */
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}

}