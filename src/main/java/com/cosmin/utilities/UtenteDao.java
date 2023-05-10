package com.cosmin.utilities;

import java.util.List;

import com.cosmin.model.Utente;


public interface UtenteDao {
	boolean findByUsernameAndPassword(String username, String password);
	List<Utente> findAll();
	void save(Utente utente);
	String findNameByUsername(String username);
	Utente findUtenteById(int id);
	Utente findUtenteByUsername(String username);
	void updateUsername(Utente utente);
	void updatePassword(Utente utente);
}
