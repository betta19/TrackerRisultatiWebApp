package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javassist.expr.NewArray;
import trackerRisulatiWebApp.model.Partita;
import trackerRisulatiWebApp.model.Utente;
import trackerRisultatiWebApp.service.Service;

@WebServlet(urlPatterns = { "/cliente/creaPartita", "/creaPartita" })
public class CreaPartita extends HttpServlet {

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
		int rank = Integer.parseInt(req.getParameter("rank"));
		try {
				int punti = Integer.parseInt(req.getParameter("punti"));
				Utente u = (Utente) session.getAttribute("utente");
				Partita p = s.salvaPartita(req.getParameter("eroe"), req.getParameter("comp"), rank, req.getParameter("note"), punti,
						u);
			
//				for (Partita pa : u.getListaPartita()) {
//					System.out.println(pa);
//				}
				
				req.setAttribute("mess", "Partita creata con successo!");
				s.close();
				req.getRequestDispatcher("/cliente/opzioniCliente.jsp").forward(req, resp);	
		} catch (NumberFormatException e) {
			req.setAttribute("mess", "Impossibile creare senza impostare il punteggio");
//			req.setAttribute("listaEroi", s.stampaListaEroi());
//			req.setAttribute("listaComp", s.stampaListaComp());
				s.close();
				req.getRequestDispatcher("/cliente/partita.jsp").forward(req, resp);
		}
		
	}
}
