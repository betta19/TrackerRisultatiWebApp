package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisulatiWebApp.model.Comp;
import trackerRisultatiWebApp.service.Service;

@WebServlet(urlPatterns = { "/admin/aggiungiComp", "/aggiungiComp" })
public class AggiungiComp extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/login.jsp").forward(req, resp);
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	String nome = req.getParameter("nome");
	Service s;
	try {
		s = new Service(emf);
		Comp comp = s.checkNomeComp(nome);
		if(comp == null) {
			s.salvaComp(nome);
			req.setAttribute("mess", "Composizione aggiunta!");
		} else {
			req.setAttribute("mess", "Composizione gi� esistente!");
		}
		
		
		req.setAttribute("listaComp", s.stampaListaComp());
		s.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	req.getRequestDispatcher("/admin/aggiungiComp.jsp").forward(req, resp);

}
	}

