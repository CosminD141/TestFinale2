package com.cosmin.utilities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryMysqlJPA extends DaoFactory{
	public static EntityManager getEntityManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestFinale2");
		factory.getCache().evictAll();
		EntityManager manager = factory.createEntityManager();
		return manager;
	}

	@Override
	public UtenteDao getUtenteDao() {
		return UtenteDaoImplJPA.getInstance();
	}

	@Override
	public BigliettiDao getBigliettiDao() {
		return BigliettiDaoImplJPA.getInstance();
	}


	@Override
	public PrenotazioneDao getPrenotazioneDao() {
		return PrenotazioneDaoImplJPA.getInstance();
	}
}
