package com.cosmin.utilities;

import java.util.List;
import javax.persistence.EntityManager;
import com.cosmin.model.Biglietti;

public class BigliettiDaoImplJPA implements BigliettiDao{
	private static BigliettiDaoImplJPA instance;
	private BigliettiDaoImplJPA() {}
	
	public static BigliettiDaoImplJPA getInstance() {
		if(instance == null) {
			instance = new BigliettiDaoImplJPA();
		}
		return instance;
	}

	@Override
	public List<Biglietti> findAll() {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		List<Biglietti> biglietti = manager.createNamedQuery("Libro.findAll",Biglietti.class).getResultList();				
		return biglietti;
	}

	@Override
	public boolean remove(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		manager.getTransaction().begin();
		int row = manager.createQuery("delete from Libro l where l.id=:id").setParameter("id", id).executeUpdate();
		manager.getTransaction().commit();
		if(row>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean save(Biglietti biglietto) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();

		
		try {
			manager.getTransaction().begin();
			manager.persist(biglietto);
			manager.getTransaction().commit();
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();		}
		return false;
	}
	
	public Biglietti findById(int id) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		Biglietti biglietto = manager.createQuery("select b from Biglietti b where b.id=:id", Biglietti.class).setParameter("id", id).getSingleResult();
		return biglietto;
	}
	

	@Override
	public List<Biglietti> findByUtente(int idUtente) {
		EntityManager manager = FactoryMysqlJPA.getEntityManager();
		@SuppressWarnings("unchecked")
		List<Biglietti> biglietti = (List<Biglietti>)manager.createQuery("select b from Biglietti b join b.utenti u where u.id=:id").setParameter("id", idUtente).getResultList();
		return biglietti;
	}

}
