package Control;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MySQLVideoDAO;
import Model.VideoRepositoryImpl;

/**
 * Servlet implementation class UpdateVideoAdmin
 */
@WebServlet("/UpdateVideoAdmin")
public class UpdateVideoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVideoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
		 String titolo = request.getParameter("titolo");
		 
		 MySQLVideoDAO dao= new MySQLVideoDAO();

	        Pattern patternTitolo = Pattern.compile("^[a-zA-Z\\s]*$");
	        if(!(patternTitolo.matcher(titolo).find()) || titolo.length()<1 || titolo.length()>65) throw new IllegalArgumentException("Formato non corretto");


	        String tipologia = request.getParameter("tipologia");
	        
	        
	        if(!tipologia.equals("true")&&!tipologia.equals("false")) {
	        	throw new IllegalArgumentException("Formato non corretto");
	        }
	        
	        boolean gratuito;
	        if (tipologia.equals("true")) {
	            gratuito = true;
	        } else gratuito = false;
	        
	        

	        String categoria = request.getParameter("categoria");
	        
	        if(!categoria.equals("Antipasti")&&!categoria.equals("Primi") && !categoria.equals("Secondi")
	        		&& !categoria.equals("Dolci") && !categoria.equals("Contorni")) {
	        	throw new IllegalArgumentException("Formato non corretto");
	        }
	        
	        
	        
	        
	        int idInsegnante = Integer.parseInt(request.getParameter("idInsegnante"));
	        
	        if(idInsegnante!=1 && idInsegnante!=2 && idInsegnante!=3 && idInsegnante!=4
	        		&&idInsegnante!=5 && idInsegnante!=6) {
	        	throw new IllegalArgumentException("Formato non corretto");
	        }
	        
	        
	        String email_admin = request.getParameter("email");
	        if(!email_admin.equals("paoloRossi80@gmail.com")&& !email_admin.equals("micheleBianchi77@gmail.com")){
	        	throw new IllegalArgumentException("Formato non corretto");
	        }
	        
	        String id = request.getParameter("idVideo");
	        int idVideo = Integer.parseInt(id);
	        System.out.println(idVideo);
	        
	        if(!dao.idIdValid(idVideo)) {
	        	throw new IllegalArgumentException("Id video non valido");
	        }
	        
	       videoRepository.modifyVideo(idVideo, titolo, categoria, gratuito, idInsegnante, email_admin);
	        
	    	request.getRequestDispatcher("admin.jsp").forward(request, response);
	}

}
