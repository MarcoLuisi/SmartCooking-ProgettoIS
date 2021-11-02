package Control;

import DAO.MySQLUtenteDAO;
import DAO.MySQLVideoDAO;
import Model.Video;
import Model.VideoRepositoryImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.regex.Pattern;

@MultipartConfig
@WebServlet(name = "CaricamentoVideo", value = "/CaricamentoVideo")
public class CaricamentoVideo extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VideoRepositoryImpl videoRepository = new VideoRepositoryImpl();
        String fileName = "";
        String titolo = request.getParameter("titolo");

        Pattern patternTitolo = Pattern.compile("^[a-zA-Z\\s]*$");
        if(!(patternTitolo.matcher(titolo).find()) || titolo.length() < 1 || titolo.length() > 65) throw new IllegalArgumentException("Formato non corretto");


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
        

        int num = videoRepository.addVideo(titolo, categoria, gratuito, idInsegnante, email_admin);
        String nomeFile = Integer.toString(num)+".mp4";
        System.out.println(num);

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">


        InputStream fileContent = filePart.getInputStream();
        File saveFile = new File("C:/Users/luisi/git/SmartCooking-ProgettoIS/provaSmartCooking3/WebContent/video");


        FileOutputStream output = null;
        try {
            /*Create folder (if it doesn't already exist)
            File folder = new File("<path_to_folder>\\<folder_name>");
            if (!folder.exists()) {
                folder.mkdirs();
            }*/
            // Create output file
            output = new FileOutputStream(new File(saveFile, nomeFile));
            // Write data from input stream to output file.
            int bytesRead = 0;
            byte[] buffer = new byte[4096];
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
            // Also close InputStream if no longer needed.
            try {
                if (fileContent != null) {
                    fileContent.close();
                }
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }



        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }
}
