package Control;

import DAO.MySQLUtenteDAO;
import Model.Utente;
import Model.UtenteRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(name = "ModificaDatiUtente", value = "/ModificaDatiUtente")
public class ModificaDatiUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UtenteRepositoryImpl utenteRepository = new UtenteRepositoryImpl();
        MySQLUtenteDAO dao = new MySQLUtenteDAO();
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        String dataNascita = request.getParameter("dataNascita");
        
       
      
        
        Pattern patternNome = Pattern.compile("^[A-Za-z]+$");
        Pattern patternCognome = Pattern.compile("^[a-zA-Z\\s]*$");
        Pattern patternEmail =Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$");
        Pattern patternTelefono = Pattern.compile("^[0-9]{10}$");
        Pattern patternDataNascita = Pattern.compile("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
        
        if(!(patternNome.matcher(nome).find()) || nome.length() < 1 || nome.length() > 20) throw new IllegalArgumentException("Formato nome non corretto");
        if(!(patternCognome.matcher(cognome).find()) || cognome.length() < 1 || cognome.length() > 20) throw new IllegalArgumentException("Formato cognome non corretto");
        if(password.length()<8)throw new IllegalArgumentException("Formato password non corretto");
     
      
        if(!(patternTelefono.matcher(telefono).find()) || telefono.length()<10)throw new IllegalArgumentException("Formato telefono non corretto");
        if(!(patternDataNascita.matcher(dataNascita).find()) || dataNascita.length()<10)throw new IllegalArgumentException("Formato data non corretto");

        utenteRepository.updateUtente(new Utente(email, password, nome, cognome, dataNascita, telefono, "", ""));

        response.sendRedirect("Logout");
    }
}
