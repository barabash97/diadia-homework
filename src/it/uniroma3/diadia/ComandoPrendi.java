package it.uniroma3.diadia;

public class ComandoPrendi implements Comando {
	
	/**
	 * Nome dell'oggetto da prendere
	 */
	private String nomeAttrezzo;
	
	@Override
	public void esegui(Partita partita) {
		if (this.getNomeOggetto() == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.prendiAttrezzo(this.nomeAttrezzo);

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	public String getNomeOggetto() {
		return nomeAttrezzo;
	}

}
