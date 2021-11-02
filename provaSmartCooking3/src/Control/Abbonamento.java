package Control;

import DAO.MySQLUtenteDAO;
import Model.UtenteRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "Abbonamento", value = "/Abbonamento")
public class Abbonamento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UtenteRepositoryImpl utenteRepository = new UtenteRepositoryImpl();

        String email = request.getParameter("email");
        String durata = request.getParameter("durata");
        
        if (utenteRepository.getUtente(email)==null) {
        	throw new IllegalArgumentException("Utente non presente");
        }
        
        if(!durata.equals("mensile") && !durata.equals("annuale")) {
        	throw new IllegalArgumentException("Formato non corretto");
        }

        utenteRepository.abbonamentoUtente(email, durata);

        response.sendRedirect("Logout");

    }
}
