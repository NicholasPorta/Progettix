package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.porta.model.Prenotazione;

import utils.HibernateUtil;

public class PrenotazioneDao {

	
	 // Metodo per salvare una prenotazione nel database
	public void savePrenotazione(Prenotazione prenotazione) {
		
		// Inizializzazione di una transazione
		Transaction transaction = null;
		
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			
			 // Inizio della transazione
			transaction = session.beginTransaction();
			
			// Salvataggio della prenotazione nel database
			session.save(prenotazione);
			
			// Conferma della transazione (commit)
			transaction.commit();
			
		
		} catch (Exception e) {
			if(transaction != null)
				transaction.rollback();// Annullamento della transazione in caso di errore
		}
	}
}
