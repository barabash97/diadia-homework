package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, "
			+ "con una mia magica azione, troverai un nuovo oggetto " + "per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	public Mago() {
		super();
	}
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.setAttrezzo(attrezzo);
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.getAttrezzo() != null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.getAttrezzo());
			this.setAttrezzo(null);
			msg = MESSAGGIO_DONO;
		} else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
			int peso = attrezzo.getPeso();
			Attrezzo nuovoAttrezzo = new Attrezzo(attrezzo.getNome(), peso / 2);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			boolean flag = partita.getLabirinto().getStanzaCorrente().addAttrezzo(nuovoAttrezzo);
			if(flag) {
				partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			}
			
			return (flag) ? "Grazie per il regalo" : "Non posso ricevere questo regalo";
	}

}
