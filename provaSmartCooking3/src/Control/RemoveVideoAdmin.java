package Control;

import DAO.MySQLVideoDAO;
import Model.Video;
import Model.VideoRepositoryImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RemoveVideoAdmin", value = "/RemoveVideoAdmin")
public class RemoveVideoAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	 PrintWriter out = response.getWriter();
        
    	VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();

        String titolo = request.getParameter("titolo");
        
        if (videoRepository.getVideo(titolo)==null) {
        	throw new IllegalArgumentException("Video non presente");
        }
        

        videoRepository.removeVideo(titolo);
        
        out.println("<script type=\"text/javascript\">");
		   out.println("alert('Eliminazione avvenuta con successo');");
		   out.println("location='admin.jsp';");
		   out.println("</script>");

       // request.getRequestDispatcher("admin.jsp").forward(request, response);

    }
}
