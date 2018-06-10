package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando implements Comando {
	
	private String[] elencoComandi; 
	
	public ComandoAiuto(String[] elencoComandi) {
		this.elencoComandi = elencoComandi;
		this.setNome("aiuto");
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("Lista comandi:\n");
	
		for (int i = 0; i < this.elencoComandi.length; i++)
			s.append(this.elencoComandi[i] + " ");
		return s.toString();
	}	

}
