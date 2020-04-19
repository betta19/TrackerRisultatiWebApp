package trackerRisultatiWebApp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "indietro", urlPatterns = { "/admin/indietro", "/indietro" })
public class TornaIndietroAdmin extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect(req.getContextPath() + "/opzioniAdmin.jsp");

    }
}
