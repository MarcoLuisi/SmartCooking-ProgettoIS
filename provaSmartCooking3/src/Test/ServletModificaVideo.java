package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



import static org.junit.jupiter.api.Assertions.assertThrows;

import Control.*;
import Model.*;
import DAO.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletModificaVideo extends Mockito{
	

	
	  private UpdateVideoAdmin servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  
	  
	  @Before
	  public void setUp() {
	    servlet = new UpdateVideoAdmin();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void TitoloVuoto() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  @Test
	  public void TitoloMaggioredi65() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttteeelllleeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee                             ddddiiiiiiiii            Beneedeeeeeetttttaaaaaaaaaaaaaaaaaa                           Rossssssssssiiiiiiiiiiiiii");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  @Test
	  public void TitoloFormatoNonValido() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Fr1tt3ll3 di B3nedetta Ross1");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  @Test
	  public void TipologiaNonValida() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "Non gratuito");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  
	  
	  @Test
	  public void CategoriaNonValida() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "frittelle");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  
	  
	  @Test
	  public void idInsegnanteNonValido() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "9");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  @Test
	  public void EmailAdminNonValida() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","UgoRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  
	  
	  @Test
	  public void IdVideoNonValido() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "39");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  
	  @Test
	  public void ModificaVideo() throws ServletException, IOException  {
	    
		  request.addParameter("titolo", "Frittelle di Benedetta Rossi");
		  request.addParameter("categoria", "Secondi");
		  request.addParameter("tipologia", "false");
		  request.addParameter("idInsegnante", "2");
		  request.addParameter("email","paoloRossi80@gmail.com");
		  request.addParameter("idVideo", "3");
		
	    
	      servlet.doPost(request, response);
	   
	  } 
	  
	  
	  
	  /*
	  @Test
	  public void caricaVideo() throws ServletException, IOException  {
		  request.addParameter("titolo", "Pasta col sugo di Alfonso Pepe");
		  request.addParameter("categoria", "Primi");
		  request.addParameter("tipologia", "true");
		  request.addParameter("idInsegnante", "1");
		  request.addParameter("email","paoloRossi80@gmail.com");
		
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
		*/
}
