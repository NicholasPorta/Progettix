package utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.porta.model.Prenotazione;


public class HibernateUtil {

	// Factory per la creazione delle sessioni Hibernate
	private static SessionFactory sessionFactory;
	
	// Metodo per ottenere la session factory
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory == null) {
		   try {
			
			// Se la session factory non è ancora stata creata, crea una nuova istanza	   
			   Configuration configuration = new Configuration();
			   Properties properties = new Properties();
			
			// Impostazione delle proprietà per la configurazione di Hibernate   
			   properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			   properties.put(Environment.URL,"jdbc:mysql://localhost:3306/porta?useSSL=false");
			   properties.put(Environment.USER, "root");
			   properties.put(Environment.PASS, "andrea3");
			   properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			   properties.put(Environment.SHOW_SQL, true);
			
			   
		   // Impostazione delle proprietà di configurazione e delle classi annotate
			   configuration.setProperties(properties);
			   configuration.addAnnotatedClass(Prenotazione.class);
			  
			   
			   // Costruzione del registro dei servizi Hibernate e creazione della session factory   
			   ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					   .applySettings(configuration.getProperties()).build();
			   
			   sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			   
		   } catch (Exception e) {
			e.printStackTrace();// Gestione delle eccezioni stampando la traccia sullo standard output
		   }
		}
		
		return sessionFactory;
	}
}
