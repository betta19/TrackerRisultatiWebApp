package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import trackerRisultatiWebApp.service.Service;

@MultipartConfig
@WebServlet(name = "aggiungiEroe", urlPatterns = "/admin/aggiungiEroe")

public class AggiungiEroe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		String nome = req.getParameter("nome");
		int heroPower = Integer.parseInt(req.getParameter("heroPower"));
		String heroDescrizione = req.getParameter("heroDescrizione");
		Part image = req.getPart("image");

		Service s = new Service(emf);

		try {

			if (!s.checkNomeEroe(nome)) {

				s.salvaEroe(nome, image, heroDescrizione, heroPower);

				s.close();
			} else {

				req.setAttribute("mess", "Eroe già presente");
				s.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.setAttribute("listaEroi", s.stampaListaEroi());
		req.getRequestDispatcher("/aggiungiEroe.jsp").forward(req, resp);

	}
}
