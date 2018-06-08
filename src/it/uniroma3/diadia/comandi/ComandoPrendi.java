package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPrendi extends AbstractComando implements Comando {
	
	
	public ComandoPrendi() {
		this.setNome("prendi");
	}
	
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.prendiAttrezzo(this.getParametro());

	}
	


	
}
