package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.enums.Comandi;

public class ComandoAiuto extends AbstractComando implements Comando {
		
	public ComandoAiuto() {
		this.setNome(Comandi.AIUTO.toString().toLowerCase());
	}
	
	@Override
	public String esegui(Partita partita) {
		StringBuilder s = new StringBuilder();
		s.append("Lista comandi:\n");
	
		for(Comandi valore : Comandi.values()) {
			s.append(valore.toString().toLowerCase() + " ");
		}
		return s.toString();
	}	

}
