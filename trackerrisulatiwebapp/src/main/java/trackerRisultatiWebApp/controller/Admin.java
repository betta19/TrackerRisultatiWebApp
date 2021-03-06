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

@WebServlet(urlPatterns = { "/admin/gestioneAdmin", "/gestioneAdmin" })
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

			req.getRequestDispatcher("/admin/aggiungiEroe.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Aggiungi composizione")) {

			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();

			req.getRequestDispatcher("/admin/aggiungiComp.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Gestione Eroe")) {
			req.setAttribute("listaEroi", s.stampaListaEroi());
			req.getRequestDispatcher("/admin/listaEroiAdmin.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Gestione Comp")) {
			req.setAttribute("listaComp", s.stampaListaComp());
			req.getRequestDispatcher("/admin/listaComp.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Logout")) {

			session.invalidate();
			s.close();

			resp.sendRedirect(req.getContextPath() + "/");
		} else if (azione.equalsIgnoreCase("Elimina")) {
			boolean eliminazione = s.eliminaEroe(req.getParameter("nomeE"));
			if (eliminazione) {
				
			req.setAttribute("listaEroi", s.stampaListaEroi());
			req.setAttribute("messaggio", "Eroe eliminato con successo");
			s.close();
			req.getRequestDispatcher("/admin/listaEroiAdmin.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("listaEroi", s.stampaListaEroi());
				req.setAttribute("messaggio", "Un utente sta giocando con questo eroe, impossibile eliminarlo");
				s.close();
				req.getRequestDispatcher("/admin/listaEroiAdmin.jsp").forward(req, resp);
			}
		} else if (azione.equalsIgnoreCase("Modifica")) {
			
			req.setAttribute("eroi", s.getEroe(req.getParameter("nomeE")));
		
			s.close();
			req.getRequestDispatcher("/admin/effettuaModificaEroe.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Elimina Comp")) {
		boolean eliminaC=	s.eliminaComp(req.getParameter("nomeC"));
		if (eliminaC) {
			
			req.setAttribute("messaggio", "Composizione eliminata con successo");
			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();
			req.getRequestDispatcher("/admin/listaComp.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("messaggio", "Un utente sta giocando con questa composizione, impossibile eliminarla");
			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();
			req.getRequestDispatcher("/admin/listaComp.jsp").forward(req, resp);
		}
		} else if (azione.equalsIgnoreCase("Modifica Comp")) {
			
			req.setAttribute("comp",s.getComp(req.getParameter("nomeC")));
			
			s.close();
			req.getRequestDispatcher("/admin/modificaComp.jsp").forward(req, resp);
		}
	}
}
