package com.cosmin.controller;

import com.cosmin.model.Utente;
import com.cosmin.utilities.DaoFactory;
import com.cosmin.utilities.UtenteDao;


public class Main {

	public static void main(String[] args) {
		DaoFactory factory = DaoFactory.getFactory();
		
		
		UtenteDao utenteDao = factory.getUtenteDao();
		Utente utente = new Utente("Riccardo", "Riccardi", "Riccardo@gmail.com", "Riccardo_141!");
		utenteDao.save(utente);
	}

}
