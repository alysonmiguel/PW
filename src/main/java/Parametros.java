import sun.java2d.pipe.SolidTextRenderer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Parametros", urlPatterns = "/Parametro",
    initParams = {
            @WebInitParam(name = "nome", value = "Alyson"),
            @WebInitParam(name = "email", value = "alyson@gmail.com")
        }

)
public class Parametros extends HttpServlet {

    String nome, email, tads;

    public  void init(){
        ServletConfig config = getServletConfig();
        nome = config.getInitParameter("nome");
        email = config.getInitParameter("email");

        ServletContext context = getServletContext();
        tads = context.getInitParameter("TADS");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Nome: " + nome + "\nEmail: "+ email + "\nTADS: "+ tads);
        }
}
