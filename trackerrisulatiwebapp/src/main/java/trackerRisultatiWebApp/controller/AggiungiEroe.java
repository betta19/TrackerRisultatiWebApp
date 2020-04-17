package trackerRisultatiWebApp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


import trackerRisultatiWebApp.service.Service;

@WebServlet(name = "aggiungiEroe", urlPatterns = "/admin/aggiungiEroe")

public class AggiungiEroe extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String heroPower = req.getParameter("heroPower");
		String heroDescrizione = req.getParameter("heroDescrizione");
		Part image = req.getPart("image");
		HttpSession session = req.getSession();
		
		Service s;
		
		//try {
			
		//	req.setAttribute("listaLibri", gest.getLibri(l));
			//gest.close();
		//} catch (ClassNotFoundException | SQLException e) {
		//	e.printStackTrace();
	//	}
		//req.getRequestDispatcher("/lista_libri.jsp").forward(req, resp);
	
}
}
