package it.uniroma3.diadia.comandi;

import java.util.Scanner;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {
		
	private Scanner scannerDiParole;

	@Override
	public Comando costruisciComando(String istruzione) {

		scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;

		if (scannerDiParole.hasNext()) {
			nomeComando = scannerDiParole.next();
		}

		if (scannerDiParole.hasNext()) {
			parametro = scannerDiParole.next();
		}
		scannerDiParole.close();
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

	

}
