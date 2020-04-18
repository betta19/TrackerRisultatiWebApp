package trackerRisultatiWebApp.service;


import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(urlPatterns = {"/validazione"})
public class Validazione extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String mail = req.getParameter("mail");
		Service s;
		
			s = new Service(emf);
			
			s.validaUtente(mail);
			
			
			req.setAttribute("mess", "L'utente "+ mail +" è stato validato");
			s.close();
			req.getRequestDispatcher("/login.jsp").forward(req, resp);

		
	}
}