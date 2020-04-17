package trackerRisultatiWebApp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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

	public Utente getUtente(String mail) {
		Utente u;
		try {
			Query query = em.createQuery("SELECT ut FROM Utente ut WHERE ut.mail = :mail ", Utente.class);
			query.setParameter("mail", mail);
			u = (Utente) query.getSingleResult();
			if (u != null) {

			}
		} catch (Exception e) {
			return null;
		}
		return u;

	}

	public Utente controlloUtente(String mail, String password) {

		Query query = em
				.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail and u.password = :password ", Utente.class);
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		Utente u =  (Utente) query.getSingleResult();
		return u;
		/*
		 * try {
		 * 
		 * 
		 * if (u == null) { return false; } } catch (Exception e) { return false; }
		 * return true;
		 */

		/*
		 * List<Utente> lista =
		 * em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail ", Utente.class)
		 * .setParameter("mail", mail).getResultList();
		 * 
		 * for (int i = 0; i < lista.size(); i++) { if
		 * (lista.get(i).getMail().equals(mail)) { return true; } } return false;
		 */

	}

	public List<Eroe> stampaListaEroi() {

		List<Eroe> lista = em.createQuery("SELECT e FROM Eroe e", Eroe.class).getResultList();
		return lista;

	}

	public List<Comp> stampaListaComp() {

		List<Comp> lista = em.createQuery("SELECT c FROM Comp c", Comp.class).getResultList();
		return lista;
	}

	public Utente checkRegistraUtente(String mail, String password) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cr = cb.createQuery(Utente.class);
		Root<Utente> root = cr.from(Utente.class);
		cr.select(root);

		TypedQuery<Utente> query = em.createQuery(
				cr.where(cb.and(cb.equal(root.get("mail"), mail), cb.equal(root.get("password"), password))));
		Utente singleResult = query.getSingleResult();
		return singleResult;

		/*
		 * Utente u = this.em.find(Utente.class, mail);
		 * 
		 * if (u.getMail().equals(mail)) { return true; } return false;
		 */
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
