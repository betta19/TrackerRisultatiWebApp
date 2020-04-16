package trackerRisultatiWebApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


import trackerRisulatiWebApp.model.Utente;
public class Service {
EntityManager em;

public Service(EntityManagerFactory emf) {

	 
	this.em = emf.createEntityManager();
}
public Utente getUtente (String mail) {
	 Utente utente = (Utente) em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail").setParameter("mail", mail).getSingleResult();
    return utente;
   
}

public boolean controlloUtente(Utente u) {
	@SuppressWarnings("unchecked")
	List<Utente> lista =  em.createQuery("SELECT u FROM Utente u WHERE u.id = :id ").setParameter("id", u.getId()).getResultList();
	
}
}