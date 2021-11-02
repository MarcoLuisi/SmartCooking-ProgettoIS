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

public class ServletRegistrazione extends Mockito {
  private Registrazione servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new Registrazione();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void NomeVuoto() throws ServletException, IOException  {
    
	  request.addParameter("nome", "");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  
  @Test
  public void NomeMaggiore20() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marcoooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  
  @Test
  public void NomeFormatoSbagliato() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marc0");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  
  @Test
  public void CognomeVuoto() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  @Test
  public void CognomeMaggiore20() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  }
  
  
  
  @Test
  public void CognomeFormatoSbagliato() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Ross1");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void EmailVuota() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void EmailMaggiore50() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRosssssssssssssssssssssssssssssssssiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  
  
  @Test
  public void EmailFormatoSbagliato() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossigmail-com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void EmailEsistente() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","robertoRossi60@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  
  @Test
  public void TelefonoMinore10() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail-com");
	  request.addParameter("telefono", "3334534");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void TelefonoFormatoSbagliato() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail-com");
	  request.addParameter("telefono", "33345534OO");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  
  @Test
  public void DataNascitaMinore10() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail-com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void DataNascitFormatoSbagliato() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail-com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11/11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
  
  @Test
  public void PasswordMinore8() throws ServletException, IOException  {
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd123");
	  request.addParameter("email","MarcoRossi@gmail-com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
    assertThrows(IllegalArgumentException.class, () -> {
      servlet.doPost(request, response);
    });
  } 
 
  
  @Test
  public void registrazioneNuovoUtente() throws ServletException, IOException  {
    
	  request.addParameter("nome", "Marco");
	  request.addParameter("cognome", "Rossi");
	  request.addParameter("password","abcd1234");
	  request.addParameter("email","MarcoRossi@gmail.com");
	  request.addParameter("telefono", "3334553411");
	  request.addParameter("dataNascita", "2019-11-11");
      servlet.doPost(request, response);
  } 
  
  
  
 
}
