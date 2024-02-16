package com.porta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porta.model.Prenotazione;

import dao.PrenotazioneDao;

@WebServlet(description = "Servlet per aggiungere prenotazione", urlPatterns = { "/CreaPrenotazione.do" })
public class CreaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreaPrenotazione() {
        super();
     // Costruttore predefinito della servlet
    }

     // Metodo invocato quando viene effettuata una richiesta POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Creazione di un'istanza di PrenotazioneDao per interagire con il database
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
		
		// Creazione di un'istanza di Prenotazione utilizzando i parametri ricevuti dalla richiesta POST
		Prenotazione prenotazione = new Prenotazione(
				request.getParameter("nomeCognome"),
				request.getParameter("recapitoTelefonico"),
				request.getParameter("numeroPersone")
				);
		
		// Salvataggio della prenotazione nel database utilizzando il PrenotazioneDao
		prenotazioneDao.savePrenotazione(prenotazione);
		
		// Reindirizzamento alla pagina prenotazioneEffettuata.jsp dopo aver completato la prenotazione
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("prenotazioneEffettuata.jsp");
		requestDispatcher.forward(request, response);
	}

}
