package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando {
	
	private String[] elencoComandi; 
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
		this.setNome("aiuto");
	}
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Lista comandi:");
		for (int i = 0; i < this.elencoComandi.length; i++)
			System.out.print(this.elencoComandi[i] + " ");
		System.out.println();
	}	

}
