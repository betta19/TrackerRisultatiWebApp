package trackerRisultatiWebApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import trackerRisulatiWebApp.model.Comp;
import trackerRisulatiWebApp.model.Eroe;
import trackerRisulatiWebApp.model.Utente;



public class Service {
EntityManager em;

public Service(EntityManagerFactory emf) {

	 
	this.em = emf.createEntityManager();
}

public void close() {
	this.em.close();
}
public Utente getUtente (String mail) {
	 Utente utente = (Utente) em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail").setParameter("mail", mail).getSingleResult();
    return utente;
    
   
}

public boolean controlloUtente(Utente u) {
	
	List<Utente> lista =  em.createQuery("SELECT u FROM Utente u WHERE u.id = :id ", Utente.class).setParameter("id", u.getId()).getResultList();
	
	for (int i = 0; i < lista.size(); i++) {
		if (lista.get(i).getId() == u.getId()) {
			return true;
		}
	} return false;
		
	}

public List<Eroe> stampaListaEroi() {
	
	List<Eroe> lista = em.createQuery("SELECT e FROM Eroe e", Eroe.class).getResultList();
	return lista;
		
}

public List<Comp> stampaListaComp() {
	
	List<Comp> lista = em.createQuery("SELECT c FROM Comp c", Comp.class).getResultList();
	return lista;
}

public boolean checkRegistraUtente(String mail) {
	
	/*List<Utente> lista =  em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail ", Utente.class).setParameter("mail", mail).getResultList();

	
	
	for (int i = 0; i < lista.size(); i++) {
		if (lista.get(i).getMail().equals(mail)) {
			return true;
		}
	} return false;*/
	
	Utente u = this.em.find(Utente.class, mail);
	
	if (u.getMail().equals(mail)) {
		return true;
	} return false;
}

public void salvaUtente(String mail, String password) {
	
   Utente utente = new Utente();
    
   utente.setMail(mail);
   utente.setPassword(password);
   utente.setTipo("cliente");
    
    
    em.getTransaction().begin();
    em.persist(utente);
    em.getTransaction().commit();
    
	
}
	
}
