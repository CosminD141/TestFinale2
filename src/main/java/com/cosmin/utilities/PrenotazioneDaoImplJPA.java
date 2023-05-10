package com.cosmin.utilities;

import java.util.List;

import javax.persistence.EntityManager;

import com.cosmin.model.Biglietti;
import com.cosmin.model.Prenotazione;
import com.cosmin.model.Utente;

public class PrenotazioneDaoImplJPA implements PrenotazioneDao{
	private static PrenotazioneDaoImplJPA instance;
	private PrenotazioneDaoImplJPA() {}
	
	public static PrenotazioneDaoImplJPA getInstance() {
		if(instance == null) {
			instance = new PrenotazioneDaoImplJPA();
		} 
		return instance;
	}

	@Override
	public List<Prenotazione> findAllPrenotazioni() {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select p from Prenotazione p", Prenotazione.class).getResultList();
	}

	@Override
	public boolean savePrenotazione(Prenotazione prenotazione) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(prenotazione);
			manager.getTransaction().commit();
			return true;
		}catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Prenotazione findById(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		
		return manager.createQuery("select p from Prenotazione p where p.id=:id", Prenotazione.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Prenotazione> findByBiglietto(Biglietti biglietto) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select p from Prenotazione p where p.biglietto=:biglietto", Prenotazione.class).setParameter("biglietto", biglietto).getResultList();
	}

	@Override
	public List<Prenotazione> findByUtente(Utente utente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		return manager.createQuery("select p from Prenotazione p where p.utente=:utente", Prenotazione.class).setParameter("utente", utente).getResultList();
	}
	
	@Override
	public void updatePrenotazione(Prenotazione p) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(p);
		manager.getTransaction().commit();
	}

}
