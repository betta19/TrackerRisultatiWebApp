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

import trackerRisultatiWebApp.service.Service;

@WebServlet(name = "gestione", urlPatterns = { "/admin/gestioneAdmin", "/gestioneAdmin" })
public class Admin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/home.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String azione = req.getParameter("azione");
		HttpSession session = req.getSession();
		Service s = new Service(emf);

		if (azione.equalsIgnoreCase("Aggiungi eroe")) {

			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/aggiungiEroe.jsp").forward(req, resp);
		}
		
		else if (azione.equalsIgnoreCase("Aggiungi composizione")) {

			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();

			req.getRequestDispatcher("/aggiungiComp.jsp").forward(req, resp);
		} 
		
		else if (azione.equalsIgnoreCase("Logout")) {

			session.invalidate();
			s.close();

			resp.sendRedirect(req.getContextPath() + "/");
		}
	}

}
