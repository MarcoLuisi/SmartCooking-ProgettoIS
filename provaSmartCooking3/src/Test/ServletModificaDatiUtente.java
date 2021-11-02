package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertThrows;

import Control.*;
import Model.*;
import DAO.*;

import java.io.IOException;
import java.security.SecureRandom;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


public class ServletModificaDatiUtente extends Mockito {
	  private ModificaDatiUtente servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new ModificaDatiUtente();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	  }
	  
	  @Test
	  public void NomeVuoto() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "");
		  request.addParameter("cognome", "Rossi");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  
	  @Test
	  public void NomeMaggiore20() throws ServletException, IOException  {
	    
		   
		  request.addParameter("nome", "Roooooooooooooooooooooooooooooooooooooooooooooooooooooooobbbbbbbbbbbb");
		  request.addParameter("cognome", "Rossi");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  
	  @Test
	  public void NomeFormatoSbagliato() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "R0b");
		  request.addParameter("cognome", "Rossi");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  
	  @Test
	  public void CognomeVuoto() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  @Test
	  public void CognomeMaggiore20() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Rossssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  }
	  
	  
	  
	  @Test
	  public void CognomeFormatoSbagliato() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ros5");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567891");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	 
	  
	  
	  @Test
	  public void TelefonoMinore10() throws ServletException, IOException  {
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "123456789");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  @Test
	  public void TelefonoFormatoSbagliato() throws ServletException, IOException  {
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "123456789S");
		  request.addParameter("dataNascita", "1980-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  
	  @Test
	  public void DataNascitaMinore10() throws ServletException, IOException  {
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567892");
		  request.addParameter("dataNascita", "1979-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  @Test
	  public void DataNascitFormatoSbagliato() throws ServletException, IOException  {
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","12345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567892");
		  request.addParameter("dataNascita", "1979-10//10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	  
	  @Test
	  public void PasswordMinore8() throws ServletException, IOException  {
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","2345678");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "1234567892");
		  request.addParameter("dataNascita", "1979-10-10");
	    assertThrows(IllegalArgumentException.class, () -> {
	      servlet.doPost(request, response);
	    });
	  } 
	 
	  
	  @Test
	  public void modificaUtente() throws ServletException, IOException  {
	    
		  request.addParameter("nome", "Rob");
		  request.addParameter("cognome", "Ross");
		  request.addParameter("password","password");
		  request.addParameter("email","robertoRossi60@gmail.com");
		  request.addParameter("telefono", "3334553411");
		  request.addParameter("dataNascita", "1979-10-10");
	      servlet.doPost(request, response);
	  } 
	  

}
