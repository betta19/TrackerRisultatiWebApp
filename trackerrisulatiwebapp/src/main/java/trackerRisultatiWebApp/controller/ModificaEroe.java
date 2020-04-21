package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import trackerRisulatiWebApp.model.Eroe;
import trackerRisultatiWebApp.service.Service;

@MultipartConfig
@WebServlet(name = "modificaEroe", urlPatterns = "/admin/modificaEroe")
public class ModificaEroe extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/login.jsp").forward(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
	String nomeVecchio = req.getParameter("nomeVecchio");
	String nome = req.getParameter("nome");
	String heroPower = req.getParameter("heroPower");
	String heroDescrizione = req.getParameter("heroDescrizione");
	Part image = req.getPart("image");

	Service s = new Service(emf);

	try {
	
			
			s.modificaEroe(nome, nomeVecchio, image, heroDescrizione, heroPower);

	} catch (Exception e) {
		e.printStackTrace();
	}
	
	req.setAttribute("messaggio", "Eroe modificato con successo!");
	s.close();
	req.getRequestDispatcher("/admin/opzioniAdmin.jsp").forward(req, resp);

}
}
