package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "home", urlPatterns = "/home")
public class Home extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String azione = req.getParameter("azione");

		if ("Entra".equalsIgnoreCase(azione)) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else if ("Registrati".equalsIgnoreCase(azione)) {

			req.getRequestDispatcher("registrazione.jsp").forward(req, resp);
	}

}
}