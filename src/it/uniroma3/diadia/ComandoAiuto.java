package it.uniroma3.diadia;

public class ComandoAiuto implements Comando {
	
	private String[] elencoComandi; 
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Lista comandi:");
		for (int i = 0; i < this.elencoComandi.length; i++)
			System.out.print(this.elencoComandi[i] + " ");
		System.out.println();
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
