/*
package Control;

import DAO.MySQLVideoDAO;
import Model.Video;
import Model.VideoRepositoryImpl;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "VideoInsegnante", value = "/VideoInsegnante")
public class VideoInsegnante extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String val = request.getParameter("val");
        String nome, cognome;


        int idx = val.lastIndexOf(' ');

        
        if(!val.equals("Alfonso Pepe") && !val.equals("Benedetta Rossi")
        		&& !val.equals("Sonia Peronaci") && !val.equals("Stefano Barbato")
        		&& !val.equals("Max Mariola") && !val.equals("Luca Pappagallo")) {
        	throw new IllegalArgumentException("Formato non corretto");
        }

        nome = val.substring(0, idx);
        cognome  = val.substring(idx + 1);




        VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
        List<Video>listVideo = videoRepository.getListByInsegnante(nome, cognome);


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
*/
