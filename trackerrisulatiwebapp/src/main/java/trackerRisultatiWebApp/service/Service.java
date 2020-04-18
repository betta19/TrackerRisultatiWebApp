package trackerRisultatiWebApp.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.Part;

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

		Query query = em.createQuery("SELECT ut FROM Utente ut WHERE ut.mail = :mail ", Utente.class);
		query.setParameter("mail", mail);
		u = (Utente) query.getSingleResult();

		try {
			return u;
		} catch (NoResultException e) {
			return null;
		}

	}

	public Utente controlloUtente(String mail, String password) {

		Query query = em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail and u.password = :password ",
				Utente.class);
		query.setParameter("mail", mail);
		query.setParameter("password", password);
		Utente u = (Utente) query.getSingleResult();
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

	public void validaUtente(String mail) {

		Query query = em.createQuery("SELECT u FROM Utente u WHERE u.mail = :mail", Utente.class);
		query.setParameter("mail", mail);
		Utente utente = (Utente) query.getSingleResult();
		em.getTransaction().begin();
		utente.setActive(true);
		em.getTransaction().commit();

	}

	public Utente checkRegistraUtente(String mail, String password) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Utente> cr = cb.createQuery(Utente.class);
		Root<Utente> root = cr.from(Utente.class);
		cr.select(root);

		TypedQuery<Utente> query = em.createQuery(
				cr.where(cb.and(cb.equal(root.get("mail"), mail), cb.equal(root.get("password"), password))));

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

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

	public void salvaEroe(String nome, Part image, String heroDescrizione, int heroPower) throws IOException {

		InputStream f = image.getInputStream();
		byte[] imageBytes = new byte[(int) image.getSize()];
		f.read(imageBytes, 0, imageBytes.length);
		f.close();
		String imageStr = Base64.getEncoder().encodeToString(imageBytes);
		Eroe e = new Eroe();
		e.setNome(nome);
		e.setImmagine(imageStr);
		e.setHeroDescrizione(heroDescrizione);
		e.setHeroPower(heroPower);

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

	}

	public Eroe checkNomeEroe(String nome) {

		Query query = em.createQuery("SELECT e FROM Eroe e WHERE e.nome = :nome", Eroe.class);
		query.setParameter("nome", nome);
		try {
			Eroe eroe = (Eroe) query.getSingleResult();
			return eroe;
		} catch (NoResultException e) {
			return null;
		}

	}

	public Comp salvaComp(String nome) {
		Comp c = new Comp();
		c.setNome(nome);
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}
}
