package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.Video;
import Model.VideoRepositoryImpl;

/**
 * Servlet implementation class VideoKeyword
 */
@WebServlet("/VideoKeyword")
public class VideoKeyword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoKeyword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 String val = request.getParameter("val");
		 
		 if(val==null || val.length()==0)throw new IllegalArgumentException("Formato non corretto");
		 
		 
	      VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
	        List<Video>listVideo = videoRepository.getListByKeyword(val);


	        PrintWriter out = response.getWriter();

	        String json = new Gson().toJson(listVideo);

	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        out.print(json);
	        out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
