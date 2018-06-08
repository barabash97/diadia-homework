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

		if (nomeComando == null) {
			comando = new ComandoNonValido();
			return comando;
		} else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto(this.elencoComandi);
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("saluta"))
			comando = new ComandoSaluta();
		else if (nomeComando.equals("interagisci"))
			comando = new ComandoInteragisci();

		else
			comando = new ComandoNonValido();
		
		if(parametro != null) {
			comando.setParametro(parametro);
		}
		
		return comando;
	}

	/**
	 * @return the elencocomandi
	 */
	public static String[] getElencoComandi() {
		return elencoComandi;
	}
	
	

}
