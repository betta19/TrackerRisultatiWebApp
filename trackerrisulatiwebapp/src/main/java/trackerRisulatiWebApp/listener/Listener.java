package trackerRisulatiWebApp.listener;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class Listener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("emf");
	    sce.getServletContext().setAttribute("emf", emfactory);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
	    emf.close();
		
	}

}
