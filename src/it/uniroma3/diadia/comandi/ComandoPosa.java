package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {

	/**
	 * Nome dell'oggetto da posare
	 */
	private String parametro;

	/**
	 * Nome comando
	 */
	private String nome;
	
	
	public ComandoPosa() {
		this.setNome("posa");
	}
	@Override
	public void esegui(Partita partita) {
		if (this.parametro == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.posaAttrezzo(this.getParametro());

	}

	public String getParametro() {
		return parametro;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
