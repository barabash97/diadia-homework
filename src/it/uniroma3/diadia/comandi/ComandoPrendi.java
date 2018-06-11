package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.enums.Comandi;

public class ComandoPrendi extends AbstractComando implements Comando {
	
	
	public ComandoPrendi() {
		this.setNome(Comandi.PRENDI.toString().toLowerCase());
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		if (this.getParametro() == null) {
			s.append("Non è stato inserito il nome dell\'attrezzo\n");
			return s.toString();
		}

		partita.prendiAttrezzo(this.getParametro());
		s.append("Attrezzo è stato preso\n");
		return s.toString();
	}
	


	
}
