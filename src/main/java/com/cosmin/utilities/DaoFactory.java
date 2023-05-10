package com.cosmin.utilities;


public abstract class DaoFactory {
	public abstract UtenteDao getUtenteDao();
	public abstract BigliettiDao getBigliettiDao();
	public abstract PrenotazioneDao getPrenotazioneDao();
	
	public static DaoFactory getFactory() {
		
			return  new FactoryMysqlJPA();

	}

}
