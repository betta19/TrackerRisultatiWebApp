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




@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String mail = req.getParameter("mail");
		String pass = req.getParameter("password");
		HttpSession session = req.getSession();
		Service s = new Service(emf);
		try {
			
		
		
		Utente ut = s.getUtente(mail);

		 if (!gest.controlloUtente(user, pass)) {
				req.setAttribute("messaggio", "mail o password errata. Riprova oppure REGISTRATI");
				req.getRequestDispatcher("login.jsp").forward(req, resp);

		}else if (ut.getTipo().equalsIgnoreCase("admin")) {
	        	session.setAttribute("username", ut.getMail());
	        	session.setAttribute("tipo", ut.getTipo());
				req.getRequestDispatcher("opzioniBiblioteca.jsp").forward(req, resp);

			}  else {
				if (!ut.isActive()) {
					req.setAttribute("messaggio", scriviRispostaUtenteNonAttivo(ut));
					gest.close();
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				} else {
					session.setAttribute("tipo", ut.getTipo());
					session.setAttribute("username", ut.getMail());
					gest.close();
					req.getRequestDispatcher("opzioniCliente.jsp").forward(req, resp);
				}
			}
	
		
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}}
	
private String generaLinkValidazioneUtente(String utente) {
	String validationPath = "http://localhost:8080/bibliotecaWebApp/validazione?utente=";
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


