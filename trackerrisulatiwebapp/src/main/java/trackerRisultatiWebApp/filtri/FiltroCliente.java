package trackerRisultatiWebApp.filtri;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trackerRisulatiWebApp.model.Utente;

@WebFilter(filterName = "cliente", urlPatterns = "/cliente/*")
public class FiltroCliente implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String loginURI = req.getContextPath() + "/";
		
		try {
		HttpSession session = (HttpSession) req.getSession();
		Utente utente = (Utente) session.getAttribute("utente");

		boolean loggedIn = session != null && utente.getMail() != null && utente.getTipo().equals("cliente");
		boolean loginRequest = req.getRequestURI().equals(loginURI);

		if (loggedIn || loginRequest) {
			System.out.println("sono nel filtro");
			chain.doFilter(request, response);
		} else {
			System.out.println("fabio72");
			resp.sendRedirect(loginURI);
		}
	}
	catch (NullPointerException | IOException | ServletException e) {
		resp.sendRedirect(loginURI);
		e.printStackTrace();
	}
	}

	@Override
	public void destroy() {

	}

}
