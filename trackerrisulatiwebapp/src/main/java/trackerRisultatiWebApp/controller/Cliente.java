package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisultatiWebApp.service.Service;

@WebServlet(urlPatterns = { "/cliente/gestioneCliente", "/gestioneCliente" })
public class Cliente extends HttpServlet{
	
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

		if (azione.equalsIgnoreCase("Crea Partita")) {

			
			s.close();

			req.getRequestDispatcher("/partita.jsp").forward(req, resp);
		}
		
		else if (azione.equalsIgnoreCase("Visualizza statistiche partita")) {

			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();

			req.getRequestDispatcher("/statistiche.jsp").forward(req, resp);
		} 
		else if (azione.equalsIgnoreCase("Lista Eroi")) {

			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/listaEroi.jsp").forward(req, resp);
		}
		
		else if (azione.equalsIgnoreCase("Logout")) {

			session.invalidate();
			s.close();

			resp.sendRedirect(req.getContextPath() + "/");
		}
	}

	}
	


