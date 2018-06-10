package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando implements Comando {

	public ComandoGuarda() {
		this.setNome("guarda");
	}

	@Override
	public String esegui(Partita partita) {
		String s = new String();
		s += this.generazioneStampa("stanza", partita);
		s += this.generazioneStampa("giocatore", partita);
		s += this.generazioneStampa("borsa", partita);
		return s.toString();
	}

	/**
	 * Generazione delle stampa in base al parametro
	 * 
	 * @param oggettoStampa
	 * @param partita
	 */
	public String generazioneStampa(String oggettoStampa, Partita partita) {
		StringBuilder s = new StringBuilder();

		if (oggettoStampa == null) {
			return s.append("").toString();
		}

		s.append("########################### " + oggettoStampa.toUpperCase()
				+ " ####################################\n");
		s.append("\n");
		switch (oggettoStampa) {
		case "giocatore":
			s.append(partita.getGiocatore().toString() + "\n");
			break;
		case "stanza":
			s.append(partita.getLabirinto().getStanzaCorrente().toString() + "\n");
			break;
		case "borsa":
			s.append(partita.getGiocatore().getBorsa().toString() + "\n");
			break;

		default:
			s.append("----------------------------------------------------------------------------------\n");
			break;
		}
		s.append("\n");
		s.append("########################### FINE " + oggettoStampa.toUpperCase()
				+ " ###############################\n");
		return s.toString();
	}

}
