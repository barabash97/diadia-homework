package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	
	static final private String[] elencoComandi = { "vai", "aiuto", "fine", "prendi", "posa", "guarda", "saluta", "interagisci"};
	
	@Override
	public Comando costruisciComando(String istruzione) {

		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext()) {
			nomeComando = scannerDiParole.next();
		}

		if (scannerDiParole.hasNext()) {
			parametro = scannerDiParole.next();
		}

		StringBuilder nomeClasse
		= new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
		nomeClasse.append( nomeComando.substring(1) ) ;
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoVai’
		try {
			comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			comando = new ComandoNonValido();
		}
		comando.setParametro(parametro);
		return comando;
	}

	/**
	 * @return the elencocomandi
	 */
	public static String[] getElencoComandi() {
		return elencoComandi;
	}
	
	

}
