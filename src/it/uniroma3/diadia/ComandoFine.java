package it.uniroma3.diadia;

public class ComandoFine implements Comando {
	
	private String parametro;
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!"); // si desidera smettere
		System.exit(1);

	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
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
