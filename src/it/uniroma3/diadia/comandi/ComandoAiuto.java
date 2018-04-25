package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {
	
	private String[] elencoComandi; 
	private String parametro;
	private String nome;
	
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

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

}
