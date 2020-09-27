package ListenersFiltros;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class InicializaListaUsuarios implements ServletContextListener {

    public InicializaListaUsuarios() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        var u1 = new Usuario(1, "Alyson", "alyson@gmail.com", "12345");
        var u2 = new Usuario(1, "Miguel", "miguel@gmail.com", "67891");
        var u3 = new Usuario(1, "Silva", "silva@gmail.com", "12123");
        var u4 = new Usuario(1, "Araujo", "araujo@gmail.com", "14345");

        List<Usuario> usuariosList = new ArrayList<>();

        usuariosList.add(u1);
        usuariosList.add(u2);
        usuariosList.add(u3);
        usuariosList.add(u4);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("usuarios", usuariosList);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
