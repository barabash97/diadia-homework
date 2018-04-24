package it.uniroma3.diadia;

public class ComandoNonValido implements Comando {
	
	private String nome;
	private String parametro;
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Comando non valido.");
		return;

	}

	@Override
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getParametro() {
		return parametro;
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	

}
