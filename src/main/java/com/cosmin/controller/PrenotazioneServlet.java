package com.cosmin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import com.cosmin.model.Biglietti;
import com.cosmin.model.Prenotazione;
import com.cosmin.model.Utente;
import com.cosmin.utilities.BigliettiDao;
import com.cosmin.utilities.DaoFactory;
import com.cosmin.utilities.PrenotazioneDao;

@WebServlet("/Prenotazione")
public class PrenotazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFactory factory = DaoFactory.getFactory();
		BigliettiDao bigliettiDao = factory.getBigliettiDao();
		int idBiglietto = Integer.parseInt(request.getParameter("id"));
		Biglietti biglietto = bigliettiDao.findById(idBiglietto);
		request.getSession().setAttribute("bigliettoDaPrenotare", biglietto);
		request.setAttribute("biglietto", biglietto);
		request.getRequestDispatcher("WEB-INF/jsp/Prenotazione.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DaoFactory factory = DaoFactory.getFactory();
		PrenotazioneDao prenotazioneDao = factory.getPrenotazioneDao();
		Utente utente = (Utente)request.getSession().getAttribute("utente");
		String dataString = request.getParameter("dataRitiro");
		LocalDate dataPrenotazione = LocalDate.parse(dataString);
		LocalDate dataOdierna = LocalDate.now();
		Biglietti biglietto = (Biglietti)request.getSession().getAttribute("bigliettoDaPrenotare");
		Prenotazione p = new Prenotazione(dataOdierna, dataPrenotazione, biglietto, utente);
		prenotazioneDao.savePrenotazione(p);
		request.setAttribute("esito", "Prenotazione completata con ");
		request.setAttribute("biglietto", biglietto);
		request.getRequestDispatcher("WEB-INF/jsp/Prenotazione.jsp").forward(request, response);

	}

}
