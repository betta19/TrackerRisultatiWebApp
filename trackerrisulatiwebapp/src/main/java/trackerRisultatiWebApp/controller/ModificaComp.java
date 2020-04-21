package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import trackerRisultatiWebApp.service.Service;

@WebServlet(name = "modificaComp", urlPatterns = "/admin/modificaComp")
public class ModificaComp extends HttpServlet{

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/login.jsp").forward(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	String nomeVecchioC = req.getParameter("nomeVecchioC");
	String nome = req.getParameter("nome");

	Service s = new Service(emf);

	try {
	
			
			s.modificaComp(nome, nomeVecchioC);

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	req.setAttribute("messaggio", "Composizione modificata con successo!");
	s.close();
	req.getRequestDispatcher("/admin/opzioniAdmin.jsp").forward(req, resp);

}
}
