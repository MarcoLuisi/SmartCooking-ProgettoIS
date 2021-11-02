package Control;

import DAO.MySQLUtenteDAO;
import DAO.MySQLVideoDAO;
import Model.Utente;
import Model.Video;
import Model.VideoRepositoryImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "VisualizzazioneListaVideo", value = "/VisualizzazioneListaVideo")
public class VisualizzazioneListaVideo extends HttpServlet {
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
        List<Video>listVideo = videoRepository.getList();


        PrintWriter out = response.getWriter();

        String json = new Gson().toJson(listVideo);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
