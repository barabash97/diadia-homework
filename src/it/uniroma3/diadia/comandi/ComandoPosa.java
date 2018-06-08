package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando implements Comando {

	
	public ComandoPosa() {
		this.setNome("posa");
	}
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			System.out.println("Non è stato inserito il nome dell\'attrezzo");
			return;
		}

		partita.posaAttrezzo(this.getParametro());

	}


}
