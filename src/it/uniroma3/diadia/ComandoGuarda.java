package it.uniroma3.diadia;

public class ComandoGuarda implements Comando {

	@Override
	public void esegui(Partita partita) {
		this.generazioneStampa("stanza", partita);
		this.generazioneStampa("giocatore", partita);
		this.generazioneStampa("borsa", partita);
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Generazione delle stampa in base al parametro
	 * @param oggettoStampa
	 * @param partita
	 */
	public void generazioneStampa(String oggettoStampa, Partita partita) {
		
		if(oggettoStampa == null) {
			return;
		}
		
		System.out.println("########################### " + oggettoStampa.toUpperCase() + " ####################################");
		System.out.println("");
		switch(oggettoStampa) {
		case "giocatore":
			System.out.println(partita.getGiocatore().toString());
			break;
		case "stanza":
			System.out.println(partita.getLabirinto().getStanzaCorrente().toString());
			break;
		case "borsa":
			System.out.println(partita.getGiocatore().getBorsa().toString());
			break;
			
		default:
			System.out.println("----------------------------------------------------------------------------------");
			break;
		}
		System.out.println("");
		System.out.println("########################### FINE " + oggettoStampa.toUpperCase() + " ###############################");
	}
}
