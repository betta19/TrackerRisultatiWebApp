package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import trackerRisulatiWebApp.model.Utente;
import trackerRisultatiWebApp.service.Mail;
import trackerRisultatiWebApp.service.Service;

@WebServlet(name = "registrazione", urlPatterns = { "/registrazione" })
public class Registrazione extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String mail = req.getParameter("mail");
		String password = req.getParameter("password");
		long ratingIniziale = Long.parseLong("ratingIniziale");
		Service s = new Service(emf);
		
		
		Utente u = s.checkRegistraUtente(mail, password);
	   if (u == null && !mail.equals("admin")) {
			s.salvaUtente(mail, password, ratingIniziale);
			
			try {
				Mail.sendEmail(mail, "Conferma Mail", generaLinkValidazioneUtente(mail));
			} catch (MessagingException | IOException e) {

				e.printStackTrace();
			}

			req.setAttribute("mess",
					"La registrazione sarà confermata solo dopo aver cliccato sul link che le abbiamo inviato sulla sua mail");
			s.close();

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

		else {
req.setAttribute("mess",
					"Credenziali già presenti; provi con un altra mail, se è gia registrato per entrare nel sito cliccare su Accedi");
			
			s.close();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
		}

	}

	private String generaLinkValidazioneUtente(String mail) {
		String validationPath = "http://localhost:8080/trackerrisulatiwebapp/validazione?mail=";
		return "Per attivare la mail clicca su questo link: " + validationPath + mail;
	}

}
