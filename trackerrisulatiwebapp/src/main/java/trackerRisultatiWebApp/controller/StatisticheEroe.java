package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisulatiWebApp.model.Utente;
import trackerRisultatiWebApp.service.Service;

@WebServlet(urlPatterns = { "/cliente/statisticheEroe", "/statisticheEroe" })
public class StatisticheEroe extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/home.jsp").forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	HttpSession session = req.getSession();
	Service s = new Service(emf);
	String nomeEroe = req.getParameter("eroe");
	long totaleEroe = s.getTotalePartiteEroe(nomeEroe);
	 Utente u = (Utente) session.getAttribute("utente");
		req.setAttribute("listaPartite", s.stampaListaPartite(u.getMail()));
		long totale = s.getTotalePartite(u.getMail());
		req.setAttribute("totale", totale);
		int top4 = s.getTop4(u.getMail());
		req.setAttribute("top4", top4);
		int win = s.getWin(u.getMail());
		req.setAttribute("win", win);
	req.setAttribute("totaleEroe", totaleEroe);
	req.setAttribute("listaEroi", s.stampaListaEroi());
	s.close();
	req.getRequestDispatcher("/statistiche.jsp").forward(req, resp);
	
	}
}
