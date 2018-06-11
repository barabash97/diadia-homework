package it.uniroma3.diadia;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InterfacciaUtenteConsole implements InterfacciaUtente {

	private Scanner scannerDiLinee;

	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio);
	}

	@Override
	public String prendiIstruzione() {
		scannerDiLinee = new Scanner(System.in);
		String result = "";
		try {
			result = scannerDiLinee.nextLine();
		} catch (NoSuchElementException e) {
			this.mostraMessaggio("\n" + e.getMessage() + "\n");
		}
		return result;
	}

}
