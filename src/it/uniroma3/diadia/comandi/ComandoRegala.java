package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando implements Comando {

	public ComandoRegala() {
		this.setNome("regala");
	}
	
	@Override	
	public void esegui(Partita partita) {
		if(this.getParametro() != null) {
			AbstractPersonaggio personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
			Borsa borsa = partita.getGiocatore().getBorsa();
			Attrezzo attrezzo = borsa.getAttrezzo(this.getParametro());
			if(attrezzo != null) {
				String result = personaggio.riceviRegalo(attrezzo, partita);
				borsa.removeAttrezzo(attrezzo.getNome());
				System.out.println(result);
			}
			
		}
	}


}
