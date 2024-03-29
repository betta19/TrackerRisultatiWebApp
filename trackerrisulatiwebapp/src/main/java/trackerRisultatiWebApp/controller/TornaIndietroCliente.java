package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "tornaIndietro", urlPatterns = { "/cliente/tornaIndietro" })
public class TornaIndietroCliente extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		session.getAttribute("mail");
		
		resp.sendRedirect(req.getContextPath() + "/cliente/opzioniCliente.jsp");
		
}
}
