package it.uniroma3.diadia;

public class ComandoPosa implements Comando {
	
	/**
	 * Nome dell'oggetto da posare
	 */
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if (this.nomeAttrezzo == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.posaAttrezzo(this.getNomeOggetto());

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	public String getNomeOggetto() {
		return nomeAttrezzo;
	}
	
}
