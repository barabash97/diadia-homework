package it.uniroma3.diadia;

public class ComandoFine implements Comando {

	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!"); // si desidera smettere
		System.exit(1);

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
