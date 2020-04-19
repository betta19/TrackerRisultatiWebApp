package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisulatiWebApp.model.Eroe;
import trackerRisulatiWebApp.model.Utente;
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
			req.setAttribute("listaEroi", s.stampaListaEroi());
			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();

			req.getRequestDispatcher("/partita.jsp").forward(req, resp);
		}
		
		else if (azione.equalsIgnoreCase("Visualizza statistiche partita")) {
            Utente u = (Utente) session.getAttribute("utente");
            long totaleEroe = s.getTotalePartiteEroe("Seleziona");
            req.setAttribute("totaleEroe", totaleEroe);
			req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
			long totale = s.getTotalePartite(u.getMail());
			req.setAttribute("totale", totale);
			int top4 = s.getTop4(u.getMail());
			req.setAttribute("top4", top4);
			int win = s.getWin(u.getMail());
			req.setAttribute("win", win);
			int top4Eroe = s.getTop4Eroe("Seleziona");
			int winEroe = s.getWinEroe("Seleziona");
			req.setAttribute("winEroe", winEroe);
			req.setAttribute("top4Eroe", top4Eroe);
			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/statistiche.jsp").forward(req, resp);
		} 
		else if (azione.equalsIgnoreCase("Lista Eroi")) {

			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/listaEroi.jsp").forward(req, resp);
		}
		else if (azione.equalsIgnoreCase("Vedi statistiche")) {
           
            String nomeEroe = req.getParameter("eroe");
        	long totaleEroe = s.getTotalePartiteEroe(nomeEroe);
			req.setAttribute("listaEroi", s.stampaListaEroi());
			req.setAttribute("totaleEroe", totaleEroe);
			 Utente u = (Utente) session.getAttribute("utente");
				req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
				long totale = s.getTotalePartite(u.getMail());
				req.setAttribute("totale", totale);
				int top4 = s.getTop4(u.getMail());
				req.setAttribute("top4", top4);
				int win = s.getWin(u.getMail());
				int winEroe = s.getWinEroe(nomeEroe);
				req.setAttribute("winEroe", winEroe);
				int top4Eroe = s.getTop4Eroe(nomeEroe);
				req.setAttribute("top4Eroe", top4Eroe);
				req.setAttribute("win", win);
				req.setAttribute("eroe", nomeEroe);
				req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();
			req.getRequestDispatcher("/statistiche.jsp").forward(req, resp);
		} 
		else if (azione.equalsIgnoreCase("Logout")) {

			session.invalidate();
			s.close();

			resp.sendRedirect(req.getContextPath() + "/");
			
		}
	}

	}
	

