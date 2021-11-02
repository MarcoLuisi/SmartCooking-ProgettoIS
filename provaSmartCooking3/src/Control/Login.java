package Control;

import DAO.MySQLAdminDAO;
import DAO.MySQLUtenteDAO;
import Model.Admin;
import Model.AdminRepositoryImpl;
import Model.Utente;
import Model.UtenteRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        PrintWriter out = response.getWriter();

        synchronized(session) {

            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String address;

            UtenteRepositoryImpl utenteRepository=new UtenteRepositoryImpl();
            AdminRepositoryImpl adminRepository=new AdminRepositoryImpl();

            List<Utente> utenti = utenteRepository.getList();
            List<Admin> admins = adminRepository.getList();

            Utente user = null;
            Admin admin = null;

            for(Utente e : utenti) {
                if(e.getEmail().compareToIgnoreCase(email) == 0
                        && e.getPassword().compareToIgnoreCase(password) == 0) {

                    user = e;
                }
            }



            for(Admin e : admins) {
                if(e.getEmail().compareToIgnoreCase(email) == 0
                        && e.getPassword().compareToIgnoreCase(password) == 0) {

                    admin = e;
                }
            }



            boolean loggedUtente;
            boolean wrongUtente;

            boolean loggedAdmin;
            boolean wrongAdmin;



            session.setAttribute("user", user);

            if(user!=null){
                session.setAttribute("abbonamento", user.getInizioAbbonamento());
            }

            session.setAttribute("admin", admin);

            if(admin != null) {
                loggedAdmin = true;
                session.setAttribute("isAdminLog", loggedAdmin);
                address = "admin.jsp";
                request.getRequestDispatcher(address).forward(request, response);
            }

            else if(user != null) {
                loggedUtente = true;
                session.setAttribute("isUserLog", loggedUtente);
                address = "utente.jsp";
                request.getRequestDispatcher(address).forward(request, response);
            }

            else{
                wrongUtente = true;
                session.setAttribute("isWrongUtente", wrongUtente);
                wrongAdmin = true;
                session.setAttribute("isWrongAdmin", wrongAdmin);
                address = "login.jsp";
                
                out.println("<script type=\"text/javascript\">");
				   out.println("alert('Login non riuscito');");
				   out.println("location='login.jsp';");
				   out.println("</script>");
               // request.getRequestDispatcher(address).forward(request, response);
            }

        }

    }
}
