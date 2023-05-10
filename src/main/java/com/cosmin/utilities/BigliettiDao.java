package com.cosmin.utilities;

import java.util.List;

import com.cosmin.model.Biglietti;

public interface BigliettiDao {

	List<Biglietti> findAll();
	boolean remove(int id);
	boolean save(Biglietti biglietto);
	Biglietti findById(int id);
	List<Biglietti> findByUtente(int idUtente);

}
