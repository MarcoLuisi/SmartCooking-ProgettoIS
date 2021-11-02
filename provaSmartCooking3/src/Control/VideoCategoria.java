package Control;


import DAO.MySQLVideoDAO;
import Model.Video;
import Model.VideoRepository;
import Model.VideoRepositoryImpl;

import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "VideoCategoria", value = "/VideoCategoria")
public class VideoCategoria extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String val = request.getParameter("val");
        
        if(!val.equals("Antipasti")&&!val.equals("Primi") && !val.equals("Secondi")
        		&& !val.equals("Contorni") && !val.equals("Dolci")) {
        	throw new IllegalArgumentException("Formato non corretto");
        }


        VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
        List<Video> listVideo= videoRepository.getListByCategoria(val);



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
