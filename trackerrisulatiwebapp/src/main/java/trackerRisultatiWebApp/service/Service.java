package trackerRisultatiWebApp.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
		if (query.getSingleResult() == null) {
			return null;
		}
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
	/*public void salvaEroe(String nome, InputStream image, String heroDescrizione, String heroPower) throws IOException {
		
		Eroe e = new Eroe();

		e.setNome(nome);
		
		byte[] picInBytes = new byte[(byte) image.readAllBytes()];

		image.read(picInBytes);
		image.close();
		
		e.setImmagine(picInBytes);
		e.setHeroDescrizione(heroDescrizione);
		e.setHeroPower(heroPower);

		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();

	}
	
	public Utente prendiImmagine(InputStream inputStream) {

		PreparedStatement statement = connessione.prepareStatement("select immagine from utente where username = ?");
		statement.setString(1, username);
		ResultSet executeQuery = statement.executeQuery();
		while (executeQuery.next()) {
			Blob blob = executeQuery.getBlob("immagine");
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = outputStream.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);

			return new Utente(username, base64Image);
		}
		return null;

	}*/
}
