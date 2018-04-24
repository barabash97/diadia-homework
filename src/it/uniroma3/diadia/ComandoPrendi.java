package it.uniroma3.diadia;

public class ComandoPrendi implements Comando {
	
	/**
	 * Nome dell'oggetto da prendere
	 */
	private String parametro;
	
	/**
	 * Nome comando
	 */
	private String nome;
	
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.prendiAttrezzo(this.parametro);

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
