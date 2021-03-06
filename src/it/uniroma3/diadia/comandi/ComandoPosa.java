package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.enums.Comandi;

public class ComandoPosa extends AbstractComando implements Comando {

	
	public ComandoPosa() {
		this.setNome(Comandi.POSA.toString().toLowerCase());
	}
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();

		if (this.getParametro() == null) {
			s.append("Non è stato inserito il nome dell\'attrezzo");
			return s.toString();
		}

		partita.posaAttrezzo(this.getParametro());
		s.append("Attrezzo posato\n");
		return s.toString();
	}


}
