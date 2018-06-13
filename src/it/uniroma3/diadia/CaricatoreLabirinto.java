package it.uniroma3.diadia;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import it.uniroma3.diadia.ambienti.stanze.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class CaricatoreLabirinto {

	/* prefisso di una singola riga di testo contenente tutti i nomi delle stanze */
	private static final String STANZE_MARKER = "Stanze:";

	/* prefisso di una singola riga contenente il nome della stanza iniziale */
	private static final String STANZA_INIZIALE_MARKER = "Inizio:";

	/* prefisso della riga contenente il nome stanza vincente */
	private static final String STANZA_VINCENTE_MARKER = "Vincente:";

	/*
	 * prefisso della riga contenente le specifiche degli attrezzi da collocare nel
	 * formato <nomeAttrezzo> <peso> <nomeStanza>
	 */
	private static final String ATTREZZI_MARKER = "Attrezzi:";

	/*
	 * prefisso della riga contenente le specifiche dei collegamenti tra stanza nel
	 * formato <nomeStanzaDa> <direzione> <nomeStanzaA>
	 */
	private static final String USCITE_MARKER = "Uscite:";

	/* Personaggio */
	private static final String PERSONAGGI_MARKER = "Personaggi:";

	/* Attrezzi per i personaggi */
	private static final String ATTREZZI_PERSONAGGI_MARKER = "AttrezziPersonaggi:";

	/*
	 * Esempio di un possibile file di specifica di un labirinto (vedi
	 * POO-26-eccezioni-file.pdf)
	 * 
	 * Stanze: biblioteca, N10, N11 Inizio: N10 Vincente: N11 Attrezzi: martello 10
	 * biblioteca, pinza 2 N10 Uscite: biblioteca nord N10, biblioteca sud N11
	 * 
	 */
	private LineNumberReader reader;

	private Map<String, Stanza> nome2stanza;

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;

	public CaricatoreLabirinto(String nomeFile) throws FileNotFoundException {
		this.nome2stanza = new HashMap<String, Stanza>();
		this.reader = new LineNumberReader(new FileReader(nomeFile));
	}

	public void carica() throws FormatoFileNonValidoException {
		try {
			this.leggiECreaStanze();
			this.leggiInizialeEvincente();
			this.leggiEImpostaUscite();
			this.leggiECollocaAttrezzi();
			this.leggiPersonaggi();
			this.leggiECollocaAttrezziPersonaggi();

		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}

	private String leggiRigaCheCominciaPer(String marker) throws FormatoFileNonValidoException {
		try {
			String riga = this.reader.readLine();
			check(riga.startsWith(marker), "era attesa una riga che cominciasse per " + marker);
			return riga.substring(marker.length());
		} catch (IOException e) {
			throw new FormatoFileNonValidoException(e.getMessage());
		}
	}

	public void leggiECreaStanze() throws FormatoFileNonValidoException {
		String nomiStanze = this.leggiRigaCheCominciaPer(STANZE_MARKER);
		for (String stringaStanza : separaStringheAlleVirgole(nomiStanze)) {
			try (Scanner scannerDiLinea = new Scanner(stringaStanza)) {

				while (scannerDiLinea.hasNext()) {
					check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("Nome stanza assente."));
					String nomeStanza = scannerDiLinea.next();
					String tipoStanza = null;
					if (scannerDiLinea.hasNext()) {
						tipoStanza = scannerDiLinea.next();
					}

					StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.ambienti.stanze.");

					nomeClasse.append("Stanza");
					// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
					if (tipoStanza != null) {
						nomeClasse.append(tipoStanza.toUpperCase().charAt(0));
						nomeClasse.append(tipoStanza.substring(1));
					}

					Stanza stanza = new Stanza(nomeStanza);

					if (stanza != null) {
						// System.out.println(stanza);
						this.nome2stanza.put(stanza.getNome(), stanza);
					}
				}
			}
		
		}
	}

	private List<String> separaStringheAlleVirgole(String string) {
		List<String> result = new LinkedList<>();

		String[] arrayStringValue = string.split(Pattern.quote(","));
		for (String singleValue : arrayStringValue) {
			result.add(singleValue.trim());
		}

		return result;
	}

	private void leggiInizialeEvincente() throws FormatoFileNonValidoException {
		String nomeStanzaIniziale = null;
		nomeStanzaIniziale = this.leggiRigaCheCominciaPer(STANZA_INIZIALE_MARKER);
		check(this.isStanzaValida(nomeStanzaIniziale), nomeStanzaIniziale + " non definita");
		String nomeStanzaVincente = this.leggiRigaCheCominciaPer(STANZA_VINCENTE_MARKER);
		check(this.isStanzaValida(nomeStanzaVincente), nomeStanzaVincente + " non definita");
		this.stanzaIniziale = this.nome2stanza.get(nomeStanzaIniziale);
		this.stanzaVincente = this.nome2stanza.get(nomeStanzaVincente);
	}

	private void leggiECollocaAttrezzi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_MARKER);

		for (String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null;
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("il peso dell'attrezzo " + nomeAttrezzo + "."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(), msgTerminazionePrecoce(
						"il nome della stanza in cui collocare l'attrezzo " + nomeAttrezzo + "."));
				nomeStanza = scannerLinea.next();
			}
			posaAttrezzo(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}
	
	private void leggiECollocaAttrezziPersonaggi() throws FormatoFileNonValidoException {
		String specificheAttrezzi = this.leggiRigaCheCominciaPer(ATTREZZI_PERSONAGGI_MARKER);

		for (String specificaAttrezzo : separaStringheAlleVirgole(specificheAttrezzi)) {
			String nomeAttrezzo = null;
			String pesoAttrezzo = null;
			String nomeStanza = null;
			try (Scanner scannerLinea = new Scanner(specificaAttrezzo)) {
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("il nome di un attrezzo."));
				nomeAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(), msgTerminazionePrecoce("il peso dell'attrezzo " + nomeAttrezzo + "."));
				pesoAttrezzo = scannerLinea.next();
				check(scannerLinea.hasNext(), msgTerminazionePrecoce(
						"il nome della stanza in cui collocare l'attrezzo " + nomeAttrezzo + "."));
				nomeStanza = scannerLinea.next();
			}
			posaAttrezzoPersonaggio(nomeAttrezzo, pesoAttrezzo, nomeStanza);
		}
	}
	
	
	private void posaAttrezzo(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza)
			throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),
					"Attrezzo " + nomeAttrezzo + " non collocabile: stanza " + nomeStanza + " inesistente");
			this.nome2stanza.get(nomeStanza).addAttrezzo(attrezzo);
		} catch (NumberFormatException e) {
			check(false, "Peso attrezzo " + nomeAttrezzo + " non valido");
		}
	}
	
	private void posaAttrezzoPersonaggio(String nomeAttrezzo, String pesoAttrezzo, String nomeStanza)
			throws FormatoFileNonValidoException {
		int peso;
		try {
			peso = Integer.parseInt(pesoAttrezzo);
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			check(isStanzaValida(nomeStanza),
					"Stanza: " + nomeStanza + " non trovata");
			AbstractPersonaggio personaggio = this.nome2stanza.get(nomeStanza).getPersonaggio();
			if(personaggio != null) {
				personaggio.setAttrezzo(attrezzo);
				this.nome2stanza.get(nomeStanza).setPersonaggio(personaggio);
			}
			
			
		} catch (NumberFormatException e) {
			check(false, "Peso attrezzo " + nomeAttrezzo + " non valido");
		}
	}
	


	private boolean isStanzaValida(String nomeStanza) {
		return this.nome2stanza.containsKey(nomeStanza);
	}
	
	/**
	 * 
	 * @param nomeStanza
	 * @param nomePersonaggio
	 * @return
	 */
	private boolean isPersonaggioValido(String nomePersonaggio) {
		Set<String> keys = this.nome2stanza.keySet();
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			Stanza s = this.nome2stanza.get(it.next());
			if(s.getPersonaggio().getNome() == nomePersonaggio) {
				return true;
			}
		}
		return false;
	}

	private void leggiEImpostaUscite() throws FormatoFileNonValidoException {
		String specificheUscite = this.leggiRigaCheCominciaPer(USCITE_MARKER);
	
		try (Scanner scannerDiLinea = new Scanner(specificheUscite)) {

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("le uscite di una stanza."));
				String stanzaPartenza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(),
						msgTerminazionePrecoce("la direzione di una uscita della stanza " + stanzaPartenza));
				String dir = scannerDiLinea.next();
				
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce(
						"la destinazione di una uscita della stanza " + stanzaPartenza + " nella direzione " + dir));
				String stanzaDestinazione = scannerDiLinea.next().replace(",", "");
				
				impostaUscita(stanzaPartenza, dir, stanzaDestinazione.replace(",", " "));
			}
		}
	}

	private String msgTerminazionePrecoce(String msg) {
		return "Terminazione precoce del file prima di leggere " + msg;
	}

	private void impostaUscita(String stanzaDa, String dir, String nomeA) throws FormatoFileNonValidoException {
		//check(isStanzaValida(stanzaDa),"Stanza di partenza sconosciuta "+dir);
		//check(isStanzaValida(nomeA),"Stanza di destinazione sconosciuta "+ dir);
		Stanza partenzaDa = this.nome2stanza.get(stanzaDa);
		Stanza arrivoA = this.nome2stanza.get(nomeA);
		partenzaDa.impostaStanzaAdiacente(dir, arrivoA);
	}

	private void impostaPersonaggio(String tipoPersonaggio, String nomeStanza, String nomePersonaggio,
			String presentazione) throws FormatoFileNonValidoException {
		check(isStanzaValida(nomeStanza), "Stanza non valida: " + nomeStanza);
		Stanza s = this.nome2stanza.get(nomeStanza);

		// Stanza stanza = this.nome2stanza.get(nomeStanza);
		StringBuilder nomeClasse = new StringBuilder("it.uniroma3.diadia.personaggi.");
		nomeClasse.append(Character.toUpperCase(tipoPersonaggio.charAt(0)));
		// es. nomeClasse: ‘it.uniroma3.diadia.comandi.ComandoV’
		nomeClasse.append(tipoPersonaggio.substring(1));
		AbstractPersonaggio p = null;
		try {
			p = (AbstractPersonaggio) Class.forName(nomeClasse.toString()).newInstance();
			p.setNome(nomePersonaggio);
			p.setPresentazione(presentazione);
			s.setPersonaggio(p);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void leggiPersonaggi() throws FormatoFileNonValidoException {
		String personaggi = this.leggiRigaCheCominciaPer(PERSONAGGI_MARKER);

		try (Scanner scannerDiLinea = new Scanner(personaggi)) {

			while (scannerDiLinea.hasNext()) {
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("Tipo personaggio non presente."));
				String tipoPersonaggio = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("Nome stanza assente."));
				String nomeStanza = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("Nome personaggio assente"));
				String nomePersonaggio = scannerDiLinea.next();
				check(scannerDiLinea.hasNext(), msgTerminazionePrecoce("Presentazione personaggio assente"));
				String salutoPersonaggio = scannerDiLinea.next().replace(",", "");

				impostaPersonaggio(tipoPersonaggio, nomeStanza, nomePersonaggio, salutoPersonaggio);
			}
		}

	}

	final private void check(boolean condizioneCheDeveEsseraVera, String messaggioErrore)
			throws FormatoFileNonValidoException {
		if (!condizioneCheDeveEsseraVera)
			throw new FormatoFileNonValidoException(
					"Formato file non valido [" + this.reader.getLineNumber() + "] " + messaggioErrore);
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	/**
	 * @return the reader
	 */
	public LineNumberReader getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(LineNumberReader reader) {
		this.reader = reader;
	}

	/**
	 * @return the nome2stanza
	 */
	public Map<String, Stanza> getNome2stanza() {
		return nome2stanza;
	}

	/**
	 * @param nome2stanza the nome2stanza to set
	 */
	public void setNome2stanza(Map<String, Stanza> nome2stanza) {
		this.nome2stanza = nome2stanza;
	}

	/**
	 * @return the stanzeMarker
	 */
	public static String getStanzeMarker() {
		return STANZE_MARKER;
	}

	/**
	 * @return the stanzaInizialeMarker
	 */
	public static String getStanzaInizialeMarker() {
		return STANZA_INIZIALE_MARKER;
	}

	/**
	 * @return the stanzaVincenteMarker
	 */
	public static String getStanzaVincenteMarker() {
		return STANZA_VINCENTE_MARKER;
	}

	/**
	 * @return the attrezziMarker
	 */
	public static String getAttrezziMarker() {
		return ATTREZZI_MARKER;
	}

	/**
	 * @return the usciteMarker
	 */
	public static String getUsciteMarker() {
		return USCITE_MARKER;
	}

	/**
	 * @return the personaggiMarker
	 */
	public static String getPersonaggiMarker() {
		return PERSONAGGI_MARKER;
	}

	/**
	 * @return the attrezziPersonaggiMarker
	 */
	public static String getAttrezziPersonaggiMarker() {
		return ATTREZZI_PERSONAGGI_MARKER;
	}

	/**
	 * @param stanzaIniziale the stanzaIniziale to set
	 */
	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	/**
	 * @param stanzaVincente the stanzaVincente to set
	 */
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	
}