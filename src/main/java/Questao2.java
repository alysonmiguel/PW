import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/Questao2")
public class Questao2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String repeteSenha = request.getParameter("repeteSenha");

        boolean achouNumero = false;

        if(!senha.isEmpty()){
            for (char c : senha.toCharArray()) {
                if(c >= '0' && c <= '9'){
                    achouNumero = true;
                }
            }
        }

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || repeteSenha.isEmpty()){
            response.getWriter().println("Por favor, Preencha todos os campos :)");
        }else if (senha.length() <= 5 || !achouNumero ){
            response.getWriter().println("Sua senha deve possui mais de 5 caracteres e possui números");
        }else if (!senha.equals(repeteSenha)){
            response.getWriter().println("Senhas diferentes");
        }else{
            response.getWriter().println("Cadastro realizado");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
