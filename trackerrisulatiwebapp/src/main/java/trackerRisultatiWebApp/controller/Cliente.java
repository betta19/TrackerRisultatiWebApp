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
public class Cliente extends HttpServlet {

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
		Utente u = (Utente) session.getAttribute("utente");

		if (azione.equalsIgnoreCase("Crea Partita")) {
			req.setAttribute("listaEroi", s.stampaListaEroi());
			req.setAttribute("listaComp", s.stampaListaComp());
			s.close();

			req.getRequestDispatcher("/cliente/partita.jsp").forward(req, resp);
		}

		else if (azione.equalsIgnoreCase("Visualizza statistiche partita")) {

			req.setAttribute("ratingIniziale", u.getRatingIniziale());
			req.setAttribute("currentRating", s.calcoloCurrentRating(u));
			long totaleEroe = s.getTotalePartiteEroe("Seleziona", "Tutte");
			req.setAttribute("totaleEroe", totaleEroe);
			req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
			long totale = s.getTotalePartite(u.getMail());
			req.setAttribute("listaComp", s.stampaListaComp());
			req.setAttribute("totale", totale);
			int top4 = s.getTop4(u.getMail());
			req.setAttribute("top4", top4);
			int win = s.getWin(u.getMail());
			req.setAttribute("win", win);
			int top4Eroe = s.getTop4Eroe("Seleziona", "Tutte");
			int winEroe = s.getWinEroe("Seleziona", "Tutte");
			req.setAttribute("winEroe", winEroe);
			req.setAttribute("top4Eroe", top4Eroe);
			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/cliente/statistiche.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Lista Eroi")) {

			req.setAttribute("listaEroi", s.stampaListaEroi());
			s.close();

			req.getRequestDispatcher("/cliente/listaEroi.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Vedi statistiche eroe")) {

			String nomeEroe = req.getParameter("eroe");
			String nomeComp = req.getParameter("comp");
			if (nomeComp.equals("Tutte")) {
				long totaleEroe = s.getTotalePartiteEroeSolo(nomeEroe);
				req.setAttribute("ratingIniziale", u.getRatingIniziale());
				req.setAttribute("currentRating", s.calcoloCurrentRating(u));
				req.setAttribute("listaEroi", s.stampaListaEroi());
				req.setAttribute("listaComp", s.stampaListaComp());
				req.setAttribute("totaleEroe", totaleEroe);
				req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
				long totale = s.getTotalePartite(u.getMail());
				req.setAttribute("totale", totale);
				int top4 = s.getTop4(u.getMail());
				req.setAttribute("top4", top4);
				int win = s.getWin(u.getMail());
				int winEroe = s.getWinEroeSolo(nomeEroe);
				req.setAttribute("winEroe", winEroe);
				int top4Eroe = s.getTop4EroeSolo(nomeEroe);
				req.setAttribute("top4Eroe", top4Eroe);
				req.setAttribute("win", win);
				req.setAttribute("eroe", nomeEroe);
				req.setAttribute("comp", nomeComp);
				req.setAttribute("listaEroi", s.stampaListaEroi());
			} else {
				long totaleEroe = s.getTotalePartiteEroe(nomeEroe, nomeComp);
				req.setAttribute("ratingIniziale", u.getRatingIniziale());
				req.setAttribute("currentRating", s.calcoloCurrentRating(u));
				req.setAttribute("listaEroi", s.stampaListaEroi());
				req.setAttribute("listaComp", s.stampaListaComp());
				req.setAttribute("totaleEroe", totaleEroe);
				req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
				long totale = s.getTotalePartite(u.getMail());
				req.setAttribute("totale", totale);
				int top4 = s.getTop4(u.getMail());
				req.setAttribute("top4", top4);
				int win = s.getWin(u.getMail());
				int winEroe = s.getWinEroe(nomeEroe, nomeComp);
				req.setAttribute("winEroe", winEroe);
				int top4Eroe = s.getTop4Eroe(nomeEroe, nomeComp);
				req.setAttribute("top4Eroe", top4Eroe);
				req.setAttribute("win", win);
				req.setAttribute("eroe", nomeEroe);
				req.setAttribute("comp", nomeComp);
				req.setAttribute("listaEroi", s.stampaListaEroi());
			}
			s.close();
			req.getRequestDispatcher("/cliente/statistiche.jsp").forward(req, resp);
		} else if (azione.equalsIgnoreCase("Logout")) {

			session.invalidate();
			s.close();

			resp.sendRedirect(req.getContextPath() + "/");

		}
	}

}
