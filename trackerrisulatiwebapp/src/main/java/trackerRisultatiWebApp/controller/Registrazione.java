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
		HttpSession session = req.getSession();
		Service s = new Service(emf);
		

		if (mail.equals("admin")) {
			req.setAttribute("mess", "Se sei l'amministratore, effettua l'accesso");

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else if (s.checkRegistraUtente(mail)) {
			req.setAttribute("mess",
					"Credenziali gi� presenti; provi con un altra mail, se � gia registrato per entrare nel sito cliccare su Accedi");
			session.setAttribute("mail", mail);
			s.close();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

		else {

			s.salvaUtente(mail, password);

			Utente u1 = new Utente();

			try {
				Mail.sendEmail(u1.getMail(), "Conferma Mail", generaLinkValidazioneUtente(u1));
			} catch (MessagingException | IOException e) {

				e.printStackTrace();
			}

			session.setAttribute("mail", mail);
			req.setAttribute("mess",
					"La registrazione sar� confermata solo dopo aver cliccato sul link che le abbiamo inviato sulla sua mail");
			s.close();

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

	}

	private String generaLinkValidazioneUtente(Utente utente) {
		String validationPath = "http://localhost:8080/bibliotecawebapp/validazione?utente=";
		return "Per attivare la mail clicca su questo link: " + validationPath + utente.getMail();
	}

}
