package com.cosmin.utilities;

import java.util.List;

import com.cosmin.model.Biglietti;
import com.cosmin.model.Prenotazione;
import com.cosmin.model.Utente;


public interface PrenotazioneDao {
	List<Prenotazione> findAllPrenotazioni();
	boolean savePrenotazione(Prenotazione prenotazione);
	Prenotazione findById(int id);
	List<Prenotazione> findByBiglietto(Biglietti biglietto);
	List<Prenotazione> findByUtente(Utente utente);
	public void updatePrenotazione(Prenotazione p);
}
