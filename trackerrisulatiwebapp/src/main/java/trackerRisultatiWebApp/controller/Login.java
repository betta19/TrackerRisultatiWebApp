package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisulatiWebApp.model.Utente;
import trackerRisultatiWebApp.service.Service;
import trackerRisultatiWebApp.service.Utility;




@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String mail = req.getParameter("mail");
		String pass = Utility.encrypt(req.getParameter("password"), "Mary has one ca1");
		HttpSession session = req.getSession();
		Service s = new Service(emf);
		
		Utente ut = s.getUtente(mail, pass);

		 if (ut == null) {
				req.setAttribute("mess", "mail o password errata. Riprova oppure REGISTRATI");
				req.getRequestDispatcher("login.jsp").forward(req, resp);

		}else if (ut.getTipo().equalsIgnoreCase("admin")) {
	        	session.setAttribute("utente", ut);
//				session.setAttribute("tipo", ut.getTipo());
				req.getRequestDispatcher("/admin/opzioniAdmin.jsp").forward(req, resp);

			}  else {
				if (!ut.isActive()) {
					req.setAttribute("mess", scriviRispostaUtenteNonAttivo(ut));
					s.close();
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				} else {
//					session.setAttribute("mail", ut.getMail());
//					session.setAttribute("tipo", ut.getTipo());
					session.setAttribute("utente", ut);
					session.setAttribute("listaEroi", s.stampaListaEroi());
					session.setAttribute("listaComp", s.stampaListaComp());
			//		s.close();
					req.getRequestDispatcher("/cliente/opzioniCliente.jsp").forward(req, resp);
				}
			}
	
		
}
	
private String generaLinkValidazioneUtente(String utente) {
	String validationPath = "http://localhost:8080/trackerrisulatiwebapp/validazione?utente=";
	return "Per attivare la mail clicca su questo link: " + validationPath + utente;
}

private String scriviRispostaUtenteNonAttivo(Utente utente) {
	String mailUtente = utente.getMail();
	int indexOf = mailUtente.indexOf('@');
	String parteFinaleMail = mailUtente.substring(indexOf);

	String primiDueCaratteri = mailUtente.substring(0, 3);
	String mailFinale = primiDueCaratteri + contaX(indexOf - 2) + parteFinaleMail;
	return "L'utente " + mailFinale + " non ha ancora validato l'email";
}

private String contaX(int numeri) {
	String x = "";
	for (int i = 0; i < numeri; i++) {
		x += "*";
	}
	return x;
}

}


