package Control;

import DAO.MySQLUtenteDAO;
import DAO.MySQLVideoDAO;
import Model.Utente;
import Model.UtenteRepositoryImpl;
import Model.Video;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "VisualizzazioneListaUtenti", value = "/VisualizzazioneListaUtenti")
public class VisualizzazioneListaUtenti extends HttpServlet {
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UtenteRepositoryImpl utenteRepository = new UtenteRepositoryImpl();
        List<Utente>listUtenti=utenteRepository.getList();

        PrintWriter out = response.getWriter();

        String json = new Gson().toJson(listUtenti);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
